package com.lesliefernsby.currencyexchange.Entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
public class Currency {

    @Id
    @Column("id")
    Integer id;

    @Column("code")
    String code;

    @Column("full_name")
    String fullName;

    @Column("sign")
    String sign;
}
