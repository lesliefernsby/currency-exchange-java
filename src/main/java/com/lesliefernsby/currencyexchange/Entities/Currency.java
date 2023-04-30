package com.lesliefernsby.currencyexchange.Entities;
import jakarta.persistence.Entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Currency {

    public Currency(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    @Id
    @Column("id")
    Integer id;

    @Column("code")
    String code;

    @Column("full_name")
    String fullName;

    @Column("sign")
    String sign;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return  Objects.equals(this.code, currency.code) &&
                Objects.equals(this.fullName, currency.fullName);
    }
}
