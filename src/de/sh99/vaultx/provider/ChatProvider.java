package de.sh99.vaultx.provider;

import de.sh99.vaultx.EnvironmentProvider;
import de.sh99.vaultx.economy.BalanceManager;
import de.sh99.vaultx.economy.BankManager;

public interface ChatProvider extends EnvironmentProvider
{
    public BalanceManager getBalanceManager();

    public BankManager getBankManager();
}
