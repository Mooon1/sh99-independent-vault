package de.sh99.vaultx.env.provider;

import de.sh99.vaultx.EnvironmentProvider;
import de.sh99.vaultx.manager.ChatManager;

public interface ChatProvider extends EnvironmentProvider
{
    public ChatManager getChatManager();
}
