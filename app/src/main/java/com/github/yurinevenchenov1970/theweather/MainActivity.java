package com.github.yurinevenchenov1970.theweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.net.ApiClient;
import com.github.yurinevenchenov1970.theweather.net.WeatherService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WeatherService mService;

    @BindView(R.id.city_edit_text)
    TextView mCityTextView;

    @BindView(R.id.seek_bar)
    SeekBar mSeekBar;

    @BindView(R.id.forecast_length_text_view)
    TextView mForecastLengthTextView;

    @BindView(R.id.forecast_length_end_text_view)
    TextView mForecastLengthEndTextView;

    @BindView(R.id.weather_list_view)
    ListView mWeatherListView;

    private int mForecastLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
        getResponse();
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
                    }
                });
    }

    private void fillForecastLength(int progress){
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

    private void getResponse(){
        String city = "Dnepr";

        mService = ApiClient.getClient().create(WeatherService.class);
        Call<BaseResponse> responseCall = mService.getWeather(city);
        responseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                BaseResponse baseResponse = response.body();
                if (baseResponse != null) {
                    System.out.println(baseResponse.toString());
                } else {
                    System.out.println("it is null");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                System.out.println("failure " + t.getMessage());
            }
        });
    }
}