package com.example.otonomarac;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.otonomarac.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng sydney = new LatLng(-34, 151);
    LatLng istanbul = new LatLng(-23, 324);
    ArrayList<String> title = new  ArrayList<String>();

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Shop shops[] = Storage.getInstance().shops;
        for(Shop shop : shops){
                LatLng latLng = new LatLng(shop.getLatitude(), shop.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(shop.getName())).setTag(shop.getId());
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
          //  mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
        // Add a marker in Sydney and move the camera


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                int id = (Integer) marker.getTag();
                Intent intent = new Intent(MapsActivity.this, ShopReservation.class);
                intent.putExtra("id", id);
                startActivity(intent);
                return false;
            }
        });
    }
}