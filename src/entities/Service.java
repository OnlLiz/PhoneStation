package entities;

import java.util.UUID;

public class Service {
    private final UUID id;
    private String name;
    private double cost;

    public Service(String name, double cost) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
