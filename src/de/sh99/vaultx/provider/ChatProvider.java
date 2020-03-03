package de.sh99.vaultx.provider;

import de.sh99.vaultx.EnvironmentProvider;
import de.sh99.vaultx.manager.BalanceManager;
import de.sh99.vaultx.manager.BankManager;
import de.sh99.vaultx.manager.ChatManager;

public interface ChatProvider extends EnvironmentProvider
{
    public ChatManager getChatManager();
}
