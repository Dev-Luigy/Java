public class Fabrica1 implements IFabrica{
    public ICoisa fabricado(Character tipo){
        switch (tipo){
            case 'a':
                return new a1();
            case 'b':
                return new b1();
            case 'c':
                return new c1();
            case 'd':
                return new d1();
            default:
                return new a1();
        }

    }
}
