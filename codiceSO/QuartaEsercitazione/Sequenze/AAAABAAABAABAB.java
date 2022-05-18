package QuartaEsercitazione.Sequenze;

import java.util.concurrent.Semaphore;

public class AAAABAAABAABAB {
    private static int count=5;
    private static Semaphore semA = new Semaphore(count);
    private static Semaphore semB = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    static class A extends Thread{
        @Override
        public void run() {
            try {
                semA.acquire();
                System.out.print("A");
                semB.release();
            }catch (InterruptedException e){

            }
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            try {
                mutex.acquire();
                semB.acquire(count);
                System.out.print("B ");
                count--;
                if (count>0) {
                    semA.release(count);
                    mutex.release();
                }
            }catch (InterruptedException e){
            }
        }
    }

    public static void main(String[] args) {
        while (true){
            new A().start();
            new B().start();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
