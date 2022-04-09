package TerzaEsercitazione;

import SecondaEsercitazione.CodeCracker;

import java.util.Arrays;
import java.util.Scanner;

public class AtomicMatrix extends Thread {
    int n,m;
    int x; //Numero di volte che deve essere eseguito l'incremento/decremento
    int val=1; //Questa varibile decide la riga o la colonna che il thread deve ricevere
    int [][]mat;
    boolean NoM; //Se true i thread modificano le righe se false le colonne

    public AtomicMatrix(int n, int m, int x,int val, boolean NoM){
        this.n=n;
        this.m=m;
        this.x=x;
        this.val=val;
        this.NoM=NoM;
    }
    public AtomicMatrix(){

    }

    private void generaMatrice(){
        mat = new int[n][m];
    }

    private int[][] inizializza(int[][]mat){
        for (int i=0; i<n-1; i++){
            for (int j=0; j<m-1; j++){
                mat[i][j]=0;
            }
        }
        return mat;
    }

    //Metodo eseguito dai threads
    public void run(){
        if (NoM){ //Se è un thread N (righe)
            for (int i=0; i<n; i++){
                int x2=x;
                while (x2>0) {
                    mat[val][i] = mat[val][i] - 1;
                    x2--;
                }
            }
        }
        else { //Se è un thread M (colonne)
            for (int j=0; j<m; j++){
                int x2=x;
                while (x2>0) {
                    mat[j][val] = mat[j][val] + 1;
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
        //TODO Attualmente ogni thread genera la sua matrice poichè la generazione avviene nel run
        //TODO capire come condividere la stessa matrice tra i thread
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
        System.out.print(Arrays.deepToString(mat));

    }
}