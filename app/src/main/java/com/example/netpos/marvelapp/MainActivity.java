package com.example.netpos.marvelapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netpos.marvelapp.adapter.CharacterListAdapter;
import com.example.netpos.marvelapp.model.Character;
import com.example.netpos.marvelapp.model.CharacterDataWrapper;
import com.example.netpos.marvelapp.service.APIClient;
import com.example.netpos.marvelapp.service.IRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvEmpty;
    private RecyclerView rv;
    private SwipeRefreshLayout srlList;
    private static final String APIKEY = "a413ad442cdbeabdd779f3114ec2fa05";
    private static final String TS = "1";
    private static final String HASH = "28e4881685d9a9d9d9b042812217b15e";
    private IRest iRest;
    private List<Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIClient apiClient = new APIClient();
        iRest = apiClient.getAPIClient();

        fillingcomponents();
        getCharactersRequest();
    }

    private void fillingcomponents(){
        tvEmpty = findViewById(R.id.tv_empty);
        rv = findViewById(R.id.rv);
        srlList = findViewById(R.id.srlList);
        characters = new ArrayList<>();

        srlList.setColorSchemeColors(Color.BLUE);
        srlList.setRefreshing(true);

        srlList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvEmpty.setVisibility(View.GONE);
                rv.setVisibility(View.GONE);
                characters.clear();
                getCharactersRequest();
            }
        });
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
                        characters.addAll(characterDataWrapper.getData().getResults());
                        CharacterListAdapter adapter = new CharacterListAdapter(MainActivity.this, characters);
                        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        rv.setHasFixedSize(true);
                        rv.setAdapter(adapter);
                        tvEmpty.setVisibility(View.GONE);
                        rv.setVisibility(View.VISIBLE);
                        srlList.setRefreshing(false);

                    } else {
                        tvEmpty.setVisibility(View.VISIBLE);
                        rv.setVisibility(View.GONE);
                        srlList.setRefreshing(false);
                        Toast.makeText(MainActivity.this, "Não foi possivel carregar a lista, por favor tente novamente mais tarde.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CharacterDataWrapper> call, @NonNull Throwable t) {
                    tvEmpty.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.GONE);
                    srlList.setRefreshing(false);
                    Toast.makeText(MainActivity.this, "Não foi possivel carregar a lista, por favor tente novamente mais tarde.", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e){
            tvEmpty.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
            srlList.setRefreshing(false);
        }
    }
}
