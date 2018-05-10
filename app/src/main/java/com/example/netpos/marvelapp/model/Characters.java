package com.example.netpos.marvelapp.model;

public class Characters {
    private Data data;

    public Characters(){

    }

    public Characters(Data data){
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
