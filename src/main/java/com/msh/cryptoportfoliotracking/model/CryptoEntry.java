package com.msh.cryptoportfoliotracking.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crypto_entry")
@Data
public class CryptoEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cryptocurrency")
    private Cryptocurrency cryptocurrency;

    @Column(name = "amount")
    private int amount;

    @CreationTimestamp
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

    @Column(name = "wallet_location")
    private String walletLocation;

    @Column(name = "current_market_value_eur")
    private double currentMarketValueEur;
}
