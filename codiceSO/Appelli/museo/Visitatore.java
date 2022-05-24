package Appelli.museo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Visitatore extends Thread{
    private MuseoC museoC;
    private int minSA= 5, minSD=5, maxSA=10, maxSD=10;
    private Random random=new Random();

    public Visitatore(MuseoC museoC){
        this.museoC=museoC;
    }

    @Override
    public void run() {
        try {
            museoC.visitaSA();
            System.out.println("Visito la sala arceologica");
            TimeUnit.SECONDS.sleep(random.nextInt(maxSA-minSA)+maxSA);
            museoC.terminaVisitaSA();
            System.out.println("Lascio la sala archeologica");
            System.out.println("Visito la sala della dama");
            TimeUnit.SECONDS.sleep(random.nextInt(maxSD-minSD)+maxSD);
            museoC.terminaVisitaSD();
            System.out.println("Lascio la sala della dama");
        }catch (InterruptedException e){

        }
    }
}
