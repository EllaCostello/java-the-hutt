package models;

public enum OrderStatus {
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    @Override
    public String toString() {
        switch (this) {
            case IN_PROGRESS -> {
                return "Igangværende";
            }
            case COMPLETED -> {
                return "Færdiggjort";
            }
            case CANCELLED -> {
                return "Annulleret";
            }
            default -> {
                return null;
            }
        }
    }
}


