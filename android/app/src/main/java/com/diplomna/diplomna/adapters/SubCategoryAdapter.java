package com.diplomna.diplomna.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diplomna.diplomna.DTOs.SubCategoryDTO;
import com.diplomna.diplomna.R;

import java.util.List;

public class SubCategoryAdapter extends ArrayAdapter<SubCategoryDTO> {
    private List<SubCategoryDTO> data;

    public SubCategoryAdapter(@NonNull Context context, List<SubCategoryDTO> data) {
        super(context, R.layout.category_row,data );
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubCategoryDTO entry = data.get(position);

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.category_row, parent, false);

            TextView categoryName = convertView.findViewById(R.id.category_name);

            categoryName.setText(entry.getName());
        }

        return convertView;
    }

    public List<SubCategoryDTO> getData() {
        return data;
    }
}
