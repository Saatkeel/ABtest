package com.example.springfeign.client;

import com.example.springfeign.config.ClientConfiguration;
import com.example.springfeign.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "giphy",
        url = "${giphy.url}",
        configuration = ClientConfiguration.class)
public interface GiphyClient {

    String apikey = "${giphy.api_key}"; // используется во 2 варианте передачи

    @RequestMapping(method = RequestMethod.GET, value = "/{random}")
    Gif getGif(@PathVariable  (value = "random") String random,
                @RequestParam(value = "api_key", required = true) String api_key,
                @RequestParam(value = "tag", required = true) String tag,
                @RequestParam(value = "rating",required = true) String rating);

    @RequestMapping(method = RequestMethod.GET, value = "/random?api_key=" + apikey + "&rating=g")
    Gif testGif(@RequestParam(value = "tag", required = true) String tag);

}