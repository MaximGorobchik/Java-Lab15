import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        File dir = new File(".");
        if (!dir.isDirectory()) {
            System.out.println(dir.getName() + " is not a directory");
            System.exit(0);
        }
        File[] files = dir.listFiles();
        if (files.length == 0) {
            System.out.println("The directory is empty");
            System.exit(0);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: "); String fileName = input.nextLine();
        File fileToDelete = new File(fileName);
        if (!fileToDelete.exists()) {
            System.out.println("file does not exist");
            System.exit(0);
        }
        System.out.print("Are you sure you want to delete " + fileToDelete + "? (Y/N): ");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            boolean success = fileToDelete.delete();
            if (success) {
                String msg = fileToDelete + " was deleted";
                System.out.println(msg);
            } else {
                String msg = "Failed to delete " + fileToDelete;
                System.out.println(msg);
            }
        } else {
            String msg = fileToDelete + " was not deleted";
            System.out.println(msg);
        }
    }
}
