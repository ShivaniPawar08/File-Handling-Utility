import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== FILE HANDLING UTILITY ====");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify (Append) File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeFile(sc);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // Write content to file
    public static void writeFile(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME);
            System.out.println("Enter text to write into file:");
            String data = sc.nextLine();

            fw.write(data);
            fw.close();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error while writing file!");
        }
    }

    // Read file contents
    public static void readFile() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }

            Scanner fileReader = new Scanner(file);

            System.out.println("\n---- FILE CONTENT ----");

            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }

            fileReader.close();

        } catch (Exception e) {
            System.out.println("Error while reading file!");
        }
    }

    // Append / modify file
    public static void modifyFile(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);

            System.out.println("Enter text to append:");
            String data = sc.nextLine();

            fw.write("\n" + data);
            fw.close();

            System.out.println("File modified successfully!");

        } catch (IOException e) {
            System.out.println("Error while modifying file!");
        }
    }
}
