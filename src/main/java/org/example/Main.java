package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main( String[] args ) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Missing input file");
        }

        Simulator simulator = new Simulator(new Table(5,5), new Robot());

        run(args, simulator);

    }

    static void run(String[] args, Simulator simulator) {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String command;

            while ((command = br.readLine()) != null) {
                String output = simulator.execute(command);
                if (output != null) {
                    System.out.println(output);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
