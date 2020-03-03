package de.sh99.vaultx.env;

import de.sh99.vaultx.Environment;
import de.sh99.vaultx.provider.ChatProvider;

public interface Chat extends Environment
{
    public ChatProvider declaredProvider();

}
