
public class Exemplo {

	public static void main(String[] args) {
		Exemplo exemplo = new Exemplo();
		exemplo.inicia();

	}

	public void inicia() {
		IPizza pizza;
		IFabricaPizza minhaPizzariaPredileta = new Pizza35();
		pizza = minhaPizzariaPredileta.criarPizza("mussarela");
		System.out.println(pizza.lePreco());
	}
}
