package com.example.otonomarac;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyReservation extends AppCompatActivity {
    RecyclerView myRecyclerView;
    ArrayList<Shop> lstPlaces;
    private int reservationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);
        lstPlaces = new ArrayList<Shop>();

        Shop shop1 = new Shop(1, "Tesla", 48.7791242, 9.0371319, 0.25);
        Shop shop2 = new Shop(2, "Mercedes-Benz", 48.810335, 9.1461793, 0.50);
        Shop shop3 = new Shop(3, "Citroen", 48.810639,9.1447093, 0.75);
        lstPlaces.add(shop1);
        lstPlaces.add(shop2);
        lstPlaces.add(shop3);
        Intent incomingIntent = getIntent();
        reservationId = incomingIntent.getIntExtra("id", 0);

        Reservation reservation = Storage.getInstance().getReservationById(reservationId);
        if (reservation == null){
            //TODO: exception
        }
    }
    //ui views of components
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_my_reservations, container, false);

        myRecyclerView = root.findViewById(R.id.recyclerView);
        MyReservationAdapter myLocationsAdapter = new MyReservationAdapter(lstPlaces, this);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(myLocationsAdapter);
        myLocationsAdapter.notifyDataSetChanged();


        return root;

    }

}
