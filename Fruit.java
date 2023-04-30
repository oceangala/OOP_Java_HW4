public abstract class Fruit {
    private final double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Apple extends Fruit{

    private final double weight = 1.0;
    private String color;
    public Apple(String color) {
        super(1.0);
        this.color = color;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Apple is %s.", color);
    }
}

class Orange extends Fruit{
    private final double weight = 1.5;
    private String color;

    @Override
    public double getWeight() {
        return weight;
    }

    public Orange(String color) {
        super(1.5);
        this.color = color;

    }
    @Override
    public String toString() {
        return String.format("Orange is %s.", color);
    }
}