package Appelli.Banca;

import java.util.Random;

public class Cliente extends Thread{
    private Banca banca;
    private Random random=new Random();
    private int raggiungiSportello=10;
    private int tempoPrellievo=5;

    public Cliente(Banca banca){
        this.banca=banca;
    }

    @Override
    public void run() {
        try {
            while (true){
                    int sporello = random.nextInt(banca.sportelli.length);
                    Thread.sleep(raggiungiSportello);
                    if (banca.preleva(sporello)){
                        Thread.sleep(tempoPrellievo);
                    }
                    else{

                    }
            }
        } catch (InterruptedException e){

        }
    }
}
