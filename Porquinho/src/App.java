import java.util.Scanner;

enum Coin {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.5, 3),
    M100(1.0, 4);

    public double value;
    public int volume;

    private Coin(double value, int volume) {
        this.value = value;
        this.volume = volume;
    }

    // getters
    public int getVolume() {
        return volume;
    }

    public String getDescription() {
        return "Coin: " + value;
    }

    public String toString() {
        return "Coin: " + getDescription() + " Volume: " + getVolume();
    }
}

class Item {
    private String description;
    private int volume;

    public Item(String description, int volume) {
        this.description = description;
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Descrição: " + getDescription() + " Volume:" + getVolume();
    }
}

class Pig {
    private String itens = "";
    private double value = 0;
    private int volume = 0;
    private int volumeMax;
    private boolean broken = false;

    // inicializa o volumeMax
    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public boolean isBroken() {
        if (!broken)
            return false;
        else {
            return true;
        }
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void addCoin(Coin moeda) {
        if (!isBroken()) {
            if (getVolume() + moeda.volume <= getVolumeMax()) {
                this.volume += moeda.volume;
                this.value += moeda.value;
            } else {
                System.out.println("nao cabe no porco");
            }
        }
    }

    public void addItem(Item item) {
        if (!isBroken()) {
            if (item.getVolume() + volume < volumeMax) {
                this.volume += item.getVolume();
                if (itens != "")
                    this.itens += ", " + item.getDescription();
                else
                    this.itens = item.getDescription();
            } else {
                System.out.println("nao cabe no porco");
            }
        }
    }

    public boolean breakPig() {
        broken = true;
        return broken;
    }

    public double getCoins() {
        if (isBroken()) {
            return value;
        } else {
            System.out.println("You must break the pig first");
            return 0;
        }
    }

    public String getItens() {
        if (isBroken()) {
            return itens;
        } else {
            System.out.println("You must break the pig first");
            return "";
        }
    }

    public String toString() {
        return "I:(" + itens + ") M:" + value + " V:" + volume + "/" + volumeMax + " EQ:" + broken;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pig pig = new Pig(0);

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);

            if (ui[0].equals("init")) {
                pig = new Pig(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addCoin")) {
                if (ui[1].equals("10")) {
                    pig.addCoin(Coin.M10);
                } else if (ui[1].equals("25")) {
                    pig.addCoin(Coin.M25);
                } else if (ui[1].equals("50")) {
                    pig.addCoin(Coin.M50);
                } else if (ui[1].equals("100")) {
                    pig.addCoin(Coin.M100);
                }
            } else if (ui[0].equals("addItem")) {
                pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
            } else if (ui[0].equals("getItens")) {
                System.out.println(pig.getItens());
            } else if (ui[0].equals("getCoins")) {// km
                System.out.println(pig.getCoins());
            } else if (ui[0].equals("show")) {// gas
                System.out.println(pig);
            } else if (ui[0].equals("breakPig")) {// gas
                pig.breakPig();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
