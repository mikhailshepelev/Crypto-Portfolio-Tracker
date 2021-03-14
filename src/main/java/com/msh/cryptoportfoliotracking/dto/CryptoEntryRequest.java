package com.msh.cryptoportfoliotracking.dto;

import lombok.Data;

@Data
public class CryptoEntryRequest {
    private String cryptocurrencyName;
    private int amountPurchased;
    private String walletLocation;
}
