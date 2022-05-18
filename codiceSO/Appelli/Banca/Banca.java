package Appelli.Banca;

public abstract class Banca {
    public int[] sportelli = new int[30];

    public Banca(){
        for (int i=0; i<sportelli.length; i++){
            sportelli[i]=10000;
        }
    }

    public abstract int sportelloCarente() throws InterruptedException;

    public abstract void rifornisciSportello(int sportello) throws InterruptedException;

    public abstract boolean preleva (int sportello) throws InterruptedException;

}
