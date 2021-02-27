package com.example.springfeign.controller;


import com.example.springfeign.WhatDate;
import com.example.springfeign.client.GiphyClient;
import com.example.springfeign.client.OpenExchangeClient;
import com.example.springfeign.model.Gif;
import com.example.springfeign.model.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GreetingController {

    @Autowired
    GiphyClient giphyService;
    @Autowired
    OpenExchangeClient openExchangeService;

    @Value("${valute.api_key}")
    private String valute_api_key;

    @Value("${valute.base}")
    private String valute_base;

    @Value("${giphy.api_key}")
    private String giphy_api_key;



    // Вводишь валюту, 2 апи запроса потому что через оодин не смог, сравнение цен вчера и сегодня, по итогу запрос на гифу и
    // отдает гиф обджект, потому что я не понял что значит и отдает gif в ответ:

    @GetMapping("/{valuteID}")
    public Gif getValuteThenGif(@PathVariable String valuteID){
        WhatDate a = new WhatDate();
        double valuteToday, valuteYesterday;  // дата вчера и сегодня
        String richOrPoor;              // тег для поиска в гифи


        Valute val= openExchangeService.getValute(a.getDateToday() + ".json",valute_api_key,valuteID,valute_base);
        valuteToday = val.getRates().get(valuteID);
        Valute valYesterday= openExchangeService.getValute(a.getDateYesterday() + ".json",valute_api_key,valuteID,valute_base);
        //Либо используем этот вариант, передавая только тег дату и ключ валюты
        // Valute valYesterday = openExchangeService.justTest(a.getDateyYesterday() + ".json",valuteID);
        // valute_api_key будет храниться в openexchange клиенте

        valuteYesterday = valYesterday.getRates().get(valuteID);
        //кидаем 2 апи запроса, получаем цену валюты сегодня и вчера

        if(valuteToday > valuteYesterday)
            richOrPoor = "rich";
        else
            richOrPoor = "broke";
        // узнаем изменение стоимости валюты

        //1 вариант апи
        Gif gif= giphyService.getGif("random",giphy_api_key,richOrPoor,"g");

        //Gif gif= giphyService.testGif(richOrPoor);
        // Либо используем этот вариант, передавая только тег

        // запрашиваем апи гифки
        // не совсем  понял что отдавать надо, поэтому отдаю гиф модель

        return gif;
    }


}
