package com.msh.cryptoportfoliotracking.repository;

import com.msh.cryptoportfoliotracking.model.CryptoEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoEntryRepository extends JpaRepository<CryptoEntry, Integer> {
}
