package QuartaEsercitazione.Sequenze;

import java.util.concurrent.Semaphore;

public class AAB{
    private static Semaphore semA = new Semaphore(2);
    private static Semaphore semB = new Semaphore(0);

    static class A extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                    semA.acquire();
                    System.out.print("A");
                    semB.release();
                }
            }catch (InterruptedException e ){

            }
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                    semB.acquire(2);
                    System.out.print("B ");
                    semA.release(2);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){

            }
        }
    }

    public static void main(String[] args) {
        new A().start();
        new B().start();
    }
}
