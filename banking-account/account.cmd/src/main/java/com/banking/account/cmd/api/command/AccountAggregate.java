package com.banking.account.cmd.api.command;

import com.banking.account.common.events.AccountOpenedEvent;
import com.banking.cqrs.core.domain.AggregateRoot;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class AccountAggregate extends AggregateRoot {
    private Boolean active;
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public AccountAggregate(String id, String accountHolder, double openingBalance) {
        raiseEvent(new AccountOpenedEvent(id, accountHolder, openingBalance, new Date()));
    }

    public void apply(AccountOpenedEvent event) {
        this.id = event.getId();
        this.active = true;
        this.balance = event.getOpeningBalance();
    }
}