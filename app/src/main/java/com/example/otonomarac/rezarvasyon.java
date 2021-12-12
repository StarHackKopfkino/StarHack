package com.example.otonomarac;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.otonomarac.databinding.ActivityRezarvasyonBinding;

public class rezarvasyon extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRezarvasyonBinding binding;

    private int reservationId;
    private TextView textView2 = null;
    private TextView ay = null;
    private TextView year = null;
    private TextView hour = null;
    private TextView minute = null;
    private TextView duration = null;
    private TextView totalcost = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRezarvasyonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent incomingIntent = getIntent();
        reservationId = incomingIntent.getIntExtra("reservationId", 0);
        Reservation reservation = Storage.getInstance().getReservationById(reservationId);
        textView2 = findViewById(R.id.day);
        textView2.setText(Integer.toString(reservation.getDay()));

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


        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_rezarvasyon);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_rezarvasyon);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}