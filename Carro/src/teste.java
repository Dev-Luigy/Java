import java.util.Scanner;



class contando{
    public static int count = 0;
    public contando(){
        count++;
    }
    public void show(){
        System.out.println(count);
    }
}
public class teste{

    contando a = new contando();
    contando b = a;
    public static void main(String[] args) {
        contando a = new contando();
        contando b = a;
        b.show();
    }

}
