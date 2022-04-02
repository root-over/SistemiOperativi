package PrimaEsercitazione.stampe;

public class StampanteT extends Thread{
    private int da;
    private int a;

    public StampanteT(int da, int a){
        this.a=a;
        this.da=da;
    }

    public void run(){
        for (int i=da; i<=a; i++){
            System.out.println(i+" ");
        }
        System.out.println();
    }
}
