package com.example.netpos.marvelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.netpos.marvelapp.model.CharacterDataWrapper;
import com.example.netpos.marvelapp.service.APIClient;
import com.example.netpos.marvelapp.service.IRest;

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

        try {
            Call<CharacterDataWrapper> getCharacters = IRest.getCharacters("1", "a413ad442cdbeabdd779f3114ec2fa05", "28e4881685d9a9d9d9b042812217b15e");

            getCharacters.enqueue(new Callback<CharacterDataWrapper>() {
                @Override
                public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                    if (response.isSuccessful()){
                        CharacterDataWrapper characterDataWrapper = response.body();
                        tvText.setText(characterDataWrapper.getData().getResults().get(0).getName());
                    } else {
                        Log.i("FOI", ""+response.body());
                    }
                }

                @Override
                public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                    Log.i("FOI", "Error, onFailure");
                }
            });
        } catch (Exception e){
            //
        }
    }
}
