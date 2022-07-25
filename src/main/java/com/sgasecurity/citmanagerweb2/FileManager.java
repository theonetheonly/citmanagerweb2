package com.sgasecurity.citmanagerweb2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter out = null;


    public FileManager() {


    }

    public void writeToFile(String file_name, boolean writemode, String text) {
        try {

            String file_path = ""; // //""C:\\usersgmbatia\\desktop\\citweb\\"+file_name;
            System.out.println("************Writing to file*************");

            fw = new FileWriter(file_name, writemode);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(text);
            out.close();
        } catch (IOException e) {
                System.out.println("File error: "+ e.toString());
            //exception handling left as an exercise for the reader
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                //exception handling left as an exercise for the reader
                System.out.println("File error: "+ e.toString());

            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
                System.out.println("File error: "+ e.toString());
            }
        }
    }

}
