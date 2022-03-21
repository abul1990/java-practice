import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    public static void main(String[] args) {
        DeliveryData subject = new DeliveryData();
        subject.register(new Seller());
        subject.register(new Buyer());
        subject.locationChangeEvent("A");
        subject.locationChangeEvent("B");
    }

}

interface Observer {
    void update(String location);
}

interface Subject {
    void register(Observer observer);

    void unRegister(Observer observer);

    void notifyObservers();
}

class DeliveryData implements Subject {
    private List<Observer> observerList;
    private String location;

    public DeliveryData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(location);
        }
    }

    public void locationChangeEvent(String loc) {
        this.location = loc;
        notifyObservers();
    }
}

class Seller implements Observer {
    @Override
    public void update(String location) {
        System.out.println("Seller - location changed, current location: " + location);
    }
}

class Buyer implements Observer {
    @Override
    public void update(String location) {
        System.out.println("Buyer - location changed, current location: " + location);
    }
}