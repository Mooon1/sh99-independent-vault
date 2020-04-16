package de.sh99.vaultx.vault;

import org.bukkit.plugin.Plugin;

public class VaultFixer
{
    private Plugin plugin;

    public VaultFixer(Plugin plugin)
    {
        this.plugin = plugin;
    }

    public void fix()
    {
        if(null == this.plugin.getServer().getPluginManager().getPlugin("Vault")){
            return;
        }

        for (Plugin plugin:this.plugin.getServer().getPluginManager().getPlugins()) {
            for (Class<?> i:plugin.getClass().getInterfaces()){
                if(!i.toString().contains("net.milkbowl.vault")){
                    continue;
                }

                switch (i.toString()){
                    case "net.milkbowl.vault.economy.Economy":
                        continue;
                    case "net.milkbowl.vault.chat.Chat":
                        continue;
                    case "net.milkbowl.vault.permission.Permission":
                        continue;
                }
            }
        }
    }
}
