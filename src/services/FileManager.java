package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void save(String filename, String data) {

        try {

            FileWriter writer = new FileWriter(filename);

            writer.write(data);

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static String load(String filename) {

        try {

            File file = new File(filename);

            if (!file.exists()) {
                return "";
            }

            Scanner scanner = new Scanner(file);

            StringBuilder builder = new StringBuilder();

            while (scanner.hasNextLine()) {

                builder.append(scanner.nextLine());

            }

            scanner.close();

            return builder.toString();

        }

        catch (IOException e) {

            e.printStackTrace();

        }

        return "";
    }

}