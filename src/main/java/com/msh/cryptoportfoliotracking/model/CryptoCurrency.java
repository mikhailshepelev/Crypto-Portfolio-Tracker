package com.msh.cryptoportfoliotracking.model;


public enum CryptoCurrency {
    BITCOIN("tBTCEUR");

    String symbol;

    CryptoCurrency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
