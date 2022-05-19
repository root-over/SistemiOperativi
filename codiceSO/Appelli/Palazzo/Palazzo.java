package Appelli.Palazzo;

public abstract class Palazzo {

    protected int Npiani = 0;
    public abstract void start(int t) throws InterruptedException;
    public abstract void end(int t) throws InterruptedException;



}
