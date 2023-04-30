package com.lesliefernsby.currencyexchange.Repositories;

import com.lesliefernsby.currencyexchange.Entities.Currency;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    @Query("SELECT * FROM currencies")
    public List<Currency> getAll();

    @Query("SELECT * FROM currencies WHERE id = :id")
    public Currency getById(int id);

    @Query("SELECT * FROM currencies WHERE code = :code")
    public Currency getByCode(String code);

    @Transactional
    @Modifying
    @Query("INSERT INTO currencies (code, full_name, sign) VALUES (:code, :full_name, :sign)")
    public void insertCurrency(String code, String full_name, String sign);
}
