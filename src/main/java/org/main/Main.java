package org.main;

import org.interpreter.IInterpreter;
import org.interpreter.Interpreter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Get data using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IInterpreter interpreter = new Interpreter();

        // Read Data
        while (true) {
            String result;
            try {
                result = interpreter.handleInput(reader.readLine());
            } catch (Exception e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }
}