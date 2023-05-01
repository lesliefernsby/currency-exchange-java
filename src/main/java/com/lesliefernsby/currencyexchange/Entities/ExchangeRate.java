package com.lesliefernsby.currencyexchange.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Data
@Entity 
@Table(name = "exchange_rates")
public class ExchangeRate {
    @Id
    @Column("id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "base_currency_id", referencedColumnName = "id")
    Currency baseCurrency;

    @ManyToOne
    @JoinColumn(name = "target_currency_id", referencedColumnName = "id")
    Currency targetCurrency;

    @Column("rate")
    BigDecimal rate;

}
