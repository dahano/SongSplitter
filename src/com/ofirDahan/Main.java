package com.ofirDahan;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static com.ofirDahan.wordCleanse.articleRemover;


public class Main {


    public static void main(String[] args) throws Exception {

        Map<String, Integer> finalCount = new TreeMap<>();

        Path Stan_path = Paths.get("/Users/ofirdahan/Desktop", "textFile.txt");

        Charset charset = Charset.forName("UTF-8");

        try {
            List<String> lines = Files.readAllLines(Stan_path, charset);

            for (String line : lines) {
                
                finalCount = wordCleanse.wordMap(line, articleRemover());
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(finalCount);
    }

}






