package de.sh99.vaultx.economy;

public enum Transaction
{
    FAILURE(0),
    PENDING(1),
    SUCCESS(2);

    private final int state;

    Transaction(final  int state){
        this.state = state;
    }

    public final int getState() {
        return state;
    }
}
