package entities;


import java.util.UUID;

public class Bill {
    private final UUID id;
    private final UUID subscriberId;
    private double totalAmount;
    private boolean isPaid;

    public Bill(UUID subscriberId, double totalAmount) {
        this.id = UUID.randomUUID();
        this.subscriberId = subscriberId;
        this.totalAmount = totalAmount;
        this.isPaid = false;
    }

    public UUID getId() {
        return id;
    }

    public UUID getSubscriberId() {
        return subscriberId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        isPaid = true;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", subscriberId=" + subscriberId +
                ", totalAmount=" + totalAmount +
                ", isPaid=" + isPaid +
                '}';
    }
}
