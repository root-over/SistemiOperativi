package Appelli.Banca;

public class Agente extends Thread{
    private Banca banca;
    private int raggiungiSportello=10;
    private int riempiSportello= 50;

    public Agente(Banca banca){
        this.banca=banca;
    }

    @Override
    public void run() {
        try {
            while (true){
                int sportello = banca.sportelloCarente();
                Thread.sleep(raggiungiSportello);
                banca.rifornisciSportello(sportello);
                Thread.sleep(riempiSportello);
            }
        }catch (InterruptedException e){

        }
    }
}
