package Appelli.Pesca;

import java.util.concurrent.Semaphore;

public class LaghettoSem extends Laghetto{

    private Semaphore mutex = new Semaphore(1);
    private Semaphore[] accesso = new Semaphore[2];

    public LaghettoSem(int minPesci, int maxPesci){
        super(minPesci, maxPesci);
        accesso[0]=new Semaphore(numPesci-minPesci);
        accesso[1]= new Semaphore(maxPesci-numPesci);
    }

    @Override
    public void inizia(int t) throws InterruptedException {
        accesso[t].acquire(t*9+1);

    }

    @Override
    public void finisci(int t) throws InterruptedException {

    }
}
