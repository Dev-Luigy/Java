import java.util.Scanner;

class Car{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem
    
    public Car(){
        pass = 0;
        passMax = 2;
        gas = 0;
        gasMax = 100;
        km = 0;
    }
    public String toString(){
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
    public void enter(){
        if (pass < passMax) pass++;
        else System.out.println("fail: limite de pessoas atingido");
    }
    public void leave(){
        if (pass > 0) pass--;
        else System.out.println("fail: nao ha ninguem no carro");
    }
    public void fuel(int gas){
        this.gas = gas + this.gas > gasMax ? gasMax : gas + this.gas;
    }
    public void drive(int km){
        if (pass > 0){
            if (km > gas && gas > 0){
                System.out.println("fail: tanque vazio apos andar "+ gas +" km");
                this.km += gas;
                gas = 0;
            }else if (gas > 0){
                gas-=km;
                this.km += km;
            }else{
                System.out.println("fail: tanque vazio");
            }
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
};

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando in valido");
            }
        }
        scanner.close();
    }
}