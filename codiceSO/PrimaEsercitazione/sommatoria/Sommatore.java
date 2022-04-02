package PrimaEsercitazione.sommatoria;

public class Sommatore extends Thread{
    private int da;
    private int a;
    private int somma;

    public Sommatore(int da, int a){
        this.da=da;
        this.a=a;
    }

    public void run() {
        somma=0;
        for (int i=da; i<=a; i++){
            somma+=1;
        }
    }
    public int getSomma() throws InterruptedException{
        this.join();
        return somma;
    }
}
