package at.campus02.input;

import java.util.InputMismatchException;
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

    public int readInt(int low, int high){
        while (true){
            try {
                int number = scanner.nextInt();
                if (number >= low && number <= high) {
                    return number;
                } else {
                    System.out.println("Number must be in range " + low + " ... " + high);
                }
            }catch (InputMismatchException e){
                System.out.println("Number expected.");
            }
        }
    }
}
