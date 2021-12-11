package com.example.otonomarac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonPress(View view) {
        Intent intent = new Intent(this, ShopReservation.class);
        intent.putExtra("id",1);
        startActivity(intent);
    }
}