public class Terceirizado extends Empregado{
    protected double extraPays;
    
    public Terceirizado(String name, int hour, double ValuePerHour, double extraPays){
        super(name, hour, ValuePerHour);
        this.extraPays = extraPays;
    }

    public double pagamento(){
        return (hour * ValuePerHour) + extraPays * 1.1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Despesa adicional: " + extraPays;
    }
}
