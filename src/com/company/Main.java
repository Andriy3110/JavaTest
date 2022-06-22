package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static final String name = "C:\\java\\testing1\\src\\com\\company\\objects";

    public static void main(String[] args) throws IOException, NoSuchElementException {

        FileReader reader = new FileReader(name);
        Scanner fileScanner = new Scanner(reader);
        ArrayList<Device> devices = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            Device device = new Device();
            Scanner lineScanner =new Scanner(line).useDelimiter("\\s*,\\s*");
            while (lineScanner.hasNext()){
                String token = lineScanner.next();
                if (device.serialNumber == 0){
                    device.serialNumber = Long.parseLong(token);
                }
                else if (device.brand == null){
                    device.brand = token;
                }
                else if (device.info == null){
                    device.info = token;
                }
                else if (device.price == 0){
                    device.price = Integer.parseInt(token);
                    devices.add(device);
                }
            }
            lineScanner.close();
        }

        System.out.println(devices);
        fileScanner.close();
        reader.close();
    }
}
