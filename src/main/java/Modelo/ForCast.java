/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author washington
 */
public class ForCast implements Serializable {

    @SerializedName("main")
    Main main;

    @SerializedName("weather")
    List<Weather> weather = new ArrayList<>();

    @SerializedName("clouds")
    private Clouds clouds;
    
    @SerializedName("wind")
    private Wind wind;
    
    @SerializedName("dt_txt")
    private String data;
    
    private Date dataPrevisao;
    
    private String clima;


    
    public ForCast() {
        this.main = new Main();
        this.weather = new ArrayList<>();
        this.clouds = new Clouds();
        this.wind = new Wind();
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    
    
}
