package com.banking.cqrs.core.commands;

public interface CommandHandlerMethod <T extends BaseCommand> {
    void handle(T command);
}
