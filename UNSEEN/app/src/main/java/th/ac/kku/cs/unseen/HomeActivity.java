package th.ac.kku.cs.unseen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            case R.id.recom:
                Intent intent1 = new Intent(HomeActivity.this, RecommentActivity.class);
                startActivity(intent1);
                return true;
            case R.id.temple:
                Intent intent2 = new Intent(HomeActivity.this, TempleActivity.class);
                startActivity(intent2);
                return true;
            case R.id.food:
                Intent intent3 = new Intent(HomeActivity.this, TempleActivity.class);
                startActivity(intent3);
                return true;
            case R.id.nightmk:
                Intent intent4 = new Intent(HomeActivity.this, NightmarketActivity.class);
                startActivity(intent4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
