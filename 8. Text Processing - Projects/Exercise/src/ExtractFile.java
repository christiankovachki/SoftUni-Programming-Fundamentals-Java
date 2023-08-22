import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int indexOfDot = input.indexOf(".");
        int indexOfLastSlash = input.lastIndexOf("\\");

        String fileName = input.substring(indexOfLastSlash + 1, indexOfDot);
        String fileExtension = input.substring(indexOfDot + 1);

        System.out.printf("File name: %s\n", fileName);
        System.out.printf("File extension: %s\n", fileExtension);
    }
}