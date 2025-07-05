
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void saveArrayList(ArrayList<String> data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : data) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<String> loadArrayList(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return data;
    }

    public static void saveArray(String[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : array) {
                if (item != null) {
                    writer.write(item);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving array: " + e.getMessage());
        }
    }

    public static String[] loadArray(String filename, int maxSize) {
        String[] array = new String[maxSize];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < maxSize) {
                array[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("Error loading array: " + e.getMessage());
        }
        return array;
    }
}
