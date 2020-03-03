package de.sh99.vaultx.economy;

import com.sun.istack.internal.NotNull;

import java.util.UUID;

public interface BalanceManager
{
    public void add(@NotNull UUID playerId, @NotNull double amount);

    public void remove(@NotNull UUID playerId, @NotNull double amount);

    public double getMoney(@NotNull UUID playerId);

    public double hasMoney(@NotNull UUID playerId, @NotNull double amount);
}
