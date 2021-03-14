package com.msh.cryptoportfoliotracking.dto;

import lombok.Data;

@Data
public class TickerDto {
    private double bid;
    private double bidSize;
    private double ask;
    private double askSize;
    private double dailyChange;
    private double dailyChangeRelative;
    private double lastPrice;
    private double volume;
    private double high;
    private double low;

    public static TickerDto CreateTickerDtoFromObjectArray(Object[] objects) {
        TickerDto tickerDto = new TickerDto();
        tickerDto.setBid(Double.parseDouble(objects[0].toString()));
        tickerDto.setBidSize(Double.parseDouble(objects[1].toString()));
        tickerDto.setAsk(Double.parseDouble(objects[2].toString()));
        tickerDto.setAskSize(Double.parseDouble(objects[3].toString()));
        tickerDto.setDailyChange(Double.parseDouble(objects[4].toString()));
        tickerDto.setDailyChangeRelative(Double.parseDouble(objects[5].toString()));
        tickerDto.setLastPrice(Double.parseDouble(objects[6].toString()));
        tickerDto.setVolume(Double.parseDouble(objects[7].toString()));
        tickerDto.setHigh(Double.parseDouble(objects[8].toString()));
        tickerDto.setLow(Double.parseDouble(objects[9].toString()));

        return tickerDto;
    }
}
