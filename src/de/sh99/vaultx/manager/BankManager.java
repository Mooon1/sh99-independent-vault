package de.sh99.vaultx.manager;

import de.sh99.vaultx.economy.Transaction;
import org.bukkit.World;

import java.util.UUID;

public interface BankManager
{
    public boolean isEnabled();

    public void setEnabled(boolean enabled);

    public Transaction withdraw( UUID playerId,  double amount,  boolean useOwnAccount);

    public Transaction deposit( UUID playerId,  double amount,  boolean useOwnAccount);

    public double getMoney( UUID playerId);

    public boolean hasMoney( UUID playerId,  double amount);

    public Transaction createAccount( UUID playerId,  double amount);

    public Transaction createAccount( UUID playerId,  double amount,  World world);

    public Transaction closeAccount( UUID playerId);

    public boolean hasAccount( UUID playerId);

    public boolean isMember( UUID playerId);

    public Transaction addMember( UUID ownerId, UUID memberId);

    public Transaction removeMember( UUID playerId);

}
