package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Subscriber {
    private final UUID id;
    private String name;
    private String phoneNumber;
    private List<Service> subscribedServices;
    private boolean isBlocked;

    public Subscriber(String name, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.subscribedServices = new ArrayList<>();
        this.isBlocked = false;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Service> getSubscribedServices() {
        return subscribedServices;
    }

    public void addService(Service service) {
        subscribedServices.add(service);
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void block() {
        isBlocked = true;
    }

    public void unblock() {
        isBlocked = false;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", subscribedServices=" + subscribedServices +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
