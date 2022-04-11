package TerzaEsercitazione;

import java.util.Arrays;
import java.util.Scanner;

public class NonAtomicMatrix extends Thread{
        int n,m;
        int x; //Numero di volte che deve essere eseguito l'incremento/decremento
        int val=1; //Questa varibile decide la riga o la colonna che il thread deve ricevere
        static int [][]mat;
        boolean NoM; //Se false i thread modificano le righe se true le colonne

        public NonAtomicMatrix(int n, int m, int x,int val, boolean NoM){
            this.n=n;
            this.m=m;
            this.x=x;
            this.val=val;
            this.NoM=NoM;
        }
        public NonAtomicMatrix(int n, int m){
            this.m=m;
            this.n=n;
        }

        private int[][] generaMatrice(){
            mat = new int[n][m];
            return mat;
        }

        private void inizializza(int[][]mat){
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    mat[i][j]=0;
                }
            }
        }

        //Metodo eseguito dai threads
        public void run(){
            if (NoM){ //Se è un thread M (colonne) [addiziona]
                for (int i=0; i<m; i++){
                    int x2=x;
                    while (x2>0) {
                        mat[val][i] = mat[val][i] - 1;
                        x2--;
                    }
                }
            }
            else { //Se è un thread N (righe) [sottrae]
                for (int j=0; j<n; j++){
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

            NonAtomicMatrix AM = new NonAtomicMatrix(n,m);
            AM.inizializza(AM.generaMatrice());

            Thread[] threadsm = new Thread[m];
            Thread[] threadsn = new Thread[n];

            for (int i=0; i<m; i++) {
                threadsm[i] = new NonAtomicMatrix(n, m, x, i,false);
            }
            for (int j=0; j<n; j++) {
                threadsn[j] = new NonAtomicMatrix(n, m, x, j,true);
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
