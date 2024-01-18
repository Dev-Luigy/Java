import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //vars
        Scanner sc      =   new Scanner(System.in);
        int [] array    =   new int [500];
        int addingnum   =   0;
        int [] ids      =   new int [500];
        int quant       =   0;
        
    
        //solve
        quant = sc.nextInt();
        for (int i = 0; i < quant ; i++){
            addingnum = sc.nextInt();
            array[addingnum] = 1;
            ids[i] = addingnum; 
        }

        for (int i = 0; i < sc.nextInt(); i++){
            addingnum = sc.next();
            if (array[addingnum]) {
                array[addingnum] = 0;
            }
        }

        for (int i = 0; i < quant; i++){
            System.out.println(array[ids[i]]);
        }
    }
}

