package de.sh99.vaultx;

import de.sh99.vaultx.command.VaultXCommand;
import de.sh99.vaultx.environment.ChatEnvironment;
import de.sh99.vaultx.environment.EconomyEnvironment;
import de.sh99.vaultx.environment.VaultXEnvironment;
import de.sh99.vaultx.environment.PermissionEnvironment;
import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class VaultXPlugin extends JavaPlugin implements VaultX
{
    private static final String CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ = "vaultx.security.firewall";

    private HashMap<Class<? extends VaultXEnvironment>, VaultXEnvironment> environments;

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
    public VaultXEnvironment getEnvironmental(Class<? extends VaultXEnvironment> envClass) {
        FileConfiguration config = this.getConfig();

        for (VaultXEnvironment environment :this.environments.values()){
            for (Class<?> envInterface: environment.getClass().getInterfaces()){
                if(!envClass.equals(envInterface)){
                    continue;
                }

                if(!config.getBoolean(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + convertSnakecaseToUndescore(environment.getClass().getName()).replace(".", "_") + ".use", false)){
                    return null;
                }
                return environment;
            }
        }

        return null;
    }

    @Override
    public void registerEnvironment(VaultXEnvironment environment) {
        if(this.hasEnvironment(environment.getClass())){
            return;
        }

        this.environments.put(environment.getClass(), environment);

        FileConfiguration config = this.getConfig();

        String clazz = convertSnakecaseToUndescore(environment.getClass().getName());

        if(config.contains(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz.replace(".", "_"))){
            return;
        }

        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz.replace(".", "_") + ".use", false);
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz.replace(".", "_")  + ".class", environment.getClass().toString().replace("class ", ""));
        config.set(CFG_VAULTX_SECURITY_FIREWALL_PROVIDER_ + clazz.replace(".", "_")  + ".type", (environment instanceof EconomyEnvironment) ? convertSnakecaseToUndescore(EconomyEnvironment.class.getName()) : (environment instanceof ChatEnvironment ? convertSnakecaseToUndescore(ChatEnvironment.class.getName()) : (environment instanceof PermissionEnvironment) ? convertSnakecaseToUndescore(PermissionEnvironment.class.getName()) : null));
        this.saveConfig();
    }

    @Override
    public HashMap<Class<? extends VaultXEnvironment>, VaultXEnvironment> registeredEnvironments() {
        return this.environments;
    }

    private static String convertSnakecaseToUndescore(String str)
    {
        if(str.contains(" ")){
            str = str.split(" ")[1];
        }

        return str.replace(".", "_");
    }

    @Override
    public boolean hasEnvironment(Class<? extends VaultXEnvironment> envClass) {
        return this.environments.containsKey(envClass);
    }
}
