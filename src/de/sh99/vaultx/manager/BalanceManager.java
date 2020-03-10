package de.sh99.vaultx.manager;

import com.sun.istack.internal.NotNull;
import de.sh99.vaultx.economy.Transaction;

import java.util.UUID;

public interface BalanceManager
{
    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public Transaction add(@NotNull UUID playerId, @NotNull double amount);

    public Transaction remove(@NotNull UUID playerId, @NotNull double amount);

    public double getMoney(@NotNull UUID playerId);

    public boolean hasMoney(@NotNull UUID playerId, @NotNull double amount);
}
