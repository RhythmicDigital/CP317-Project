package src.userInterfaceComponent;

import java.io.File;
import java.util.Scanner;

public class UserInterface {

    /**
     * Method for reading course file.
     * @return String[] of file names.
     */
    public static String[] getFileNamesFromUser() {
        Scanner scanner = new Scanner(System.in);

        String nameFileName;
        String courseFileName;

        do {
            System.out.println("Enter the name of the name file: ");
            nameFileName = scanner.nextLine();

            if (!isValidFilePath(nameFileName)) {
                System.out.println("Invalid file path. Please enter a valid path.");
            }
        } while (!isValidFilePath(nameFileName));

        do {
            System.out.println("Enter the name of the course file: ");
            courseFileName = scanner.nextLine();

            if (!isValidFilePath(courseFileName)) {
                System.out.println("Invalid file path. Please enter a valid path.");
            }
        } while (!isValidFilePath(courseFileName));

        // Close the scanner
        scanner.close();

        return new String[]{nameFileName, courseFileName};
    }

    /**
     * Helper method for reading course file.
     * @param fileName name of  file.
     * @return true if file path is valid.
     */
    private static boolean isValidFilePath(String fileName) {
        File file = new File("./input/" + fileName + ".txt");
        return file.exists() && file.isFile();
    }
}