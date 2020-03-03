package de.sh99.vault.env;

import de.sh99.vault.Environment;
import de.sh99.vault.provider.EconomyProvider;

public interface Economy extends Environment
{
    public EconomyProvider declaredProvider();
}
