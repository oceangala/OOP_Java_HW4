import java.util.ArrayList;
import java.util.Random;


/**
 * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 * подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 * g. Не забываем про метод добавления фрукта в коробку.
 */


public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<Box> boxes = new ArrayList<>(6);

        for (int i = 0; i < 6; i++) {
            boxes.add(new Box<>(fillTheBox(), i));

        }

        for (Box box :boxes){
            System.out.println(box);
        }


        for (int i = 1; i < boxes.size(); i++) {
            System.out.println(boxes.get(0).compare1(boxes.get(i)));
        }



        Apple myApple = new Apple("purple");
        Orange myOrange = new Orange("blue");

        boxes.get(0).addToBox(myApple);
        System.out.println(boxes.get(0));

        boxes.get(0).addToBox(myOrange);
        System.out.println(boxes.get(0));


        reFill(boxes.get(0), boxes.get(1));
        reFill(boxes.get(1), boxes.get(2));
        reFill(boxes.get(2), boxes.get(3));


    }

    public static ArrayList<? extends Fruit> fillTheBox(){
        Random rand = new Random();
        boolean type = rand.nextBoolean();
        int quant = rand.nextInt(6,13);

        if(type) {
            ArrayList<Apple> fruits = new ArrayList<>(quant);
            for (int i = 0; i < quant; i++) {
                int clr = rand.nextInt(1, 4);
                fruits.add(new Apple(clr == 1 ? "red" : clr == 2 ? "yellow" : "green"));
            }
            System.out.println(fruits);
            return fruits;
        } else {
            ArrayList<Orange> fruits = new ArrayList<>(quant);
            for (int i = 0; i < quant; i++) {
                int clr = rand.nextInt(1, 3);
                fruits.add(new Orange(clr == 1 ? "orange" :  "yellow"));
            }
            System.out.println(fruits);
            return  fruits;
        }
    }

    public static void reFill (Box b1, Box b2){
            if(b1.getFruits().get(0).getClass()==b2.getFruits().get(0).getClass()){
                b2.getFruits().addAll(b1.getFruits());
                b1.getFruits().clear();
                System.out.println("Success");
                System.out.println(b1);
                System.out.println(b2);
            } else {
                System.out.println("Nope");
                System.out.println(b1);
                System.out.println(b2);
            }
    }

}