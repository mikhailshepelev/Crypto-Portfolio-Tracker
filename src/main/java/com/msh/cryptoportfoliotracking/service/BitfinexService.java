package com.msh.cryptoportfoliotracking.service;

import org.springframework.retry.annotation.Retryable;

public interface BitfinexService {

    @Retryable(value = RuntimeException.class)
    double getCurrentMarketValue(String symbol);
}
