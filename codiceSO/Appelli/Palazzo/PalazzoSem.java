package Appelli.Palazzo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PalazzoSem extends Palazzo {
    private Semaphore mutex = new Semaphore(0);
    private Semaphore squadra1 = new Semaphore(1);
    private Semaphore squadra2 = new Semaphore(0);
    private Semaphore squadra3 = new Semaphore(0);
    private Random random = new Random();



    @Override
    public void start(int t) throws InterruptedException {
        if (t==0){
            squadra1.acquire();
        } else if (t==1) {
            squadra2.acquire();
        }else {
            squadra3.acquire();
        }
    }

    @Override
    public void end(int t) throws InterruptedException {
        if (t==0){
            squadra2.release();
        } else if (t==1) {
            squadra3.release();
        }else {
            int verifica = random.nextInt(99) + 1;
            System.out.print(verifica);
            if (verifica<=80){
                mutex.acquire();
                Npiani++;
                System.out.println("LAVORO PIANO "+Npiani+ " TERMINATO");
                mutex.release();
                squadra1.release();
            } else if (verifica<=89) {
                squadra2.release();
            }else {
                squadra1.release();
            }
        }

    }

    public static void main(String[] args) {
        PalazzoSem ps = new PalazzoSem();
        Squadra S1 = new Squadra(0,ps);
        Squadra S2= new Squadra(1,ps);
        Squadra S3 = new Squadra(2,ps);
        S1.start();
        S2.start();
        S3.start();


    }
}
