package de.sh99.vaultx.economy;

import org.bukkit.World;

import java.util.UUID;

public interface BankManager
{
    public void withdraw(UUID playerId, double amount);

    public void deposit(UUID playerId, double amount);

    public double getMoney(UUID playerId);

    public double hasMoney(UUID playerId, double amount);

    public void createAccount(UUID playerId, double amount);

    public void createAccount(UUID playerId, double amount, World world);

    public void closeAccount(UUID playerId);

    public boolean hasAccount(UUID playerId);

    public boolean isMember(UUID playerId);

    public void addMember(UUID ownerId, UUID memberId);

    public void removeMember(UUID playerId);

}
