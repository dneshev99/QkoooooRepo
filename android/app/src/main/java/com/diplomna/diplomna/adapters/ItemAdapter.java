package com.diplomna.diplomna.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.R;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<ItemDTO> {
    private List<ItemDTO> data;
    private String unit;

    public ItemAdapter(@NonNull Context context, List<ItemDTO> data, String unit) {
        super(context, R.layout.item_row,data);
        this.data = data;
        this.unit = unit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemDTO entry = data.get(position);

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_row, parent, false);

            TextView itemName = convertView.findViewById(R.id.item_name);
            TextView user = convertView.findViewById(R.id.item_user);
            TextView itemQuantity = convertView.findViewById(R.id.item_quantity);
            TextView itemPrice = convertView.findViewById(R.id.item_price);

            itemName.setText(entry.getName());
            user.setText("From: " + entry.getUser());
            itemPrice.setText("Price: " + entry.getBasePricePerUnit() + " bgn/" + unit);
            itemQuantity.setText("Quantity: " + entry.getQuantity() + " " + unit);

        }

        return convertView;
    }

    public List<ItemDTO> getData() {
        return data;
    }
}
