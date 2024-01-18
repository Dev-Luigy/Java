import java.util.Scanner;

class Pencil {
    private Lead tip = null;
    private float thickness;
    
    public Pencil (float thickness){
        this.thickness = thickness;
    }

    public boolean hasGrafite (){
        if (tip != null) return true;
        return false;
    }

    public boolean insert (Lead grafite){
        if (grafite.thickness == thickness) {
            if(hasGrafite()) {
                System.out.println("fail: ja existe grafite");
                return false;
            }
            tip = grafite;
            return true;
        }
        System.out.println("fail: calibre incompatível");
        return false;
    }

    public Lead remove (){
        return this.tip = null;
    }

    public void writePage(){
        if (hasGrafite())
        {
            if (this.tip.size > 10){
                if (this.tip.size - tip.usagePerSheet() < 10)
                {
                    System.out.println("fail: folha incompleta");
                    this.tip.size = 10;
                    return;
                }
                this.tip.size -= tip.usagePerSheet();
                return;
            }
            System.out.println("warning: grafite com tamanho insuficiente para escrever");
            return;
        }
        
    }

    public String toString() {
        if (hasGrafite())
        return "calibre: " + thickness + ", " + tip.toString();
        return "calibre: " + thickness + ", grafite: null";
    }


}

class Lead {
    public String hardness = "";
    public int size = 0;
    public float thickness = 0;

    public Lead (float thickness,String hardness, int size){
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public int usagePerSheet(){
        switch (hardness){
            case "HB":
                return 1;
            case "2B":
                return 2;
            case "4B":
                return 4;
            case "6B":
                return 6;
            default:
                System.out.println("Tipo de grafite inexistente.");
                return 0;
        }
    }

    public String getHardness() {
        return hardness;
    }
    
    public int getSize() {
        return size;
    }

    public float getThickness() {
        return thickness;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "grafite: [" + getThickness() + ":" + getHardness() + ":" + getSize() + "]";
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pencil lapiseira = new Pencil(0);
        Lead grafite = new Lead(0, "", 0);

        while(true){
            String line = scanner.nextLine();
            String []ui = line.split(" ");

            System.out.println("$" + line);

            switch (ui[0]){
                case "init":
                    lapiseira = new Pencil(Float.parseFloat(ui[1]));
                    break;
                case "show":
                    System.out.println(lapiseira);
                    break;
                case "insert":
                    grafite = new Lead(
                    Float.parseFloat(ui[1]), 
                    ui[2], 
                    Integer.parseInt(ui[3]));
                    lapiseira.insert(grafite);
                    break;
                case "remove":
                    lapiseira.remove();
                    break;
                case "write":
                    lapiseira.writePage();
                    break;
                case "end":
                    System.exit(0);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }


    }
}
