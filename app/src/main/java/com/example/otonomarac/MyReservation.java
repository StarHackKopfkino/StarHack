package com.example.otonomarac;

import static java.security.AccessController.getContext;

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
    ArrayList<Reservation> lstPlaces;
    private int reservationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);

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
