package com.github.yurinevenchenov1970.theweather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.yurinevenchenov1970.theweather.AppToGetContext;
import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yuri Nevenchenov on 10/30/2017.
 */

public class SimpleWeatherListAdapter extends ArrayAdapter<SimpleWeatherToShow> {

    @BindView(R.id.date_text_view)
    TextView mDateTextView;

    @BindView(R.id.weather_icon_image_view)
    ImageView mIconImageView;

    @BindView(R.id.temperature_text_view)
    TextView mTemperatureTextView;

    @BindView(R.id.wind_text_view)
    TextView mWindTextView;

    ArrayList<SimpleWeatherToShow> mSimpleWeatherToShow = new ArrayList<>();

    public SimpleWeatherListAdapter(Context context, int textViewResourceId, ArrayList<SimpleWeatherToShow> objects) {
        super(context, textViewResourceId, objects);
        mSimpleWeatherToShow = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.weather_list_item, null);
        ButterKnife.bind(this, convertView);
        mDateTextView.setText(mSimpleWeatherToShow.get(position).getDataString());
        Picasso.with(AppToGetContext.getContext()).load(mSimpleWeatherToShow.get(position).getIconPath()).into(mIconImageView);
        mTemperatureTextView.setText(mSimpleWeatherToShow.get(position).getTemperatureString());
        mWindTextView.setText(mSimpleWeatherToShow.get(position).getWindString());
        return convertView;
    }
}