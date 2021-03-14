package com.msh.cryptoportfoliotracking.service;

import com.msh.cryptoportfoliotracking.dto.CryptoEntryRequest;
import com.msh.cryptoportfoliotracking.model.CryptoEntry;
import com.msh.cryptoportfoliotracking.model.CryptoCurrency;
import com.msh.cryptoportfoliotracking.repository.CryptoEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoEntryServiceImpl implements CryptoEntryService {

    @Autowired
    private CryptoEntryRepository cryptoEntryRepository;

    @Autowired
    private BitfinexService bitfinexService;

    @Override
    public List<CryptoEntry> findAll() {
        return cryptoEntryRepository.findAll();
    }

    @Override
    public CryptoEntry findById(int id) {
        Optional<CryptoEntry> result = cryptoEntryRepository.findById(id);
        CryptoEntry cryptoEntry;
        if (result.isPresent()) {
            cryptoEntry = result.get();
        }
        else {
            throw new RuntimeException("Did not find entry with id - " + id);
        }
        return cryptoEntry;
    }

    @Override
    public void deleteById(int id) {
        cryptoEntryRepository.deleteById(id);
    }

    @Override
    public void addCryptoEntry(CryptoEntryRequest request) {

        CryptoCurrency cryptoCurrency =  CryptoCurrency.valueOf(request.getCryptocurrencyName().toUpperCase());
        double currentMarketValue = bitfinexService.getCurrentMarketValue(cryptoCurrency.getSymbol());

        CryptoEntry cryptoEntry = new CryptoEntry(cryptoCurrency, request.getAmountPurchased(),
                                                    request.getWalletLocation(), currentMarketValue);

        cryptoEntryRepository.save(cryptoEntry);
    }
}
