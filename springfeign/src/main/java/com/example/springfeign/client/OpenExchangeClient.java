package com.example.springfeign.client;

import com.example.springfeign.WhatDate;
import com.example.springfeign.config.ClientConfiguration;
import com.example.springfeign.model.Valute;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openexchange",
        url = "${exchange.url}",
        configuration = ClientConfiguration.class)
public interface OpenExchangeClient {
    String base = "${valute.base}";
    String appid="${valute.api_key}";// используются во 2 варианте передачи


    //1 вариант
    @RequestMapping(method = RequestMethod.GET, value = "/{date}")
    Valute getValute(@PathVariable(value = "date") String date,
                     @RequestParam(value = "app_id", required = true) String app_id,
                     @RequestParam(value = "symbols", required = true) String symbols,
                     @RequestParam(value = "base",required = true) String base);
    //2 вариант
    @RequestMapping(method = RequestMethod.GET, value = "/{date}" +"?app_id=" + appid + "&base=" + base)
    Valute justTest(@PathVariable(value = "date") String date,
                     @RequestParam(value = "symbols", required = true) String symbols);
}
