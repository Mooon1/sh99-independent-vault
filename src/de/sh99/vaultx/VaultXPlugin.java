package de.sh99.vaultx;

import de.sh99.vaultx.command.VaultXCommand;
import de.sh99.vaultx.env.Chat;
import de.sh99.vaultx.env.Economy;
import de.sh99.vaultx.env.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.HashMap;

public class VaultXPlugin extends JavaPlugin implements VaultX
{
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

        this.getCommand("vaultx").setExecutor(new VaultXCommand(this));
        this.getCommand("vaultx").setTabCompleter(new VaultXCommand(this));
    }

    @Override
    public Environment getEnvironmental(Class<? extends Environment> envClass) {
        FileConfiguration config = this.getConfig();

        for (Environment env:this.environments.values()){
            for (Class<?> envInterface:env.getClass().getInterfaces()){
                if(!envClass.equals(envInterface)){
                    continue;
                }

                if(!config.getBoolean(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + convertSnakecaseToUndescore(env.getClass().getName()) + ".use", false)){
                    return null;
                }
                return env;
            }
        }

        return null;
    }

    @Override
    public void registerEnvironment(Environment env) {
        if(this.hasEnvironment(env.getClass())){
            return;
        }

        this.environments.put(env.getClass(), env);

        FileConfiguration config = this.getConfig();

        String clazz = convertSnakecaseToUndescore(env.getClass().getName());

        if(config.contains(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz)){
            return;
        }

        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz + ".use", false);
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz + ".class", env.getClass().toString().replace("class ", ""));
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz + ".type", (env instanceof Economy) ? convertSnakecaseToUndescore(Economy.class.getName()) : (env instanceof Chat ? convertSnakecaseToUndescore(Chat.class.getName()) : (env instanceof Permission) ? convertSnakecaseToUndescore(Permission.class.getName()) : null));
        this.saveConfig();
    }

    @Override
    public HashMap<Class<? extends Environment>, Environment> registeredEnvironments() {
        return this.environments;
    }

    public static String convertSnakecaseToUndescore(String str)
    {
        if(str.contains(" ")){
            str = str.split(" ")[1];
        }

        return str.replace(".", "_");
    }

    @Override
    public boolean hasEnvironment(Class<? extends Environment> envClass) {
        if(!this.environments.containsKey(envClass)){
            return false;
        }

        return true;
    }
}
