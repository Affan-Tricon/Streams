package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Logger lo = LoggerFactory.getLogger(Main.class);

        lo.info("This is an INFO message.");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("target/classes/sourceFile.txt");
        } catch (FileNotFoundException e) {
            lo.error("This is an ERROR message, Source file not found.");
        }

        BufferedInputStream bis = new BufferedInputStream(fis);

        int i;

        while ((i = bis.read()) != -1) {
            System.out.print((char) i);
        }

        bis.close();
        fis.close();

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("target/classes/targetFile.txt");
        }
        catch (FileNotFoundException e){
            lo.error("This is an ERROR message, Target file not found.");
        }
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String str = "This is write test.";
        byte b[] = str.getBytes();

        bos.write(b);

        bos.close();
        fos.close();
    }
}