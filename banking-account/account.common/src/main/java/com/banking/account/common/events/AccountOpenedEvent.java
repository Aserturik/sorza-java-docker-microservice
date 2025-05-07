package com.banking.account.common.events;

import com.banking.account.common.dto.AccountType;
import com.banking.cqrs.core.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AccountOpenedEvent extends BaseEvent {
    public AccountOpenedEvent(String id, String accountHolder2, double openingBalance2, Date date) {
        //TODO Auto-generated constructor stub
    }
    private String accountHolder;
    private AccountType accountType;
    private Date createdDate;
    private double openingBalance;
}
