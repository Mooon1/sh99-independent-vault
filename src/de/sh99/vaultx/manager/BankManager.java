package de.sh99.vaultx.manager;

import com.sun.istack.internal.NotNull;
import org.bukkit.World;

import java.util.UUID;

public interface BankManager
{
    public boolean isEnabled();

    public void setEnabled();

    public void withdraw(@NotNull UUID playerId, @NotNull double amount);

    public void deposit(@NotNull UUID playerId, @NotNull double amount);

    public double getMoney(@NotNull UUID playerId);

    public double hasMoney(@NotNull UUID playerId, @NotNull double amount);

    public void createAccount(@NotNull UUID playerId, @NotNull double amount);

    public void createAccount(@NotNull UUID playerId, @NotNull double amount, @NotNull World world);

    public void closeAccount(@NotNull UUID playerId);

    public boolean hasAccount(@NotNull UUID playerId);

    public boolean isMember(@NotNull UUID playerId);

    public void addMember(@NotNull UUID ownerId, UUID memberId);

    public void removeMember(@NotNull UUID playerId);

}
