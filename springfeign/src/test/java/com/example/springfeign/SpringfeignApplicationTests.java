package com.example.springfeign;

import com.example.springfeign.client.GiphyClient;
import com.example.springfeign.client.OpenExchangeClient;
import com.example.springfeign.model.Gif;
import com.example.springfeign.model.Valute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class SpringfeignApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	GiphyClient giphyService;
	@Autowired
	OpenExchangeClient openExchangeService;


	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

	@Test
	public void whenValuteID_FJD_WithCurrentData_Exists() {

		WhatDate a = new WhatDate();
		Valute valute = openExchangeService.justTest(a.getDateToday()+ ".json", "FJD");

		assertNotNull(valute);
	}

	@Test
	public void whenGifWithTagRich_Exists() {

		Gif gif = giphyService.testGif("rich");

		assertNotNull(gif);
	}


}
