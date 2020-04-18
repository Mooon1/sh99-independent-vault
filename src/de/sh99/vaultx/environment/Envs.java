package de.sh99.vaultx.environment;

public enum Envs
{
    ENV_ECONOMY(EconomyEnvironment.class),
    ENV_PERMISSION(PermissionEnvironment.class),
    ENV_CHAT(ChatEnvironment.class);

    private final Class<? extends VaultXEnvironment> envClass;

    Envs(final Class<? extends VaultXEnvironment> envClass){
        this.envClass = envClass;
    }

    public Class<? extends VaultXEnvironment> getEnvClass() {
        return envClass;
    }
}
