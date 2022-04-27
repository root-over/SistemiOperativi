package QuartaEsercitazione.MatriceTS;

import java.util.Arrays;
import java.util.Scanner;

public class MatriceNoThSf extends matriceAbstract {
    private static int mat[][];

    public MatriceNoThSf(int[][] mat) {
        super(mat);
    }

    public static void main(String[] args) {
        System.out.println("Dammi le righe: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0; i<N; i++){
            Thread tr = new Thread();
        }
    }
}
