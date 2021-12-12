package com.example.otonomarac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class rezevartation extends AppCompatActivity {

    private int reservationId;
    private TextView day = null;
    private TextView ay = null;
    private TextView year = null;
    private TextView hour = null;
    private TextView minute = null;
    private TextView duration = null;
    private TextView totalcost = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezevartation);
        getSupportActionBar().hide();


        Intent incomingIntent = getIntent();
        reservationId = incomingIntent.getIntExtra("reservationId", 0);
        Reservation reservation = Storage.getInstance().getReservationById(reservationId);
        day = findViewById(R.id.day);
        day.setText(Integer.toString(reservation.getDay()));

        ay = findViewById(R.id.ay);
        ay.setText(Integer.toString(reservation.getMonth()));

        year = findViewById(R.id.year);
        year.setText(Integer.toString(reservation.getYear()));

        hour = findViewById(R.id.hour);
        hour.setText(Integer.toString(reservation.getHourOfBeginning()));

        minute = findViewById(R.id.minute);
        minute.setText(Integer.toString(reservation.getmMnuteOfBeginning()));

        duration = findViewById(R.id.duration);
        duration.setText("60");

        totalcost = findViewById(R.id.totalcost);
        double totall = Calculator.calculateTotalPrice(60,0.5);
        totalcost.setText(Double.toString(totall));
    }
}