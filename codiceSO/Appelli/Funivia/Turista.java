package Appelli.Funivia;

public class Turista implements Runnable{
    private Funivia funivia;
    private int tipo;

    public Turista(Funivia f, int t){
        funivia=f;
        tipo=t;
    }

    @Override
    public void run() {
        try {
            while (true){
                funivia.turistaSali(tipo);
                funivia.turistaScendi();
            }
        }catch (InterruptedException e){

        }
    }

    public int getTipo(){
        return tipo;
    }
    public void setTipo(int tipo){
        this.tipo=tipo;
    }
}
