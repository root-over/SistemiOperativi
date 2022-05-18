package Appelli.Funivia;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class FuniviaSem extends Funivia{
    private Semaphore mutex = new Semaphore(1);

    private Semaphore permettiEntrataPiedi = new Semaphore(0);
    private Semaphore PermettiEntrataBici =new Semaphore(0);

    private Semaphore permettiPartenza = new Semaphore(0);

    private int numViaggi=-1;

    private int PostiOccupati=0;

    private Semaphore PermettiUsictaPiedi = new Semaphore(0);
    private Semaphore PermettiUscitaBici  = new Semaphore(0);

    private Semaphore PermettiStampa = new Semaphore(0);

    private Semaphore permettiFine = new Semaphore(0);

    private ArrayList<Integer> idTuristi = new ArrayList<>();

    @Override
    public void pilotaStart() throws InterruptedException {
        if (numViaggi%2==0){
            permettiEntrataPiedi.release(6);
        }
        else
            PermettiEntrataBici.release(3);

        permettiPartenza.acquire();
        PermettiStampa.acquire();
    }

    @Override
    public void pilotaEnd() throws InterruptedException {
        PermettiStampa.acquire();
        System.out.println("Viaggio numero "+(numViaggi));
        for (int i=0; i<idTuristi.size(); i++){
            System.out.println(idTuristi.get(i)+" ");
        }
        System.out.println("\n");
        if (numViaggi%2==0){
            PermettiUsictaPiedi.release(6);
        }
        else
            PermettiUscitaBici.release(3);
        permettiFine.acquire();
        idTuristi.clear();
    }

    @Override
    public void turistaSali(int t) throws InterruptedException {
        if (t==TuristaPiedi){
            permettiEntrataPiedi.acquire(6);
            mutex.acquire();
            PostiOccupati++;
            mutex.release();
            idTuristi.add((int) Thread.currentThread().getId());
            if (PostiOccupati==6)
                permettiPartenza.release();
        }
        else {
            PermettiEntrataBici.acquire();
            mutex.acquire();
            PostiOccupati++;
            idTuristi.add((int) Thread.currentThread().getId());
            if (PostiOccupati==3)
                permettiPartenza.release();
            mutex.release();
        }
    }

    @Override
    public void turistaScendi() throws InterruptedException {

    }

    public void turistaScendi(int t) throws InterruptedException {
        if (t==TuristaPiedi){
            PermettiUsictaPiedi.acquire();
            mutex.acquire();
            PostiOccupati--;
            if (PostiOccupati==0){
                permettiFine.release();
            }
            mutex.release();

        }
        else{
            PermettiUscitaBici.acquire();
            mutex.acquire();
            PostiOccupati--;
            if (PostiOccupati==0){
                permettiFine.release();
            }
            mutex.release();
        }
    }

    public static void main(String[] args) {

    }
}
