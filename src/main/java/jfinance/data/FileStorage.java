package jfinance.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

/**
 * FileStorage - Interacting with the filesystem
 * 
 * Provide simple API for reading/writing strings to formatted text files
 */
@Component
public class FileStorage {

    // Path to storage directory inside the container
    protected static final String basePath = "/home/storage/";

    public List<String> readLinesFromFile(String path) throws Exception {
        List<String> lines = new ArrayList<>();

        // Open the file
        File file;
        try {
            file = new File(basePath + path);
            System.out.println("Opened file " + basePath + path);
        } catch (Exception e) {
            System.out.println("Failed to open file: " + e.getMessage());
            lines.add(e.getMessage());
            throw e;
        }

        // Read lines of file
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Failed to read file: " + e.getMessage());
            lines.add(e.getMessage());
            throw e;
        }

        System.out.println("Returning lines: " + lines.toString());
        return lines;
    }
    
    public List<String> readTransactionsFromAccount(String userId, String accountName) throws Exception {
        return this.readLinesFromFile(userId + "/" + accountName + ".log");
    }

    public List<String> listItemsInDir(String path) throws Exception {

        // Open the file
        File dir = new File(basePath + path);

        System.out.println("Opened dir " + basePath + path);

        // List files
        return Stream.of(dir.listFiles()).map((file) -> {
            System.out.println("Found file: " + file.getName());
            return file.getName();
        }).collect(Collectors.toList());
    }

    public boolean exists(String path) {
        try {
            new File(basePath + path);
            System.out.println("Opened file " + basePath + path);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to open file: " + e.getMessage());
            return false;
        }
    }

    public void createAccountFile(String userId, String accountName) throws IOException {
        File file = new File(basePath + userId + "/" + accountName + ".log");
        
        if (!file.createNewFile()) {
            System.out.println("Failed to create file " + basePath + userId + "/" + accountName + ".log");
        }
        
        System.out.println("Created file " + basePath + userId + "/" + accountName + ".log");
    }
    
    
    public void writeStringToFile(String userId, String accountName, String newLine) throws IOException {
        FileWriter writer = new FileWriter(basePath + userId + "/" + accountName + ".log", true);
        writer.write(newLine + "\n");
        writer.close();
    }
}