package de.sh99.vault;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class IndependentVaultPlugin extends JavaPlugin implements VaultPlugin
{
    private HashMap<Class<? extends Environment>, Environment> environments;

    @Override
    public void onEnable()
    {
        this.environments = new HashMap<>();
    }

    @Override
    public Environment getEnvironmental(Class<? extends Environment> envClass) {
        if(!this.hasEnvironment(envClass)){
            return null;
        }

        return this.environments.get(envClass);
    }

    @Override
    public void registerEnvironment(Environment env) {
        if(this.hasEnvironment(env.getClass())){
            return;
        }

        if(!Environment.isValid(env.getClass())){
            return;
        }

        this.environments.put(env.getClass(), env);
    }

    @Override
    public boolean hasEnvironment(Class<? extends Environment> envClass) {
        if(!this.environments.containsKey(envClass)){
            return false;
        }

        return true;
    }
}
