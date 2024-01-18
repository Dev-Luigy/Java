import java.util.Scanner;

class Person {
    private int age = 0;
    private String nome = "";

    public Person(String nome, int age) {
        this.nome = nome;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "person:(" + getNome() + ":" + getAge() + ")";
    }
}

class Motorcycle {
    Person person = null;
    private int power = 0;
    private int time = 0;

    public Motorcycle(int power) {
        this.power = power;
    }

    public void buy(int time) {
        this.time = time;
    }

    public void drive(int time) {
        if (person.getAge() > 10) {
            System.out.println("fail: too old to drive");
            return;
        }
        if (this.time < time) {
            System.out.println("fail: time finished after " + this.time + " minutes");
            this.time = time;
            return;
        }
        this.time -= time;
    }

    public boolean enter(Person pessoa) {
        if (person == null) {
            person = pessoa;
            return true;
        }
        return false;
    }

    public void honk() {
        System.out.print("P");
        for (int i = 0; i < power; i++)
            System.out.print("e");
        System.out.println("m");
    }

    public Person leave() {
        if (person == null) {
            System.out.println("fail: empty motorcycle");
        }
        person = null;
        return person;
    }

    public Person getPerson() {
        return person;
    }

    public int getPower() {
        return power;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        if (person != null)
            return "power:" + getPower() + ", time:" + getTime() + ", " + person.toString();
        return "power:" + getPower() + ", time:" + getTime() + ", person:(empty)";
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Person pessoa = new Person("", 0);
        Motorcycle moto = new Motorcycle(1);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            System.out.println("$" + line);

            switch (ui[0]) {
                case "init":
                    moto = new Motorcycle(Integer.parseInt(ui[1]));
                    break;
                case "show":
                    System.out.println(moto);
                    break;
                case "enter":
                    pessoa = new Person(
                            ui[1],
                            Integer.parseInt(ui[2]));
                    moto.enter(pessoa);
                    break;
                case "leave":
                    moto.leave();
                    break;
                case "drive":
                    moto.drive(Integer.parseInt(ui[1]));
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }

    }
}