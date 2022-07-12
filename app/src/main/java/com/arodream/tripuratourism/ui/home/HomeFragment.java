package com.arodream.tripuratourism.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arodream.tripuratourism.R;
import com.arodream.tripuratourism.adapter.PlaceAdapter;
import com.arodream.tripuratourism.helper.ApiClient;
import com.arodream.tripuratourism.model.Place;
import com.arodream.tripuratourism.model.PlaceList;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private SliderLayout imageSlider;
    RecyclerView recyclerView;
    ArrayList<Place> list = new ArrayList<>();
    List<PlaceList> placeLists = new ArrayList<>();
    PlaceAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = root.findViewById(R.id.img_slider);
        recyclerView = root.findViewById(R.id.recyclerView);

        imageSlider.setIndicatorAnimation(IndicatorAnimations.FILL);
        imageSlider.setScrollTimeInSec(2);
        recyclerView.setHasFixedSize(true);
        // recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Place place =new Place(R.drawable.ujjayanta,"Ujjayanta Palace","The Tripura Government museum or the Tripura state Museum Ujjayanta Palace Agartala in the Indian state of Tripura is housed in the Ujjayanta Palace , former royal palace of the Tripura. It was first established on 22 June 1970 as multicultural museum with emphasis on art and crafts of the state of Tripura, and shifted to the much larger heritage edifice of the Ujjayanta Palace, opened in 1901. It is northeast India’s largest museum with a national perspective while remaining focused on Tripura and Northeast India.");
        Place place1 = new Place(R.drawable.neer,"Neermahal","Neermahal is a former royal palace built by Maharaja of Tripura Kingdom Bir Bikram Kishore Manikya Debbarma of the erstwhile Kingdom of Tripura, India in the middle of the lake Twijilikma in 1930 and was completed by 1938. It is situated in Melaghar, 53 kilometers away from Agartala.");
        Place place2 =new Place(R.drawable.sepahijala,"Shipahijala","Shipahijala tour is the most important tour in the west district of Tripura. This is the one most important wild life sanctuaries in the state of Tripura. This wild life sanctuary has attracted many tourists in the state. There are also many types of animals including the Royal Bengal Tigers. Only a few of these Royal Bengal Tigers are there in the sanctuary. Both the domestic and the foreign tourists like to visit this place because of the animals. There are other type of animals that are also found in this area. All the government and the private tour operators offer this tours to the tourists.");
        Place place3 = new Place(R.drawable.mata,"Mata Bari","This Pithasthan is also known as Kurma pith because the shape of the temple premises resembles that of Kurma namely tortoise. At first glance the temple structure appears to be a modified Buddhist Stupa. The temple faces the west and the main entrance of the temple is also in the west tough in the narrow entrance in the North. A stamp featuring the Tripureswari temple was released on September 2003 acknowledging this heritage. In the eastern side of the Temple there lies Kalyan Sagar where very big fishes and tortoises cohabites undistributed.");
        Place place4=new Place(R.drawable.unakoti,"Unakoti","Unakoti in Tripura can be the great importance, both in terms of history and tourism. It is sad that the government is still oblivious to the place. Unakoti is famous for its massive stone and rock-cut sculptures that have bees carved out from the hillside. It is immediately apparent that these carvings were made by extremely skilled artisans.");
        list.add(place);
        list.add(place1);
        list.add(place2);
        list.add(place3);
        list.add(place4);

        adapter = new PlaceAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        for (int i=0; i < list.size(); i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            Place mplace = list.get(i);
            sliderView.setImageDrawable(mplace.getImg());
            //sliderView.setDescription(mplace.getDesc());
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            imageSlider.addSliderView(sliderView);
        }
        //showSlider();
        return root;
    }

    private void showSlider() {

        OkHttpClient client = new OkHttpClient() ;

        Call<List<PlaceList>> call = ApiClient.getClient().getList();
        call.enqueue(new Callback<List<PlaceList>>() {
            @Override
            public void onResponse(Call<List<PlaceList>> call, Response<List<PlaceList>> response) {
                if (response.isSuccessful()) {
                    placeLists = response.body();

                    //sliderView.setImageUrl(placeList.getUrl());
                    for (int i = 0; i < placeLists.size(); i++) {
                        DefaultSliderView sliderView = new DefaultSliderView(getContext());
                        PlaceList placeList = placeLists.get(i);
                        sliderView.setImageUrl(placeList.getUrl());
                        Log.e("places", "onResponse: " + i + "," + placeList.getUrl());
                        sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                        sliderView.setDescription(placeList.getName());
                        imageSlider.addSliderView(sliderView);
                    }


                }
            }

            @Override
            public void onFailure(Call<List<PlaceList>> call, Throwable t) {

                Log.e("failure", "onFailure: "+t );
            }
        });
    }
}