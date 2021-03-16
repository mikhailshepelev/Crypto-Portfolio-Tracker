package com.msh.cryptoportfoliotracking.model;


public enum CryptoCurrency {

    BITCOIN("tBTCEUR"),
    EOS("tEOSEUR"),
    ETHEREUM("tETHEUR"),
    PARKINGO("tGOTEUR"),
    IOTA("tIOTEUR"),
    NEO("tNEOEUR"),
    TRON("tTRXEUR");

    String symbol;

    CryptoCurrency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
