package system;

import entities.Bill;
import entities.Service;
import entities.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PhoneStationSystem {
    private final List<Subscriber> subscribers;
    private final List<Service> availableServices;
    private final List<Bill> bills;

    public PhoneStationSystem() {
        this.subscribers = new ArrayList<>();
        this.availableServices = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void addService(Service service) {
        availableServices.add(service);
    }

    public void generateBill(UUID subscriberId, double amount) {
        Subscriber subscriber = subscribers.stream()
                .filter(s -> s.getId().equals(subscriberId))
                .findFirst()
                .orElse(null);

        if (subscriber != null && !subscriber.isBlocked()) {
            Bill bill = new Bill(subscriber.getId(), amount);
            bills.add(bill);
        }
    }

    public List<Bill> getUnpaidBills() {
        return bills.stream().filter(bill -> !bill.isPaid()).collect(Collectors.toList());
    }

    public void blockNonPayers() {
        List<UUID> nonPayerIds = getUnpaidBills().stream()
                .map(Bill::getSubscriberId)
                .collect(Collectors.toList());

        subscribers.stream()
                .filter(subscriber -> nonPayerIds.contains(subscriber.getId()))
                .forEach(Subscriber::block);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public List<Service> getAvailableServices() {
        return availableServices;
    }
}
