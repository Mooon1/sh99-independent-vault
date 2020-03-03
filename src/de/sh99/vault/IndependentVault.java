package de.sh99.vault;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public interface IndependentVault
{
    public Environment getEnvironmental(Class<? extends Environment> envClass);

    public void registerEnvironment(Environment env);

    public boolean hasEnvironment(Class<? extends Environment> envClass);

    public static IndependentVault getRuntimeInstance()
    {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("IndependentVault");

        if (null == plugin) {
            return null;
        }

        if(!(plugin instanceof IndependentVault)){
            return null;
        }

        return (IndependentVault) plugin;
    }
}
