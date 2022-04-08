package SecondaEsercitazione;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.lang.*;
import java.security.*;


public class CodeCracker extends Thread{
    private int da;
    private int a=0;
    //Prendo i file
    File encryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.encrypted");
    File decryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.decrypted");
    byte[] input = new byte[(int)encryptedFile.length()];
    StringBuilder codice = new StringBuilder();

    //FATTO
    public CodeCracker(int da, int a){
        this.da=da;
        this.a=a;
    }

    //prendo i byte del file
    private byte[] getByte () throws IOException {
        FileInputStream inputStream = new FileInputStream(encryptedFile);
        byte[] inputBytes = new byte[(int) encryptedFile.length()];
        inputStream.read(inputBytes);
        return inputBytes;

    }

    @Override //TODO 0 > 214748365 > 2147483647 >
    public void run() {
        while (da<=a) {
            int len;
            len = 16 - String.valueOf(da).length();
            codice.append("0".repeat(Math.max(0, len)));
            codice.append(da);
            da+=1;
            try {
                decripta(codice.toString(),getByte());
                codice= new StringBuilder();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    private void decripta(String codice, byte[] input){
        try{
            Key secretKey = new SecretKeySpec(codice.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] outputBytes = cipher.doFinal(input); //COME QUELLE CHIAVI PASSANO OLTRE QUESTO CODICE?
            System.out.println("\u001B[32m"+"LA CHIAVE E': "+ codice +"\u001B[0m");
            FileOutputStream outputStream = new FileOutputStream(decryptedFile);
            outputStream.write(outputBytes);
            System.exit(-1);
        }catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException ignored) {
        }
    }

//FATTO
    public static void main(String[] args){
        int M=10;
        int val = 214748364;
        int da=0;
        int a=214748364;
        Thread[] threads = new Thread[M];
        for (int i=0; i<M; i++){
            threads[i] = new CodeCracker(da,a);
            da=a+1;
            a+=val;
        }
        for (int i=0; i<M; i++){
            threads[i].start();
        }
    }
}
