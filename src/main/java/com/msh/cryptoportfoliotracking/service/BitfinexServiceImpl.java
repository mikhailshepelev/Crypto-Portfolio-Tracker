package com.msh.cryptoportfoliotracking.service;

import com.msh.cryptoportfoliotracking.dto.TickerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitfinexServiceImpl implements BitfinexService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bitfinex_api_url}")
    private String apiUrl;

    public double getCurrentMarketValue(String symbol) {

        Object[] object = restTemplate.getForObject(
                apiUrl + symbol, Object[].class);

        assert object != null;
        TickerDto tickerDto = TickerDto.CreateTickerDtoFromObjectArray(object);

        System.out.println(tickerDto.getBid());

        return tickerDto.getBid();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
