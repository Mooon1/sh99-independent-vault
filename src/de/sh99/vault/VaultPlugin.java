package de.sh99.vault;

public interface VaultPlugin
{
    public Environment getEnvironmental(Class<? extends Environment> envClass);

    public void registerEnvironment(Environment env);

    public boolean hasEnvironment(Class<? extends Environment> envClass);
}
