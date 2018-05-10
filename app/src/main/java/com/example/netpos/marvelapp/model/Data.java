package com.example.netpos.marvelapp.model;

import java.util.List;

public class Data {
    private List<Results> results;

    public Data(){

    }

    public Data(List<Results> results){
        this.results = results;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
