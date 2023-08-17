package com.example.bank.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));

    /**
     * Посмотреть баланс счета
     *
     * @param accountId
     * @return
     */
    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    /**
     * Добавление денег на счет
     *
     * @param to на какой счет
     * @param amount сколько
     * @return
     */
    public void save(Long id, BigDecimal amount) {
        storage.put(id,amount);
    }
}
