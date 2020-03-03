package de.sh99.vaultx;

import de.sh99.vaultx.env.Chat;
import de.sh99.vaultx.env.Economy;
import de.sh99.vaultx.env.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;

public class VaultXPlugin extends JavaPlugin implements VaultX
{
    private HashMap<Class<? extends Environment>, Environment> environments;

    public VaultXPlugin()
    {
        this.environments = new HashMap<>();
    }

    @Override
    public void onEnable()
    {
        this.saveConfig();
        FileConfiguration config = this.getConfig();
        if(!config.contains("vaultx.security.firewall.enabled")){ config.set("vaultx.security.firewall.enabled", true); }
        if(!config.contains("vaultx.compatiblity.vault.enabled")){ config.set("vaultx.compatiblity.vault.enabled", false); }
        this.saveConfig();
    }

    @Override
    public Environment getEnvironmental(Class<? extends Environment> envClass) {
        if(!this.hasEnvironment(envClass)){
            return null;
        }

        FileConfiguration config = this.getConfig();

        if(null == config.get("vaultx.firewall.providers." + envClass.getName())){
            return null;
        }

        if(!config.getBoolean("vaultx.firewall.providers." + envClass.getName()+".use")){
            return null;
        }

        return this.environments.get(envClass);
    }

    @Override
    public void registerEnvironment(Environment env) {
        if(!this.getClass().equals(VaultXPlugin.class)){
            return;
        }

        if(this.hasEnvironment(env.getClass())){
            return;
        }

        if(!Environment.isValid(env.getClass())){
            return;
        }

        this.environments.put(env.getClass(), env);

        FileConfiguration config = this.getConfig();

        if(config.contains("vaultx.firewall.providers." + env.getClass().getName())){
            return;
        }

        config.set("vaultx.firewall.providers." + env.getClass().getName() + ".use", false);
        config.set("vaultx.firewall.providers." + env.getClass().getName() + ".class", env.getClass().toString());
        config.set("vaultx.firewall.providers." + env.getClass().getName() + ".type", (env instanceof Economy) ? "Economy" : (env instanceof Chat ? "Chat" : (env instanceof Permission) ? "Permission" : "Unknown Provider"));
    }

    @Override
    public boolean hasEnvironment(Class<? extends Environment> envClass) {
        if(!this.environments.containsKey(envClass)){
            return false;
        }

        return true;
    }
}
