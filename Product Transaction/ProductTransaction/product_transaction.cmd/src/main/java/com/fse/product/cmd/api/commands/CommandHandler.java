package com.fse.product.cmd.api.commands;

public interface CommandHandler {
    void handle(Transaction command);
}
