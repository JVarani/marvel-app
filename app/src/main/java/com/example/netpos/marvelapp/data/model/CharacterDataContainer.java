package com.example.netpos.marvelapp.data.model;

import java.util.List;

public class CharacterDataContainer {
    private List<Character> results;

    public CharacterDataContainer(){

    }

    public CharacterDataContainer(List<Character> results){
        this.results = results;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}