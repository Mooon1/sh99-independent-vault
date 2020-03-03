package de.sh99.vault.economy;

import java.util.UUID;

public interface Balance
{
    public void add(UUID playerId, double amount);

    public void remove(UUID playerId, double amount);

    public double getMoney(UUID playerId);

    public double hasMoney(UUID playerId, double amount);
}
