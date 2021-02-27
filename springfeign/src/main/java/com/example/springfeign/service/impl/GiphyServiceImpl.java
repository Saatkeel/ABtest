package com.example.springfeign.service.impl;

import com.example.springfeign.client.GiphyClient;
import com.example.springfeign.model.Gif;
import com.example.springfeign.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService {
    @Autowired
    private GiphyClient giphyClient;


    @Override
    public Gif getGif(String random, String apik, String tag, String rating) {
        return giphyClient.getGif(random,apik,tag,rating);
    }

    @Override
    public Gif testGif(String tag) {
        return giphyClient.testGif(tag);
    }
}
