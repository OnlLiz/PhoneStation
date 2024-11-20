//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import entities.*;
import system.PhoneStationSystem;

public class Main {
    public static void main(String[] args) {
        PhoneStationSystem system = new PhoneStationSystem();

        // Додавання послуг
        Service internet = new Service("Internet", 50);
        Service tv = new Service("TV", 30);
        system.addService(internet);
        system.addService(tv);

        // Додавання абонентів
        Subscriber john = new Subscriber("John Doe", "123-456-7890");
        Subscriber jane = new Subscriber("Jane Smith", "987-654-3210");
        system.addSubscriber(john);
        system.addSubscriber(jane);

        // Абоненти підписуються на послуги
        john.addService(internet);
        jane.addService(tv);

        // Створення рахунків
        system.generateBill(john.getId(), 100);
        system.generateBill(jane.getId(), 80);

        // Блокування неплатників
        system.blockNonPayers();

        // Вивід інформації
        System.out.println("Subscribers: " + system.getSubscribers());
        System.out.println("Unpaid bills: " + system.getUnpaidBills());
    }
}