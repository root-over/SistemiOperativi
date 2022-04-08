package SecondaEsercitazione;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.lang.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


public class CodeCracker extends Thread{
    private int da;
    private final int a;
    //Prendo i file
    File encryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.encrypted");
    File decryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.decrypted");

    StringBuilder codice = new StringBuilder();

    //FATTO
    public CodeCracker(int da, int a) throws FileNotFoundException {
        this.da=da;
        this.a=a;
    }

    //prendo i byte dei file
    private byte[] getByte () throws IOException {
        FileInputStream inputStream = new FileInputStream(encryptedFile);
        byte[] inputBytes = new byte[(int) encryptedFile.length()];
        inputStream.read(inputBytes);
        return inputBytes;
    }

    @Override //TODO 214748365 > 2147483647
    public void run() {
        System.out.println("Thread inizia da "+da+" a "+a);
        while (da<=a) {
            int len = 0;
            len = 16 - String.valueOf(da).length();
            codice.append("0".repeat(Math.max(0, len)));
            codice.append(da);
            da+=1;
            try {
                decripta(codice.toString(),getByte());
                codice= new StringBuilder("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void decripta(String codice, byte[]input) throws Exception {
        String key = codice;
        try{
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            System.out.println("PROVO LA CHIAVE "+key);
            byte[] outputBytes = cipher.doFinal(input);
            System.out.println("EDDAJE "+key);
            System.out.println("LA CHIAVE E': "+key);
            System.exit(-1);
            FileOutputStream outputStream = new FileOutputStream(decryptedFile);
            outputStream.write(outputBytes);
        }catch(NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex){
        }
    }
    //TODO RICORDA DI CHIUDERE I FILE QUANDO TROVA IL CODICE
//FATTO
    public static void main(String[] args) throws FileNotFoundException {
        int M=10;
        int da=0;
        int a=214748364;
        Thread[] threads = new Thread[M];
        for (int i=0; i<M; i++){
            threads[i] = new CodeCracker(da,a);
            da=a+1;
            a=a+a;
        }
        for (int i=0; i<M; i++){
            threads[i].start();
        }
    }
}
