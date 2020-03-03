package de.sh99.vaultx.env;

import de.sh99.vaultx.Environment;
import de.sh99.vaultx.provider.PermissionProvider;

public interface Permission extends Environment
{
    public PermissionProvider declaredProvider();

}
