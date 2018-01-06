package com.github.yurinevenchenov1970.theweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.yurinevenchenov1970.theweather.adapter.SimpleWeatherListAdapter;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenterImpl;
import com.github.yurinevenchenov1970.theweather.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mMainPresenter;
    private int mForecastLength;
    private String mCity;
    private ArrayList<String> mAvailableCitiesList = new ArrayList<>();
    private ArrayAdapter mCitiesListAdapter;
    private ArrayList<SimpleWeatherToShow> mWeatherList = new ArrayList<>();
    private SimpleWeatherListAdapter mWeatherListAdapter;

    @BindView(R.id.city_edit_text)
    EditText mCityTextView;

    @BindView(R.id.cities_list_view)
    ListView mCitiesListView;

    @BindView(R.id.seek_bar)
    SeekBar mSeekBar;

    @BindView(R.id.forecast_length_text_view)
    TextView mForecastLengthTextView;

    @BindView(R.id.forecast_length_end_text_view)
    TextView mForecastLengthEndTextView;

    @BindView(R.id.weather_list_view)
    ListView mWeatherListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenterImpl(this);
        mForecastLength = Integer.parseInt(mForecastLengthTextView.getText().toString());
        initForecastLengthFader();
    }

    @OnTextChanged(R.id.city_edit_text)
    void onCityEditTextChanged(CharSequence city, int start, int count, int after) {
        mMainPresenter.treatCityViewChanges(city.toString());
    }

    @Override
    public void showAvailableCitiesList(List<String> availableCitiesList) {
        mAvailableCitiesList = (ArrayList) availableCitiesList;
        mCitiesListAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                mAvailableCitiesList);
        mCitiesListView.setAdapter(mCitiesListAdapter);

        showCitiesList();

        mCitiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCity = mAvailableCitiesList.get(position);
                mCityTextView.setText(mCity);
                mMainPresenter.treatCitySelection(mCity);
            }
        });
    }

    @Override
    public void hideCitiesList() {
        mCitiesListView.setVisibility(View.GONE);
    }

    @Override
    public int getForecastLength() {
        return mForecastLength;
    }

    @Override
    public void showForecast(List<SimpleWeatherToShow> forecastList) {
        mWeatherList = (ArrayList) forecastList;
        mWeatherListAdapter = new SimpleWeatherListAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mWeatherList);
        mWeatherListView.setAdapter(mWeatherListAdapter);
    }

    @Override
    public void hideForecast() {
        try {
            mWeatherList.clear();
            mWeatherListAdapter.notifyDataSetChanged();
        } catch (NullPointerException e) {
            //no need to do smth
        }
    }

    @Override
    public void showError(int errorDescription) {
        Toast.makeText(this, getString(errorDescription), Toast.LENGTH_LONG).show();
    }

    //region private methods

    private void initForecastLengthFader() {
        mSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progressValue, boolean fromUser) {
                        mForecastLength = progressValue;
                        fillForecastLength(mForecastLength);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mMainPresenter.treatForecastLengthChanges(mForecastLength);
                    }
                });
    }

    private void fillForecastLength(int progress) {
        mForecastLengthTextView.setText(String.valueOf(progress));
        correctDayWordForm(progress);
    }

    private void correctDayWordForm(int progress) {
        if (progress == 1) {
            mForecastLengthEndTextView.setText(R.string.day);
        } else if (progress == 2 || progress == 3 || progress == 4) {
            mForecastLengthEndTextView.setText(R.string.day_2_4);
        } else if (progress >= 5 || progress == 0) {
            mForecastLengthEndTextView.setText(R.string.days);
        }
    }

    private void showCitiesList() {
        mCitiesListView.setVisibility(View.VISIBLE);
        mCitiesListView.bringToFront();
    }

    //endregion
}