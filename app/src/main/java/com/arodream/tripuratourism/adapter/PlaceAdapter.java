package com.arodream.tripuratourism.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.arodream.tripuratourism.R;
import com.arodream.tripuratourism.model.Place;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlaceAdapter  extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    Context context;
    List<Place> places;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_place_detail,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        Place place = places.get(position);
        holder.titleTxt.setText(place.getTitle());
        holder.descTxt.setText(place.getDesc());
        String img = "R.drawable."+place.getImg();
        holder.imageView.setImageResource(place.getImg());

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, descTxt;
        CircleImageView imageView;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.row_title);
            descTxt = itemView.findViewById(R.id.row_desc);
            imageView = itemView.findViewById(R.id.row_img);
        }
    }
}
