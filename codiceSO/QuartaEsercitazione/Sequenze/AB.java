package QuartaEsercitazione.Sequenze;

import java.util.concurrent.Semaphore;

public class AB {
    private static Semaphore semA = new Semaphore(1);
    private static Semaphore semB = new Semaphore(0);

    static class A extends Thread{
        public void run(){
            try {
                semA.acquire();
                System.out.print("A");
                semB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    static class B extends Thread{
        public void run(){
            try {
                semB.acquire();
                System.out.print("B ");
                semA.release();
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        while (true){
            new A().start();
            new B().start();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
