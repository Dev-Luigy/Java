public class Fabrica2 implements IFabrica{
    public ICoisa fabricado(Character tipo){
        switch (tipo){
            case 'a':
                return new a2();
            case 'b':
                return new b2();
            case 'c':
                return new c2();
            case 'd':
                return new d2();
            default:
                return new a2();
        }

    }
}
