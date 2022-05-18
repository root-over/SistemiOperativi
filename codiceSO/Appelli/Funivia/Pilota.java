package Appelli.Funivia;

import java.util.concurrent.TimeUnit;

public class Pilota implements Runnable{
    private Funivia funivia;
    private int tempoSalita=5;
    private int tempoDicescesa=2;

    public Pilota(Funivia f){
        funivia=f;
    }

    @Override
    public void run() {
        try {
            while (true){
                funivia.pilotaStart();
                attendi(tempoSalita);
                funivia.pilotaEnd();
                attendi(tempoDicescesa);
            }
        }catch (InterruptedException e){

        }
    }

    private void attendi (int tempo) throws InterruptedException{
        TimeUnit.MINUTES.sleep(tempo);
    }
}
