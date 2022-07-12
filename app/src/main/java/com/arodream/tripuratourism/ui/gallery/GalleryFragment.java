package com.arodream.tripuratourism.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arodream.tripuratourism.R;

public class GalleryFragment extends Fragment {
    ImageButton touristPlace, holyPlace, hotel, ecoPark;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_gallery,container,false);
        touristPlace = root.findViewById(R.id.tourist_place);
        holyPlace = root.findViewById(R.id.holy_place);
        hotel = root.findViewById(R.id.hotel);
        ecoPark = root.findViewById(R.id.eco_park);
        final Intent intent = new Intent(getContext(),ViewGallery.class);
        touristPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type","Tourist");
                startActivity(intent);
            }
        });

        holyPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type","Holy");
                startActivity(intent);
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type","Hotel");
                startActivity(intent);
            }
        });
        ecoPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type","Eco");
                startActivity(intent);
            }
        });
        return root;
    }
}
