package com.msh.cryptoportfoliotracking.controller;

import com.msh.cryptoportfoliotracking.dto.CryptoEntryRequest;
import com.msh.cryptoportfoliotracking.model.CryptoEntry;
import com.msh.cryptoportfoliotracking.service.CryptoEntryService;
import com.msh.cryptoportfoliotracking.service.CryptoEntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntryController {

    private CryptoEntryService cryptoEntryService;

    @Autowired
    public EntryController(CryptoEntryServiceImpl cryptoEntryServiceImpl) {
        this.cryptoEntryService = cryptoEntryServiceImpl;
    }

    @GetMapping("/cryptoentries")
    public List<CryptoEntry> getAllCryptoEntries() throws Exception {
        return cryptoEntryService.findAll();
    }

    @GetMapping("/cryptoentries/{cryptoentryId}")
    public CryptoEntry getCryptoEntry(@PathVariable int cryptoentryId){
        CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
        if (cryptoEntry == null) {
            throw new RuntimeException("Entry not found with id - " + cryptoentryId);
        }
        return cryptoEntry;
    }

    @DeleteMapping("/cryptoentries/{cryptoentryId}")
    public String deleteCryptoEntry(@PathVariable int cryptoentryId){
        CryptoEntry cryptoEntry = cryptoEntryService.findById(cryptoentryId);
        if (cryptoEntry == null) {
            throw new RuntimeException("Entry not found with id - " + cryptoentryId);
        }
        cryptoEntryService.deleteById(cryptoentryId);
        return "Deleted entry with id - " + cryptoentryId;
    }

    @PostMapping("/cryptoentries")
    public List<CryptoEntry> addCryptoEntry(@RequestBody CryptoEntryRequest request){
        cryptoEntryService.addCryptoEntry(request);
        return cryptoEntryService.findAll();
    }
}
