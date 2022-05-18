package Appelli.Funivia;

public abstract class Funivia {

    protected final int TuristaPiedi=0, TuristaBici=1;

    public abstract void pilotaStart() throws InterruptedException;

    public abstract void pilotaEnd() throws InterruptedException;

    public abstract void turistaSali(int t) throws InterruptedException;

    public abstract void turistaScendi() throws InterruptedException;

    public void test(int numTuristiPiedi, int numTuristiBici){
        for (int i=0; i<numTuristiPiedi; i++){
            new Thread(new Turista(this,TuristaPiedi)).start();
        }
        for (int i=0; i<numTuristiPiedi; i++){
            new Thread(new Turista(this,TuristaBici)).start();
        }
        Thread t = new Thread(new Pilota(this));
        t.start();
    }
}
