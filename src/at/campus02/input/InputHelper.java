package at.campus02.input;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(){
       while (true) {
           String line = scanner.nextLine();
           if (!line.isBlank()){
               return line;
           }else {
               System.out.println("Field cannot be empty. Please try again.");
           }
       }
    }
}
