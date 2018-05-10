package com.example.netpos.marvelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.netpos.marvelapp.model.Characters;
import com.example.netpos.marvelapp.service.APIClient;
import com.example.netpos.marvelapp.service.IRest;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);
        APIClient apiClient = new APIClient();
        IRest IRest = apiClient.getAPIClient();

        Gson gson = new Gson();
        try {
            Call<Characters> getCharacters = IRest.getCharacters("a413ad442cdbeabdd779f3114ec2fa05");
            getCharacters.enqueue(new Callback<Characters>() {
                @Override
                public void onResponse(Call<Characters> call, Response<Characters> response) {
                    if (response.isSuccessful()){
                        Characters characters = response.body();
                        tvText.setText(characters.getData().getResults().get(0).getName());
                    } else {
                        Log.i("FOI", ""+response.body());
                    }
                }

                @Override
                public void onFailure(Call<Characters> call, Throwable t) {
                    Log.i("FOI", "Error, onFailure");
                }
            });
        } catch (Exception e){
            //
        }
    }
}
