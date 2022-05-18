package QuartaEsercitazione.Sequenze;

import java.util.concurrent.Semaphore;

public class AABB {
    private static Semaphore semA = new Semaphore(2);
    private static Semaphore semB = new Semaphore(0);

    static class A extends Thread{
        @Override
        public void run() {
            try {
                semA.acquire();
                System.out.print("A");
                semA.acquire();
                System.out.print("A ");
                semB.release(2);
            } catch (InterruptedException e) {
            }

        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            try {
                semB.acquire();
                System.out.print("B");
                semB.acquire();
                System.out.print("B ");
                semA.release(2);
            }catch (InterruptedException e){
            }
        }
    }

    public static void main(String[] args) {
        while (true){
            new A().start();
            new B().start();
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
            }
        }
    }
}
