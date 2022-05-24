package Appelli.museo;

import java.util.concurrent.Semaphore;

public class MuseoSem extends MuseoC{
    private Semaphore semSA = new Semaphore(40,true);
    private Semaphore semSD = new Semaphore(5,true);
    private Semaphore mutex = new Semaphore(1);
    private int cont=0;


    @Override
    public void visitaSA() throws InterruptedException {
        semSA.acquire();
    }

    @Override
    public void terminaVisitaSA() throws InterruptedException {
        semSA.release();
    }

    @Override
    public void visitaSD() throws InterruptedException {
        semSD.acquire();
    }

    @Override
    public void terminaVisitaSD() throws InterruptedException {
        mutex.acquire();
        cont++;
        mutex.release();
        if (cont==5) {
            semSD.release(5);
            cont=0;
        }
    }

    public static void main(String[] args) {
        MuseoSem ms = new MuseoSem();
        for (int i=0; i<=100; i++){
            new Visitatore(ms).start();
        }
    }
}
