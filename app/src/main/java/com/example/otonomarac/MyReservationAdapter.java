package com.example.otonomarac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyReservationAdapter extends RecyclerView.Adapter<MyReservationAdapter.CardviewPlaceHolder> {
    //Definition adapter variables
    Context context;
    private ArrayList<Reservation> itemList;

    // Constructor
    public MyReservationAdapter(ArrayList<Reservation> reservationList, Context context) {
        this.itemList = reservationList;
        this.context = context;
    }

    @NonNull
    @Override    //First Creation
    public CardviewPlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_reservation_card, parent, false);

        final CardviewPlaceHolder cardviewPlaceHolder = new CardviewPlaceHolder(itemView);
        cardviewPlaceHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        return new CardviewPlaceHolder(itemView);
    }

    @Override   //Binding data to UI
    public void onBindViewHolder(@NonNull CardviewPlaceHolder holder, int position) {
        Reservation item = itemList.get(position);
        holder.isim.setText(item.getShop().getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //Card view Properties
    public class CardviewPlaceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CardView card;
        public TextView isim;

        public CardviewPlaceHolder(View view) {
            super(view);

            card = (CardView) view.findViewById(R.id.item_res);
            isim = view.findViewById(R.id.txt_res);

        }

        @Override   //remove
        public void onClick(View view) {
            final String name = isim.getText().toString();
            notifyDataSetChanged();
        }
    }
}
