package de.sh99.vaultx.provider;

import de.sh99.vaultx.manager.ChatManager;

public interface ChatProvider extends VaultXProvider
{
    public ChatManager getChatManager();
}
