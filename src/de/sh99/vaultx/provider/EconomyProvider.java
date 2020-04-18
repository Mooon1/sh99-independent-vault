package de.sh99.vaultx.provider;

import de.sh99.vaultx.manager.BalanceManager;
import de.sh99.vaultx.manager.BankManager;

public interface EconomyProvider extends VaultXProvider
{
    public BalanceManager getBalanceManager();

    public BankManager getBankManager();
}
