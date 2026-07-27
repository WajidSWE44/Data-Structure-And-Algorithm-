package StrategyDesignPattern.Task1;
interface TransportStrategy {
    void travel(String destination);
}
class Car implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Car.");
    }
}
class Bike implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Bike.");
    }
}
class Bus implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Bus.");
    }
}
class TravelContext {
    private TransportStrategy strategy;

    public TravelContext(TransportStrategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(TransportStrategy strategy) {
        this.strategy = strategy;
    }
    public void goTo(String destination) {
        strategy.travel(destination);
    }
}
public class TransportStrategyMain {
    public static void main(String[] args) {
        TravelContext travel = new TravelContext(new Car());
        travel.goTo("University");

        travel.setStrategy(new Bike());
        travel.goTo("Library");

        travel.setStrategy(new Bus());
        travel.goTo("Downtown");
    }
}

