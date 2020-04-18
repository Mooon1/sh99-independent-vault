package de.sh99.vaultx.env.provider;

import de.sh99.vaultx.EnvironmentProvider;
import de.sh99.vaultx.manager.PermissionManager;

public interface PermissionProvider extends EnvironmentProvider
{
    public PermissionManager getPermissionManager();
}
