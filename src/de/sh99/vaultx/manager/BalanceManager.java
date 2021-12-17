package de.sh99.vaultx.manager;

import de.sh99.vaultx.economy.Transaction;

import java.util.UUID;

public interface BalanceManager
{
    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public Transaction add( UUID playerId,  double amount);

    public Transaction remove( UUID playerId,  double amount);

    public double getMoney( UUID playerId);

    public boolean hasMoney( UUID playerId,  double amount);
}
