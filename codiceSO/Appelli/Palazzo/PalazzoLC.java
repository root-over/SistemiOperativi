package Appelli.Palazzo;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PalazzoLC extends Palazzo{
    private Lock l1 = new ReentrantLock();
    private Condition c1 = l1.newCondition();
    private Condition c2 = l1.newCondition();
    private Condition c3 = l1.newCondition();
    private boolean inizio=false;
    private Random random = new Random();


    @Override
    public void start(int t) throws InterruptedException {
        l1.lock();
        try {
            if (t == 0 && inizio) {
                c1.await();
            } else if (Npiani==0 && t==0) {
                inizio=true;
            } else if (t == 1) {
                c2.await();
            } else {
                c3.await();
            }
        }finally {
            l1.unlock();
        }
    }

    @Override
    public void end(int t) throws InterruptedException {
        l1.lock();
        try {
            if (t==0){
                c2.signal();
            }else if (t==1){
                c3.signal();
            }else {
                int verifica = random.nextInt(99) + 1;
                System.out.print(verifica);
                if (verifica<=80){
                    Npiani++;
                    System.out.println("LAVORO PIANO "+Npiani+ " TERMINATO");
                    c1.signal();
                } else if (verifica<=89) {
                    c2.signal();
                }else {
                    c1.signal();
                }
            }
        }finally {
            l1.unlock();
        }
    }
}
