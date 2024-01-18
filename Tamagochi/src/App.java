import java.util.Scanner;

class Pet {
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds;
    private int age;
    private boolean alive;

    Pet(int energy, int hungry, int clean) {
        this.energy = energyMax = energy;
        this.hungry = hungryMax = hungry;
        this.clean = cleanMax = clean;
        diamonds = 0;
        age = 0;
        alive = true;
    }

    public String toString() {
        return "E:" + energy + "/" + energyMax + ", S:" + hungry + "/" + hungryMax + ", L:" + clean + "/" + cleanMax
                + ", D:" + diamonds + ", I:" + age;
    }

    private boolean testAlive() {
        if (alive)
            return alive;
        else {
            System.out.println("fail: pet esta morto");
            return alive;
        }
    }

    // actions
    public void eat() {
        if (!testAlive()) {
            return;
        } else {
            setEnergy(getEnergy() - 1);
            setHungry(getHungry() + 4);
            setClean(getClean() - 2);
            age++;
        }
    }

    public void play() {
        if (!testAlive()) {
            return;
        } else {
            setEnergy(getEnergy() - 2);
            setHungry(getHungry() - 1);
            setClean(getClean() - 3);
            diamonds++;
            age++;
        }
    }

    public void shower() {
        if (!testAlive()) {
            return;
        } else {
            setEnergy(getEnergy() - 3);
            setHungry(getHungry() - 1);
            setClean(getCleanMax());
            age += 2;
        }
    }

    public void sleep() {
        if (!testAlive()) {
            return;
        } else {
            int flag = 0;
            if (getEnergyMax() - getEnergy() <= 4) {
                System.out.println("fail: nao esta com sono");
                return;
            }
            while (getEnergy() < getEnergyMax()) {
                setEnergy(getEnergy() + 1);
                age++;
                flag++;
            }
            if (flag >= 1)
                setHungry(getHungry() - 1);
            if (flag == 0)
                System.out.println("fail: nao esta com sono");
        }
    }

    // getters
    public int getClean() {
        return clean;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergy() {
        return energy;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public int getAge() {
        return age;
    }

    public int getDiamonds() {
        return diamonds;
    }

    // setters;
    public void setEnergy(int energy) {
        if (energy >= energyMax)
            this.energy = energyMax;

        else if (energy <= 0) {
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            alive = false;
        }

        else
            this.energy = energy;
    }

    public void setClean(int clean) {
        if (clean >= cleanMax)
            this.clean = cleanMax;

        else if (clean <= 0) {
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            alive = false;
        }

        else
            this.clean = clean;
    }

    public void setHungry(int hungry) {
        if (hungry >= hungryMax)
            this.hungry = hungryMax;

        else if (hungry <= 0) {
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            alive = false;
        }

        else
            this.hungry = hungry;
    }

}

class Solver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("end"))
                break;
            else if (ui[0].equals("show"))
                System.out.println(pet.toString());
            else if (ui[0].equals("init")) {
                int energy = Integer.parseInt(ui[1]);
                int hungry = Integer.parseInt(ui[2]);
                int shower = Integer.parseInt(ui[3]);
                pet = new Pet(energy, hungry, shower);
            } else if (ui[0].equals("play"))
                pet.play();
            else if (ui[0].equals("eat"))
                pet.eat();
            else if (ui[0].equals("clean"))
                pet.shower();
            else if (ui[0].equals("sleep"))
                pet.sleep();
            else
                System.out.println("fail: comando invalido");
        }
    }
}