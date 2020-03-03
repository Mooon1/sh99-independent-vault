package de.sh99.vault.provider;

import de.sh99.vault.EnvironmentProvider;
import de.sh99.vault.economy.BalanceManager;
import de.sh99.vault.economy.BankManager;

public interface EconomyProvider extends EnvironmentProvider
{
    public BalanceManager getBalanceManager();

    public BankManager getBankManager();
}
