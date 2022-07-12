package com.arodream.tripuratourism.helper;



import com.arodream.tripuratourism.model.PlaceList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("place.php")
    Call<List<PlaceList>> getList();
}
