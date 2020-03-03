package de.sh99.vaultx;

public interface Environment
{
    public static boolean isValid(Class<? extends Environment> envClass)
    {
        for (Environments envs:Environments.values()){
            if(!envClass.equals(envs.getEnvClass())){
                continue;
            }

            return true;
        }

        return false;
    }
}
