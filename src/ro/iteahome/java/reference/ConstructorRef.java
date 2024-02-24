package ro.iteahome.java.reference;

public class ConstructorRef {

    @FunctionalInterface
    interface CarFactory {
        Car createCar();
    }

    static class Car {

        public Car() {
            System.out.println("Car constructor");
        }
    }

    public static class CarFactoryImpl implements CarFactory {

        @Override
        public Car createCar() {
            return new Car();
        }
    }

    public static void main(String[] args) {
//        CarFactory bmwFactory = new CarFactoryImpl();
        CarFactory bmwFactory = Car::new;
        Car myCustomBmw = bmwFactory.createCar();
    }
}
