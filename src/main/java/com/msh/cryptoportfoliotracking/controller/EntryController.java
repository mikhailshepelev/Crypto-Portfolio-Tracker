package com.msh.cryptoportfoliotracking.controller;

import com.msh.cryptoportfoliotracking.dto.CryptoEntryRequest;
import com.msh.cryptoportfoliotracking.model.CryptoEntry;
import com.msh.cryptoportfoliotracking.service.CryptoEntryService;
import com.msh.cryptoportfoliotracking.service.CryptoEntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cryptoentries")
public class EntryController {

    private CryptoEntryService cryptoEntryService;

    @Autowired
    public EntryController(CryptoEntryServiceImpl cryptoEntryServiceImpl) {
        this.cryptoEntryService = cryptoEntryServiceImpl;
    }

    @GetMapping
    public List<CryptoEntry> getAllCryptoEntries() throws Exception {
        return cryptoEntryService.findAll();
    }

    @GetMapping("/{cryptoentryId}")
    public CryptoEntry getCryptoEntry(@PathVariable int cryptoentryId){
        CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
        if (cryptoEntry == null) {
            throw new RuntimeException("Entry not found with id - " + cryptoentryId);
        }
        return cryptoEntry;
    }

    @GetMapping("/totalamount")
    public double getTotalAmountEur() {
        return cryptoEntryService.getTotalAmountEur();
    }

    @DeleteMapping("/{cryptoentryId}")
    public String deleteCryptoEntry(@PathVariable int cryptoentryId){
        CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
        if (cryptoEntry == null) {
            throw new RuntimeException("Entry not found with id - " + cryptoentryId);
        }
        cryptoEntryService.deleteById(cryptoentryId);
        return "Deleted entry with id - " + cryptoentryId;
    }

    @PostMapping
    public List<CryptoEntry> addCryptoEntry(@RequestBody CryptoEntryRequest request){
        cryptoEntryService.addCryptoEntry(request);
        return cryptoEntryService.findAll();
    }

    @PutMapping
    public CryptoEntry updateCryptoEntry(@RequestBody CryptoEntry cryptoEntry){
        cryptoEntryService.updateCryptoEntry(cryptoEntry);
        return cryptoEntry;
    }
}
