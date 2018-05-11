package com.example.netpos.marvelapp.model;

public class CharacterDataWrapper {
    private CharacterDataContainer data;

    public CharacterDataWrapper(){

    }

    public CharacterDataWrapper(CharacterDataContainer data){
        this.data = data;
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }
}