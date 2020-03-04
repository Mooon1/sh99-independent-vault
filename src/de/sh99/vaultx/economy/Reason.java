package de.sh99.vaultx.economy;

public enum Reason
{
    NO_ACCOUNT("no-account"),
    NOT_ENOUGHT_MONEY("not-enought-money"),
    NO_ACCESS("no-access");

    private final String identifier;

    Reason(final  String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
