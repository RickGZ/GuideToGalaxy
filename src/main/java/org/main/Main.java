package org.main;

import org.interpreter.IInterpreter;
import org.interpreter.Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Get data using BufferedReader
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        IInterpreter interpreter = new Interpreter();

        // Read Data
        while (true) {
            String result = null;
            try {
                result = interpreter.handleInput(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(result);
        }
    }
}