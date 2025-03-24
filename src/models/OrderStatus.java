package models;

public enum OrderStatus {
    ACTIVE,
    // active
    IN_PROGRESS,
    // inProgress
    COMPLETED,
    // complete
    CANCEL;
    //cancel

    OrderStatus() {

    }

    @Override
    public String toString() {
        switch (this) {
            case ACTIVE -> {
                return "Oprettet";
            }
            case IN_PROGRESS -> {
                return "Igangværende";
            }
            case COMPLETED -> {
                return "Færdiggjort";
            }
            case CANCEL -> {
                return "Annuleret";
            }
            default -> {
                return null;
            }
        }
    }
}

