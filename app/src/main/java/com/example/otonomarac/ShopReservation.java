package com.example.otonomarac;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.widget.DatePicker;
import android.widget.TextView;
import android.view.View;
import android.widget.TimePicker;


public class ShopReservation extends AppCompatActivity
        implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_reservation);

        Intent incomingIntent = getIntent();
        int incomingId = incomingIntent.getIntExtra("id", 0);

        Shop shop = Storage.getInstance().getShopById(incomingId);
        if (shop == null){
            //TODO: exception
        }

        TextView shopName = findViewById(R.id.shopName);
        shopName.setText(shop.getName());

        TextView shopPrice = findViewById(R.id.shopPrice);
        shopPrice.setText(Double.toString(shop.getPrice()) + "TL");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }


    //TODO: does not work idk why
    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        TextView timeView = findViewById(R.id.timeView);
        timeView.setText(hours + ":" + minutes);
    }

    //TODO: does not work idk why
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        TextView dateView = findViewById(R.id.dateView);
        dateView.setText(day + "/" + month + "/" + year);
    }
}
