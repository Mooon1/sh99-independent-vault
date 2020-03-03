package de.sh99.vault;

import de.sh99.vault.env.Chat;
import de.sh99.vault.env.Economy;
import de.sh99.vault.env.Permission;

public enum Environments
{
    ENV_ECONOMY(Economy.class),
    ENV_PERMISSION(Permission.class),
    ENV_CHAT(Chat.class);

    private final Class<? extends Environment> envClass;

    Environments(final Class<? extends Environment> envClass){
        this.envClass = envClass;
    }

    public Class<? extends Environment> getEnvClass() {
        return envClass;
    }
}
