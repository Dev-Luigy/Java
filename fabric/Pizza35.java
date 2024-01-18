
public class Pizza35 implements IFabricaPizza{

	public IPizza criarPizza(String tipo) {
		switch(tipo) {
		case ("calabresa"): return new Calabresa();
		case ("mussarela"): return new Mussarela();
		case ("quatroQueijos"): return new QuatroQueijos();
		case ("portuguesa"): return new Portuguesa();
		case ("especial"): return new Especial();
		default: return new Mussarela();
		
		}
	}
}
