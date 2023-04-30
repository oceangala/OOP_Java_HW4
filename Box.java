import java.util.ArrayList;
import java.util.Comparator;


public class Box<T extends Fruit>{

    ArrayList<T> fruits;
    private final int boxId;
    public Box(ArrayList<T> fruits, int boxId) {
        this.fruits = fruits;
        this.boxId = boxId;
    }

    public int getBoxId() {
        return boxId;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public double getWeight(){
        double weight = 0.0;
        ArrayList<T> fruits = getFruits();
        if (fruits.size()>0)   weight = fruits.size()*fruits.get(0).getWeight();
        return weight;
    }


    @Override
    public String toString() {
        return String.format("Box № %d weights %.1f", boxId, getWeight());
    }

    public void addToBox(T fruit){
        if (getFruits().get(0).getClass() == fruit.getClass()){
            getFruits().add(fruit);
            System.out.println("Fruit is added");
        } else {
            System.out.println("It's a different fruit, it cannot be added");
        }

    }

    public boolean compare1(Box box){
        if (getWeight()==box.getWeight()) return true;
        else return false;
    }


}


