package com.example.netpos.marvelapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.netpos.marvelapp.model.CharacterDataWrapper;
import com.example.netpos.marvelapp.service.APIClient;
import com.example.netpos.marvelapp.service.IRest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;
    private static final String APIKEY = "a413ad442cdbeabdd779f3114ec2fa05";
    private static final String TS = "1";
    private static final String HASH = "28e4881685d9a9d9d9b042812217b15e";
    private IRest iRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);
        APIClient apiClient = new APIClient();
        iRest = apiClient.getAPIClient();

        getCharactersRequest();
    }

    private void getCharactersRequest(){
        try {
            Call<CharacterDataWrapper> getCharacters = iRest.getCharacters(TS, APIKEY, HASH);

            getCharacters.enqueue(new Callback<CharacterDataWrapper>() {
                @Override
                public void onResponse(@NonNull Call<CharacterDataWrapper> call, @NonNull Response<CharacterDataWrapper> response) {
                    if (response.isSuccessful()){
                        CharacterDataWrapper characterDataWrapper = response.body();
                        assert characterDataWrapper != null;
                        tvText.setText(characterDataWrapper.getData().getResults().get(1).getName());
                    } else {
                        Log.i("FOI", ""+response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CharacterDataWrapper> call, @NonNull Throwable t) {
                    Log.i("FOI", "Error, onFailure");
                }
            });
        } catch (Exception e){
            //
        }
    }
}
