package de.sh99.vaultx.env;

import de.sh99.vaultx.Environment;
import de.sh99.vaultx.env.provider.EconomyProvider;

public interface Economy extends Environment
{
    public EconomyProvider declaredProvider();
}
