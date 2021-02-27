package com.example.springfeign.service.impl;

import com.example.springfeign.client.OpenExchangeClient;
import com.example.springfeign.model.Valute;
import com.example.springfeign.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;

public class OpenExchangeServiceImpl implements OpenExchangeService {
    @Autowired
    private OpenExchangeClient openExchangeClient;

    @Override
    public Valute getValute(String date, String app_id, String symbols,String base) {
        return openExchangeClient.getValute(date,app_id,symbols,base);
    }
    @Override
    public Valute justTest(String date,String symbols) {
        return openExchangeClient.justTest(date, symbols);
    }
}
