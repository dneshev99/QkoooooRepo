package com.diplomna.diplomna.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.R;

import butterknife.BindView;

public class ItemInfoActivity extends AppCompatActivity {

    @BindView(R.id.item_name)
    TextView itemName;
    @BindView(R.id.item_description)
    TextView itemDesc;
    @BindView(R.id.item_price_text)
    TextView itemPrice;
    @BindView(R.id.item_quantity_text)
    TextView itemQuantity;
    @BindView(R.id.seller_text)
    TextView sellerUsername;
    @BindView(R.id.seller_button)
    Button sellerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        ItemDTO dto = (ItemDTO) getIntent().getExtras().get("item");
        String unit = (String) getIntent().getExtras().get("unit");

        itemName.setText("" + dto.getName());
        itemDesc.setText("" + dto.getDescription());
        itemPrice.setText("Price: " + "Price: " + dto.getBasePricePerUnit() + " bgn/" + unit);
        itemQuantity.setText("Quantity: " + dto.getQuantity() + " " + unit);
        sellerUsername.setText("From: " + dto.getUser());
    }
}
