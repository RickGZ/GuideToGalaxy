package org.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Get data using BufferedReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Read Data
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print result
        System.out.println(input);
    }
}