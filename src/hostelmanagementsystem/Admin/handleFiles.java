/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostelmanagementsystem.Admin;

/**
 *
 * @author Daniel
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class handleFiles {
    String name;
    File file;
    
    handleFiles(String name) {
        this.name = name;
        file = new File(name);
    }
    
    Boolean writer(String[] line) {
        try {
            FileWriter writer = new FileWriter(file.getName(),true);
            String data = Arrays.toString(line);
            data = data.substring(1, data.length() - 1);
            data = data + "\n";
            try (BufferedWriter bWriter = new BufferedWriter(writer)) {
                bWriter.write(data);
                return true;
            }
        } catch(IOException e){
            return false;
        }
    }
    
    void cleaner() throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
        }
    }
    
    Object[] reader() throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        Object[] fileLines = bReader.lines().toArray();

        return fileLines;
    }
    
    Boolean finder(){
        return file.exists();
    }
    
    Boolean creator() throws IOException{
        return file.createNewFile();
    }
    
    int lineNumber() throws FileNotFoundException {
        int lineNum = 0;
        Scanner scan = new Scanner(file);
        
        while (scan.hasNextLine()) {
            scan.nextLine();
            lineNum++;
        }
        
        return lineNum;
    }

    boolean checkDuplicate(String roomID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

