package bank;

public class Sem4_Sample2 {
    public static void main(String[] args) {
        DebetAccount<Entity> entityDebetAccount = new DebetAccount<>(
                new Entity("123", "Firma"), 1000000);

        CreditAccount<Person> personCreditAccount = new CreditAccount<>(
                new Person("John", "Smith", "555"), 20);

        Transaction<Account<?>> transaction1 = new Transaction<>(entityDebetAccount,
                personCreditAccount,20000);
        transaction1.execute();

        Transaction<Account<?>> transaction2 = new Transaction<>(entityDebetAccount,
                personCreditAccount, 30000);
        transaction2.execute();
    }
}

class Transaction<T extends Account<? extends PersonalData>>{
    private final T from;
    private final T to;
    private final double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void execute(){
        if (from.getAmount()>= amount){
            System.out.printf("Some money moved. Total: $%.2f\n", amount);
            System.out.printf("Account from #%s, $%.2f\nAccount to #%s, $%.2f\n",
                    from.getData(), from.getAmount(), to.getData(), to.getAmount());
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            System.out.println(from);
            System.out.println(to);
        }else {
            System.out.println("Operation cannot be executed.");
        }
    }
}


class CreditAccount<T extends PersonalData> extends Account<T>{

    public CreditAccount(T data, double amount) {
        super(data, amount);
    }
}

class DebetAccount<T extends PersonalData> extends Account<T>{

    public DebetAccount(T data, double amount) {
        super(data, amount);
    }
}

abstract class Account<T extends PersonalData>{
    private final T data;
    private double amount;

    public T getData() {
        return data;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account(T data, double amount) {
        this.data = data;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "data=" + data +
                ", amount=" + amount +
                '}';
    }
}


interface PersonalData{
    String getINN();
}



class Person implements PersonalData{

    private final String firstName;
    private final String lastName;
    private final String inn;

    public Person(String firstName, String lastName, String inn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return String.format("%s; %s %s", inn, firstName, lastName);
    }

    @Override
    public String getINN() {
        return inn;
    }
}

class Entity implements PersonalData{
    private final String inn;
    private final String name;

    public Entity(String inn, String name) {
        this.inn = inn;
        this.name = name;
    }

    @Override
    public String getINN() {
        return inn;
    }

    @Override
    public String toString() {
        return String.format("%s; %s", inn, name);
    }
}

