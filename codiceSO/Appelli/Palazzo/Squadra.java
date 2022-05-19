package Appelli.Palazzo;

import java.util.concurrent.TimeUnit;

public class Squadra extends Thread{

    private Palazzo palazzo;
    private int tempo0 = 2;
    private int tempo1= 1;
    private int tempo2=3;
    private int tempoRiposo=3;
    private int TIPO;

    public Squadra(int TIPO, Palazzo palazzo){
        this.TIPO=TIPO;
        this.palazzo=palazzo;
    }

    @Override
    public void run() {
        try {
            while (palazzo.Npiani<50){
                palazzo.start(TIPO);
                if (TIPO==0){
                    TimeUnit.SECONDS.sleep(tempo0);
                    System.out.println("COSTUZIONE TERMINATA");
                }else if(TIPO==1){
                    TimeUnit.SECONDS.sleep(tempo1);
                    System.out.println("PULIZIA TERMINATA");
                }else {
                    TimeUnit.SECONDS.sleep(tempo2);
                    System.out.println("VERIFICA COMPLETATA");
                }
                palazzo.end(TIPO);
                TimeUnit.SECONDS.sleep(tempoRiposo);
            }
        }catch (InterruptedException e){
        }
    }
}
