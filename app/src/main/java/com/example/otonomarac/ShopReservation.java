package com.example.otonomarac;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.widget.DatePicker;
import android.widget.TextView;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.util.Date;


public class ShopReservation extends AppCompatActivity
        implements OnTimeSetListener, OnDateSetListener {

    private int shopId;
    private int price;

    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int duration;

    private TextView editTextTime3;

    // Turns hours and minutes into string with "0"s prepended if needed.
    private String normalizeTime(int hours, int minutes){
        String normalizedHours;
        String normalizedMinutes;
        if(hours < 10){
            normalizedHours = "0" + hours;
        } else{
            normalizedHours = Integer.toString(hours);
        }

        if(minutes < 10){
            normalizedMinutes = "0" + minutes;
        } else{
            normalizedMinutes = Integer.toString(minutes);
        }

        return normalizedHours + ":" + normalizedMinutes;
    }

    // Turns years, months and days into string with "0"s prepended if needed.
    // Will not normalize years.
    private String normalizeDate(int years, int months, int days){
        String normalizedMonths;
        String normalizedDays;

        if(months < 10){
            normalizedMonths = "0" + months;
        } else{
            normalizedMonths = Integer.toString(months);
        }

        if(days < 10){
            normalizedDays = "0" + days;
        } else {
            normalizedDays = Integer.toString(days);
        }

        return normalizedDays + "/" + normalizedMonths + "/" + years;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_reservation);
        getSupportActionBar().hide();
        Intent incomingIntent = getIntent();
        shopId = incomingIntent.getIntExtra("id", 0);

        //TODO: to be changed (input)
        duration = 60;

        Shop shop = Storage.getInstance().getShopById(shopId);
        if (shop == null){
            //TODO: exception
        }
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePicker picker=(TimePicker)findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);

        // Set labels
        TextView shopName = findViewById(R.id.shopName);
        shopName.setText(shop.getName());


        // Get current time to initialize time/date
        LocalDateTime now = LocalDateTime.now();
        years = now.getYear();
        months = now.getMonthValue();
        days = now.getDayOfMonth();
        hours = now.getHour();
        minutes = now.getMinute();

        TextView timeView = findViewById(R.id.timeView);
        timeView.setText(normalizeTime(hours, minutes));

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        TextView timeView = findViewById(R.id.timeView);
        timeView.setText(normalizeTime(hours, minutes));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        this.years = year;
        this.months = month;
        this.days = day;
    }

    public void makeReservation(View view) {


        ArrayList<Reservation> reservations = Storage.getInstance().reservations;
        Reservation newReservation = new Reservation(reservations.size(), days, months, years, hours, minutes, duration, Storage.getInstance().getShopById(shopId));
        reservations.add(newReservation);

        //String s = editTextTime3.getText();
        //Double minute = 30.0;

        //Calculator.calculateTotalPrice(minute,Storage.getInstance().getShopById(price));
        Toast.makeText(getApplicationContext(),"PAYMENT SUCCESSFUL",Toast.LENGTH_LONG).show();

        int id = (Integer) newReservation.getId();
        Intent intent = new Intent(ShopReservation.this, rezevartation.class);
        intent.putExtra("id", id);
        intent.putExtra("day", days);
        intent.putExtra("month", months);
        intent.putExtra("year", years);
        intent.putExtra("hour", hours);
        intent.putExtra("minute", minutes);
        //intent.putExtra("duration", id);
        startActivity(intent);


    }
}
