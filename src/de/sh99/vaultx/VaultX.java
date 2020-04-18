package de.sh99.vaultx;

import de.sh99.vaultx.environment.VaultXEnvironment;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public interface VaultX
{
    public static final String PLUGIN_NAME = "VaultX";

    public VaultXEnvironment getEnvironmental(Class<? extends VaultXEnvironment> envClass);

    public void registerEnvironment(VaultXEnvironment environment);

    public HashMap<Class<? extends VaultXEnvironment>, VaultXEnvironment> registeredEnvironments();

    public boolean hasEnvironment(Class<? extends VaultXEnvironment> envClass);

    public static VaultX getRuntimeInstance()
    {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME);

        if (null == plugin) {
            return null;
        }

        if(!(plugin instanceof VaultX)){
            return null;
        }

        return (VaultX) plugin;
    }
}
