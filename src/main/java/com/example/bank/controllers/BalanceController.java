package com.example.bank.controllers;

import com.example.bank.models.TransferBalance;
import com.example.bank.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
@AllArgsConstructor
@Slf4j
public class BalanceController {
    private final BankService bankService;

    /**
     * Получить деньги
     *
     * @param accountId
     * @return
     */
    @GetMapping("{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);
    }

    /**
     * Добавить деньги
     *
     * @param transferBalance
     * @return
     */
    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    /**
     * Перевести деньги
     *
     * @param transferBalance
     * @return
     */
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "I dont work";
    }
}
