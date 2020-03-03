package de.sh99.vaultx.provider;

import de.sh99.vaultx.EnvironmentProvider;
import de.sh99.vaultx.manager.BalanceManager;
import de.sh99.vaultx.manager.BankManager;

public interface EconomyProvider extends EnvironmentProvider
{
    public BalanceManager getBalanceManager();

    public BankManager getBankManager();
}
