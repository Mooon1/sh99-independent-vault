package de.sh99.vaultx.economy;

import java.util.UUID;

public interface BalanceManager
{
    public void add(UUID playerId, double amount);

    public void remove(UUID playerId, double amount);

    public double getMoney(UUID playerId);

    public double hasMoney(UUID playerId, double amount);
}
