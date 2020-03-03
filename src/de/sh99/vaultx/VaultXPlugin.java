package de.sh99.vaultx;

import de.sh99.vaultx.env.Chat;
import de.sh99.vaultx.env.Economy;
import de.sh99.vaultx.env.Permission;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;

public class VaultXPlugin extends JavaPlugin implements VaultX
{
    private static final String CFG_VAULTX_COMPATIBILITY_VAULT_ENABLED = "vaultx.compatibility.vault.enabled";
    private static final String CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ = "vaultx.security.firewall.provider.";

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
        if(!config.contains(CFG_VAULTX_COMPATIBILITY_VAULT_ENABLED)){ config.set(CFG_VAULTX_COMPATIBILITY_VAULT_ENABLED, false); }
        this.saveConfig();


        if(!config.getBoolean(CFG_VAULTX_COMPATIBILITY_VAULT_ENABLED)){
            Plugin vaultPlugin = Bukkit.getPluginManager().getPlugin("Vault");
            if(null == vaultPlugin){
                return;
            }
            Bukkit.getPluginManager().disablePlugin(vaultPlugin);
        }
    }

    @Override
    public Environment getEnvironmental(Class<? extends Environment> envClass) {
        if(!this.hasEnvironment(envClass)){
            return null;
        }

        FileConfiguration config = this.getConfig();

        if(null == config.get(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + envClass.getName())){
            return null;
        }

        if(!config.getBoolean(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + envClass.getName() + ".use")){
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

        if(config.contains(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + env.getClass().getName())){
            return;
        }

        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + env.getClass().getName() + ".use", false);
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + env.getClass().getName() + ".class", env.getClass().toString());
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + env.getClass().getName() + ".type", (env instanceof Economy) ? "Economy" : (env instanceof Chat ? "Chat" : (env instanceof Permission) ? "Permission" : "Unknown Provider"));
        this.saveConfig();
    }

    @Override
    public boolean hasEnvironment(Class<? extends Environment> envClass) {
        if(!this.environments.containsKey(envClass)){
            return false;
        }

        return true;
    }
}
