package Appelli.Pesca;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Persona extends Thread{
    private int minPesca=200, maxPesca=800, minRip=300, maxRip = 600;
    private int tipo;
    private Laghetto laghetto;

    public Persona(Laghetto laghetto, int tipo){
        this.tipo=tipo;
        this.laghetto=laghetto;
    }

    @Override
    public void run() {
        try {
            if (tipo==0){
                laghetto.inizia(tipo);
                System.out.println("Pescatore inizia");
                Thread.sleep(new Random().nextInt(maxPesca-minPesca)+minPesca);
                laghetto.finisci(tipo);
                System.out.println("Pescatore finisce "+laghetto.numPesci);
                TimeUnit.SECONDS.sleep(1);
            }else{
                laghetto.inizia(tipo);
                System.out.println("Rifornitore inizia");
                Thread.sleep(new Random().nextInt(maxRip-minRip)+minRip);
                laghetto.finisci(tipo);
                System.out.println("Rifornitore finisce "+laghetto.numPesci);
                TimeUnit.SECONDS.sleep(3);
            }
        }catch (InterruptedException e){
        }
    }
}
