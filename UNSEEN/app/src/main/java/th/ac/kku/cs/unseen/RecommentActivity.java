package th.ac.kku.cs.unseen;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static th.ac.kku.cs.unseen.mapLocationDB.BASE_URL_UNSEEN;


public class RecommentActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<mapLocationDB> mData;
    private LocationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomment);
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new LocationAdapter(mData);
        mRecyclerView.setLayoutManager(new GridLayoutManager(RecommentActivity.this,2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        mapLocationDB location = mData.get(position);
                        Toast.makeText(getApplicationContext(),location.getName_loca() + "is selected!",
                                Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                Intent intent = new Intent(RecommentActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            case R.id.recom:
                Intent intent1 = new Intent(RecommentActivity.this, RecommentActivity.class);
                startActivity(intent1);
                return true;
            case R.id.temple:
                Intent intent2 = new Intent(RecommentActivity.this, TempleActivity.class);
                startActivity(intent2);
                return true;
            case R.id.food:
                Intent intent3 = new Intent(RecommentActivity.this, TempleActivity.class);
                startActivity(intent3);
                return true;
            case R.id.nightmk:
                Intent intent4 = new Intent(RecommentActivity.this, NightmarketActivity.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onResume() {
        super.onResume();
        feeddata();
    }

    private void feeddata() {
        new FeedAsyn().execute(BASE_URL_UNSEEN + "query.php");
    }
    private class FeedAsyn extends AsyncTask<String ,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient _OkHttpClient = new OkHttpClient();
                Request _request = new Request.Builder().url(strings[0]).get().build();
                Response _response = _OkHttpClient.newCall(_request).execute();
                String _result = _response.body().string();
                Gson _gson = new Gson();
                Type type = new TypeToken<List<mapLocationDB>>() {
                }.getType();
                mData = _gson.fromJson(_result, type);
                return "successfully";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                mRecyclerView.setAdapter(new LocationAdapter(mData));
            } else {
                Toast.makeText(getApplicationContext(), "feed data failure",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
