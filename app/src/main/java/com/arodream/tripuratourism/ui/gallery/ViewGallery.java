package com.arodream.tripuratourism.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arodream.tripuratourism.R;
import com.arodream.tripuratourism.model.Image;

import java.util.ArrayList;

public class ViewGallery extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Image> imageArrayList = new ArrayList<>();
    GalleryAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gallery);

        tv = findViewById(R.id.gallery_type_txt);
        recyclerView = findViewById(R.id.gallery_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        String gallery = intent.getStringExtra("type");

        tv.setText(gallery);

//        if (gallery.equals("Tourist")){
//            Image image = new Image(R.drawable.rupesh,"Rupesh","A");
//            Image image1 = new Image(R.drawable.shubham,"Rupesh","A");
//            Image image2 = new Image(R.drawable.rupesh,"Rupesh","B");
//            Image image3 = new Image(R.drawable.shubham,"Rupesh","B");
//            imageArrayList.add(image);
//            imageArrayList.add(image1);
//            imageArrayList.add(image2);
//        }else if (gallery.equals("Holy")){
//            Image image = new Image(R.drawable.rupesh,"Rupesh","A");
//            Image image1 = new Image(R.drawable.shubham,"Rupesh","A");
//            Image image2 = new Image(R.drawable.rupesh,"Rupesh","B");
//            Image image3 = new Image(R.drawable.shubham,"Rupesh","B");
//            //imageArrayList.add(image);
//            imageArrayList.add(image1);
//            imageArrayList.add(image2);
//        }else if (gallery.equals("Hotel")){
//            Image image = new Image(R.drawable.rupesh,"Rupesh","A");
//            Image image1 = new Image(R.drawable.shubham,"Rupesh","A");
//            Image image2 = new Image(R.drawable.rupesh,"Rupesh","B");
//            Image image3 = new Image(R.drawable.shubham,"Rupesh","B");
//            imageArrayList.add(image);
//            //imageArrayList.add(image1);
//            imageArrayList.add(image2);
//        }else if (gallery.equals("Eco")){
//            Image image = new Image(R.drawable.rupesh,"Rupesh","A");
//            Image image1 = new Image(R.drawable.shubham,"Rupesh","A");
//            Image image2 = new Image(R.drawable.rupesh,"Rupesh","B");
//            Image image3 = new Image(R.drawable.shubham,"Rupesh","B");
//            imageArrayList.add(image);
//            imageArrayList.add(image1);
//            //imageArrayList.add(image2);
//        }
//

        //imageArrayList.add(image3);imageArrayList.add(image3);imageArrayList.add(image3);
        adapter = new GalleryAdapter(getApplicationContext(),imageArrayList);
        recyclerView.setAdapter(adapter);
    }
}
