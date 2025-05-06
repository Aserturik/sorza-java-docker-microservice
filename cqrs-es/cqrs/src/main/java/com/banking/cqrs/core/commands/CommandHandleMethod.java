package com.banking.cqrs.core.commands;

@FunctionalInterface
public interface CommandHandleMethod <T extends BaseCommand> {
    void handle(T command);
}