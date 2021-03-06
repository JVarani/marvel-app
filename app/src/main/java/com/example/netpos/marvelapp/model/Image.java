package com.example.netpos.marvelapp.model;

public class Image {
    private String path;
    private String extension;

    public Image(){
    }

    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getImage(){
        return path + "." + extension;
    }
}
