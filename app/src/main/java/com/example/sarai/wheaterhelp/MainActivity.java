package com.example.sarai.wheaterhelp;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private InfoWheater currentWeather;
    private RelativeLayout relativeLayout;
    private Tips tip = new Tips();
    private Colors cores = new Colors();

    @BindView(R.id.timeLabel) TextView mTimeLabel;
    @BindView(R.id.degree) TextView mTemperatureLabel;
    @BindView(R.id.humidityValue) TextView mHumidityValue;
    @BindView(R.id.precipValue) TextView mPrecipValue;
    @BindView(R.id.funText) TextView mfunText;
    @BindView(R.id.icon) ImageView mIconImageView;
    @BindView(R.id.locationLabel) TextView mlocationLabel;
    @BindView(R.id.refresh) ImageView refresh;
    @BindView(R.id.progressBar) ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        relativeLayout = (RelativeLayout) findViewById(R.id.degreeImageView);
        progressBar.setVisibility(View.INVISIBLE);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getForecast();
            }
        });

        getForecast();

        Log.d(TAG, "Main UI code is running");

    }

    private void getForecast() {
        String apiKey = "a87f44afcdf352c5d169a52a50924988";
        double latitude = 37.8267;
        double longitude = -122.423;
        String apiUrl = "https://api.forecast.io/forecast/" +apiKey + "/" + latitude + "," + longitude + "?units=si&exclude=flags" ;


        if(isNetworkAvailable()) {
            toggleRefresh();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(apiUrl).build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleRefresh();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toggleRefresh();
                        }
                    });

                    try {
                        String jsonData = response.body().string();
                        Log.e(TAG, jsonData);
                        if (response.isSuccessful()) {
                            currentWeather = getCurrentDetails(jsonData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateDisplay();
                                }
                            });

                        } else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "error: ", e);
                    }
                }
            });
        }else{
            Toast.makeText(this, R.string.error_network_unavalable, Toast.LENGTH_LONG).show();
        }
    }

    private void toggleRefresh() {
        if(progressBar.getVisibility() == View.INVISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
            refresh.setVisibility(View.INVISIBLE);
        }else{
            progressBar.setVisibility(View.INVISIBLE);
            refresh.setVisibility(View.VISIBLE);
        }
    }

    private void updateDisplay() {
        mTemperatureLabel.setText((int)currentWeather.getCurrentWeather().getTemperature() + "");
        mTimeLabel.setText("At " + currentWeather.getFormatterData(currentWeather.getCurrentWeather().getTime()) + " it will be");
        mHumidityValue.setText(currentWeather.getCurrentWeather().getHumidity() + "");
        mPrecipValue.setText(currentWeather.getCurrentWeather().getPreceptChance() + "%");
        mfunText.setText(tip.getTip());
        relativeLayout.setBackgroundColor(cores.getColor());
        mlocationLabel.setText(currentWeather.getTimezone());

        Drawable drawable = ContextCompat.getDrawable(this, currentWeather.getCurrentWeather().getIconId());
        mIconImageView.setImageDrawable(drawable);
    }

    private InfoWheater getCurrentDetails(String jsonData) {
        JSONObject jsonObj = null;
        InfoWheater info = null;
        try {
            jsonObj = new JSONObject(jsonData);
            Gson gson = new Gson();
            info = gson.fromJson(jsonData, InfoWheater.class);
            CurrentWeather currentWeather = gson.fromJson(jsonObj.get("currently").toString() , CurrentWeather.class);
            info.setCurrentWeather(currentWeather);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return info;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

    public boolean isNetworkAvailable() {
        boolean isAvailable = false;

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

        return isAvailable;
    }
}
