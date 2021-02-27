package com.example.springfeign.model;

import java.util.HashMap;

public class Valute {
    public String disclaimer;
    private HashMap<String,Double> rates;

    public void setDisclaimer(String disclaimer){ this.disclaimer = disclaimer;}
    public String getDisclaimer(){ return disclaimer;}


    public void setRates(HashMap<String,Double> rates) { this.rates = rates;}
    public HashMap<String, Double> getRates(){ return rates;}

}
