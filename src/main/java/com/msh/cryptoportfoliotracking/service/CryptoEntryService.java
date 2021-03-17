package com.msh.cryptoportfoliotracking.service;

import com.msh.cryptoportfoliotracking.dto.CryptoEntryRequest;
import com.msh.cryptoportfoliotracking.model.CryptoEntry;

import java.util.List;

public interface CryptoEntryService {

    List<CryptoEntry> findAll();
    CryptoEntry findById(int id);
    void deleteById(int id);
    void addCryptoEntry(CryptoEntryRequest request);
    void updateCryptoEntry(CryptoEntry cryptoEntry);
    double getTotalAmountEur();
}
