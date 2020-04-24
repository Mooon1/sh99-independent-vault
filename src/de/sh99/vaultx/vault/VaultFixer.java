package de.sh99.vaultx.vault;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
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
        //disable vault

        Plugin vault = this.plugin.getServer().getPluginManager().getPlugin("Vault");

        if(null == vault){
            return;
        }

        this.plugin.getServer().getPluginManager().disablePlugin(vault);

        for (Plugin plugin:this.plugin.getServer().getPluginManager().getPlugins()) {
            for (Class<?> i:plugin.getClass().getInterfaces()){
                if(!i.toString().contains("net.milkbowl.vault")){
                    continue;
                }

                switch (i.toString()){
                    case "net.milkbowl.vault.economy.Economy":
                        Economy vaultEco = (Economy) plugin;
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
