package de.sh99.vaultx.manager;

import com.sun.istack.internal.NotNull;
import de.sh99.vaultx.economy.Transaction;
import org.bukkit.World;

import java.util.UUID;

public interface BankManager
{
    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public Transaction withdraw(@NotNull UUID playerId, @NotNull double amount, @NotNull boolean useOwnAccount);

    public Transaction deposit(@NotNull UUID playerId, @NotNull double amount, @NotNull boolean useOwnAccount);

    public double getMoney(@NotNull UUID playerId);

    public boolean hasMoney(@NotNull UUID playerId, @NotNull double amount);

    public Transaction createAccount(@NotNull UUID playerId, @NotNull double amount);

    public Transaction createAccount(@NotNull UUID playerId, @NotNull double amount, @NotNull World world);

    public Transaction closeAccount(@NotNull UUID playerId);

    public boolean hasAccount(@NotNull UUID playerId);

    public boolean isMember(@NotNull UUID playerId);

    public Transaction addMember(@NotNull UUID ownerId, UUID memberId);

    public Transaction removeMember(@NotNull UUID playerId);

}
