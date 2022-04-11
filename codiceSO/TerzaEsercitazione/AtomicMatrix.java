package TerzaEsercitazione;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
//TODO VALORI SPORCHI CON LA MATRICE ATOMICA?!?
public class AtomicMatrix extends Thread {
    int n,m;
    int x; //Numero di volte che deve essere eseguito l'incremento/decremento
    int val=1; //Questa varibile decide la riga o la colonna che il thread deve ricevere
    static AtomicInteger[][] mat;
    boolean NoM; //Se true i thread modificano le righe se false le colonne

    public AtomicMatrix(int n, int m, int x,int val, boolean NoM){
        this.n=n;
        this.m=m;
        this.x=x;
        this.val=val;
        this.NoM=NoM;
    }
    public AtomicMatrix(int n, int m){
        this.m=m;
        this.n=n;
    }

    private void generaMatrice(){
        mat = new AtomicInteger[n][m];
    }

    private void inizializza(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                mat[i][j] = new AtomicInteger(0);
            }
        }
    }

    //Metodo eseguito dai threads
    public void run(){
        if (NoM){ //Se è un thread M (colonne) [addiziona]
            for (int i=0; i<m; i++){
                int x2=x;
                while (x2>0) {
                    mat[val][i].addAndGet(-1);
                    x2--;
                }
            }
        }
        else { //Se è un thread N (righe) [sottrae]
            for (int j=0; j<n; j++){
                int x2=x;
                while (x2>0) {
                    mat[j][val].addAndGet(1);
                    x2--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Dammi le righe della matrice: ");
        int n = scn.nextInt();
        Scanner scm = new Scanner(System.in);
        System.out.println("Dammi le colonne della matrice: ");
        int m = scm.nextInt();
        Scanner scx = new Scanner(System.in);
        System.out.println("Quante volte vuoi ripetere l'operazione?: ");
        int x = scx.nextInt();

        AtomicMatrix AM = new AtomicMatrix(n,m);
        AM.generaMatrice();
        AM.inizializza();

        Thread[] threadsm = new Thread[m];
        Thread[] threadsn = new Thread[n];

        for (int i=0; i<m; i++) {
            threadsm[i] = new AtomicMatrix(n, m, x, i,false);
        }
        for (int i=0; i<n; i++) {
            threadsn[i] = new AtomicMatrix(n, m, x, i,true);
        }
        for (int i=0; i<m; i++){
            threadsm[i].start();
        }
        for (int i=0; i<n; i++){
            threadsn[i].start();
        }
        System.out.println(Arrays.deepToString(mat));

    }
}
