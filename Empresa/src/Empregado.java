public class Empregado {
    protected String name;
    protected int hour;
    protected double ValuePerHour;

    protected Empregado (String name, int hour, double ValuePerHour){
        this.name = name;
        this.hour = hour;
        this.ValuePerHour = ValuePerHour;
    }

    public double pagamento(){
        return hour * ValuePerHour;
    }

    public String toString() {
        return String.format("Nome: %s, horas trabalhadas: %d, valor por hora: %.2f", 
            name, hour, ValuePerHour);
    }
}
