package com.arodream.tripuratourism.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.arodream.tripuratourism.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    SupportMapFragment supportMapFragment;
    LatLng agartala = new LatLng(23.851753, 91.305966);
    LatLng ujjayanta = new LatLng(23.837411, 91.282798);
    LatLng matabari = new LatLng(23.509125, 91.498163);
    LatLng royal = new LatLng(23.533552, 91.486877);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return root;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.addMarker(new MarkerOptions()
                .position(ujjayanta)
                .title("Ujjyanta Palace"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(24.312021, 92.067936))
                .title("Unakuti")
        );
        mMap.addMarker(new MarkerOptions().position(matabari).title("Mata Bari"));

        // Hotels

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.831956, 91.269167))
                .title("Sonar Tori")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.862311, 91.282498))
                .title("Ginger Hotel")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );

        mMap.addMarker(new MarkerOptions()
                .position(royal)
                .title("Royal Hotel")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(matabari, 9));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(matabari));
    }


}