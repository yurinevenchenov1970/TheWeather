package com.github.yurinevenchenov1970.theweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.yurinevenchenov1970.theweather.adapter.SimpleWeatherListAdapter;
import com.github.yurinevenchenov1970.theweather.adapter.WeatherExtractor;
import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.bean.CityList;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.net.ApiClientCity;
import com.github.yurinevenchenov1970.theweather.net.ApiClientWeather;
import com.github.yurinevenchenov1970.theweather.net.CityService;
import com.github.yurinevenchenov1970.theweather.net.WeatherService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CityService mCityService;
    private WeatherService mWeatherService;

    @BindView(R.id.city_edit_text)
    EditText mCityTextView;

    @BindView(R.id.seek_bar)
    SeekBar mSeekBar;

    @BindView(R.id.forecast_length_text_view)
    TextView mForecastLengthTextView;

    @BindView(R.id.forecast_length_end_text_view)
    TextView mForecastLengthEndTextView;

    @BindView(R.id.weather_list_view)
    ListView mWeatherListView;

    private int mForecastLength;
    //    private List<String> mList;
//    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<SimpleWeatherToShow> mList;
    private SimpleWeatherListAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();

//        arrayAdapter = new ArrayAdapter<>(
        arrayAdapter = new SimpleWeatherListAdapter(
                this,
                android.R.layout.simple_list_item_1,
//                R.layout.weather_list_item,
                mList);
        mWeatherListView.setAdapter(arrayAdapter);
    }

    @OnTextChanged(R.id.city_edit_text)
    void onCityEditTextChanged(CharSequence city, int start, int count, int after) {
        getFullCity(city.toString());
    }

    private void initUI() {
        mSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress = 0;

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progressValue, boolean fromUser) {
                        progress = progressValue;
                        mForecastLength = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        fillForecastLength(progress);
                        checkCityFilling();
                    }
                });
        mList = new ArrayList<>();
//        mList.add("Here will be text forecast after city input");
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

    private void checkCityFilling() {
        String city = mCityTextView.getText().toString();
        if (city.length() != 0) {
            // TODO: 10/30/2017 add autocomplete API here
            getResponse(city);

        }
    }

    private void getFullCity(String partialCity) {
        mCityService = ApiClientCity.getClient().create(CityService.class);
        Call<CityList> responseCall = mCityService.getCity(partialCity);
        responseCall.enqueue(new Callback<CityList>() {
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {
                CityList cityResponse = response.body();
                if (cityResponse != null) {
                    // TODO: 10/31/2017 pop up list with clickListener to choose city from
                    System.out.println(cityResponse.toString());
                } else {
                    showErrorMessage();
                }

            }

            @Override
            public void onFailure(Call<CityList> call, Throwable t) {
                System.out.println("failure " + t.getMessage());
            }
        });
    }

    private void getResponse(String city) {
        mWeatherService = ApiClientWeather.getClient().create(WeatherService.class);
        Call<BaseResponse> responseCall = mWeatherService.getWeather(city);
        responseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                BaseResponse baseResponse = response.body();
                if (baseResponse != null) {
                    fillForecastListView(baseResponse);
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                System.out.println("failure " + t.getMessage());
            }
        });
    }

    private void fillForecastListView(BaseResponse baseResponse) {
        if (mForecastLength == 0) {
            mForecastLength = Integer.parseInt(mForecastLengthTextView.getText().toString());
        }
        formForecastList(baseResponse, mForecastLength);
        arrayAdapter.notifyDataSetChanged();
    }

    private void formForecastList(BaseResponse baseResponse, int forecastLength) {
//        List<String> weatherList = WeatherExtractor.extractTextWeatherToShow(baseResponse, forecastLength);
        List<SimpleWeatherToShow> weatherList = WeatherExtractor.extractSimpleWeatherToShow(baseResponse, forecastLength);
        mList.clear();
//        for (String oneDayWeather : weatherList) {
        for (SimpleWeatherToShow oneDayWeather : weatherList) {
            mList.add(oneDayWeather);
        }
    }

    private void showErrorMessage() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show();
    }
}