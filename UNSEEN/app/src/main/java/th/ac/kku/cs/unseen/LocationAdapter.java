package th.ac.kku.cs.unseen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    private List<mapLocationDB> locationList;
        View itemView;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name_loca , data_loca;
        public ImageView imageLoca;

        public MyViewHolder(View view) {
            super(view);
            name_loca = (TextView) view.findViewById(R.id.name_loca);
            data_loca = (TextView)view.findViewById(R.id.data_loca);
            imageLoca = view.findViewById(R.id.imageLoca);
        }
    }

    public LocationAdapter(List<mapLocationDB> locationList) {
        this.locationList = locationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recomment_item,parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        mapLocationDB location =locationList.get(position);
        holder.name_loca.setText(location.getName_loca());
        holder.data_loca.setText(location.getData_loca());
        Glide.with(itemView.getContext())
                .load(location.getImg_loca())
                .into(holder.imageLoca);
    }


    @Override
    public int getItemCount() {

        return locationList.size();
    }



}
