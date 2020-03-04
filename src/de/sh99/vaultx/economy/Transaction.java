package de.sh99.vaultx.economy;

public enum Transaction
{
    FAILURE(0),
    PENDING(1),
    SUCCESS(2);

    private final int state;

    private Reason reason;

    Transaction(final  int state){
        this.state = state;
        this.reason = null;
    }

    public final int getState() {
        return state;
    }

    public Transaction setReason(Reason reason) {
        this.reason = reason;
        return this;
    }

    public Reason getReason() {
        return reason;
    }
}
