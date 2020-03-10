package de.sh99.vaultx.economy;

public enum Reason
{
    NO_ACCOUNT("no-account"),
    NOT_ENOUGHT_MONEY("not-enought-money"),
    NO_ACCESS("no-access"),
    PERSISTENCE_FAILURE("persistence-failure"),
    DISABLED("disabled"),
    NEGATIVE_VALUE("negative-value"),
    UNDEFINED("undefined");

    private final String identifier;

    Reason(final  String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
