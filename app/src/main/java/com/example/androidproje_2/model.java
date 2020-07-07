package com.example.androidproje_2;

public class model {
    int cinsiyet;
    String adSoyd;
    int calismaDurumu;

    public model(int cinsiyet, String adSoyd, int calismaDurumu) {
        this.cinsiyet = cinsiyet;
        this.adSoyd = adSoyd;
        this.calismaDurumu = calismaDurumu;
    }

    public int getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getAdSoyd() {
        return adSoyd;
    }

    public void setAdSoyd(String adSoyd) {
        this.adSoyd = adSoyd;
    }

    public int getCalismaDurumu() {
        return calismaDurumu;
    }

    public void setCalismaDurumu(int calismaDurumu) {
        this.calismaDurumu = calismaDurumu;
    }
}
