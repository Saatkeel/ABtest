package com.example.springfeign.service;

import com.example.springfeign.model.Valute;

public interface OpenExchangeService {
    Valute getValute(String date, String app_id, String symbols,String base);
    Valute justTest(String date,String symbols);
}
