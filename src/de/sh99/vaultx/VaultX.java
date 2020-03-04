package de.sh99.vaultx;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public interface VaultX
{
    public Environment getEnvironmental(Class<? extends Environment> envClass);

    public void registerEnvironment(Environment env);

    public HashMap<Class<? extends Environment>, Environment> registeredEnvironments();

    public boolean hasEnvironment(Class<? extends Environment> envClass);

    public static VaultX getRuntimeInstance()
    {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("VaultX");

        if (null == plugin) {
            return null;
        }

        if(!(plugin instanceof VaultX)){
            return null;
        }

        return (VaultX) plugin;
    }
}
