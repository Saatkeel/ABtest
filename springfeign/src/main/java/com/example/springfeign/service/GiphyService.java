package com.example.springfeign.service;


import com.example.springfeign.model.Gif;

public interface GiphyService {
    Gif getGif(String random, String apik, String tag,String rating);
    Gif testGif(String tag);
}
