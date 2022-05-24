package Appelli.Pesca;

import java.util.Random;

public abstract class Laghetto {
    protected int minPesci;
    protected int maxPesci;
    protected int numPesci;

    public Laghetto(int minPesci, int maxPesci){
        this.minPesci=minPesci;
        this.maxPesci=maxPesci;
        this.numPesci=new Random().nextInt(maxPesci-minPesci)+minPesci;
    }

    public abstract void inizia(int t)throws InterruptedException;
    public abstract void finisci(int t)throws InterruptedException;


}
