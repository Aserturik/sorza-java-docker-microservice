package com.banking.account.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banking.account.cmd.api.command.CloseAccountCommand;
import com.banking.account.cmd.api.command.CommandHandler;
import com.banking.account.cmd.api.command.DepositFoundsCommand;
import com.banking.account.cmd.api.command.OpenAccountCommand;
import com.banking.account.cmd.api.command.WithdrawFundsCommand;
import com.banking.cqrs.core.infrastructure.CommandDispatcher;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class CommandApplication {

    @Autowired
    private CommandDispatcher commandDispatcher;

    @Autowired
    private CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }

    @PostConstruct
    public void registerHandlers() {
        commandDispatcher.registerHandler(OpenAccountCommand.class, commandHandler::handle);
        commandDispatcher.registerHandler(DepositFoundsCommand.class, commandHandler::handle);
        commandDispatcher.registerHandler(WithdrawFundsCommand.class, commandHandler::handle);
        commandDispatcher.registerHandler(CloseAccountCommand.class, commandHandler::handle);
    }
}
