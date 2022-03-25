package at.campus02.input;

import at.campus02.model.Item;
import at.campus02.model.Purchase;
import at.campus02.model.Supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class InputPurchase {

    private Scanner scanner;
    private Map<Integer, Purchase> purchases;
    private Map<String, Supplier> supplier;
    private final InputHelper inputHelper;

    public InputPurchase(Scanner scanner, Map<Integer, Purchase> purchases, Map<String, Supplier> supplier) {
        this.scanner = scanner;
        this.purchases = purchases;
        this.supplier = supplier;
        inputHelper = new InputHelper(scanner);
    }

    public Purchase addPurchase() throws Exception {
        System.out.println("*** Add Purchase ***");
        System.out.println("Enter Purchase Number: ");
        // purchase number
        scanner.nextLine();

        String number = inputHelper.readString();
        int purchaseNo = 0;

        try {
            purchaseNo = Integer.parseInt(number);

            //Wrong Purchase Number format (should be a 3-digit number)
            if (purchaseNo > 999) {
                throw new Exception("Unsuccessful. Invalid purchase Number");
            }

            if (purchases.containsKey(purchaseNo)) {
                throw new Exception("Unsuccessful. Purchase order already exists");
            }
        }
        //If String given for Purchase Number
        catch (NumberFormatException e) {
            throw new Exception("Unsuccessful. Invalid purchase Number Format");
        }

        // purchase number

        // TRN no.
        System.out.println("Enter TRN No.");
        int trn_number = scanner.nextInt();
        if (trn_number <= 0) {
            throw new Exception("Unsuccessful. TRN number should be of 6 digits");
        }
        int noOfDigits = String.valueOf(trn_number).length();
        if (noOfDigits != 6) {
            throw new Exception("Unsuccessful. TRN number should be of 6 digits");
        }
        //TRN no.

        // Date
        System.out.println("*Date*");
        System.out.println("Enter Day: ");
        Date currentDate = new Date();

        int day = scanner.nextInt();
        if (day < 1 || day > 31) {
            throw new Exception("Unsuccessful. Invalid purchase date.");
        }

        System.out.println("Enter Month: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            throw new Exception("Unsuccessful. Invalid purchase date.");
        }

        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        if (year <= 0) {
            throw new Exception("Unsuccessful. Invalid purchase date.");
        }

        // Date
        Date purchaseDate = new Date(year, month, day);

        // Supplier ID
        System.out.println("Enter Supplier ID");
        scanner.nextLine();
        String id = inputHelper.readString();

        // Item No
        System.out.println("Enter Item No : ");
        //sc.nextLine();
        String itemnotemp = inputHelper.readString();

        int itemno = Integer.parseInt(itemnotemp);

        //Item quanitity
        System.out.println("Enter Item quantity : ");
        //sc.nextLine();
        String quanitity_temp = inputHelper.readString();

        int quantity;
        try {
            quantity = Integer.parseInt(quanitity_temp);
        }
        //If String given for Purchase Number
        catch (NumberFormatException e) {
            throw new Exception("Unsuccessful. Quantity should be in numerical values");
        }

        // Item object creation
        Item itemObject = new Item(itemno, quantity);

        //Payment mode
        System.out.println("Enter Payment Mode : ");
        String mode =inputHelper.readString();
        if (!(mode.equals("card") || mode.equals("cheque") || mode.equals("bank transfer"))) {
            throw new Exception("Unsuccessful. Mode of payment should be either of card / cheque / bank transfer");
        }

        //Payment Due Date
        System.out.println("*Payment Due Date*");
        System.out.println("Enter Day: ");
        String temp_due_day = inputHelper.readString();
        int due_day = Integer.parseInt(temp_due_day);

        System.out.println("Enter Month: ");
        String temp_due_month = inputHelper.readString();
        int due_month = Integer.parseInt(temp_due_month);

        System.out.println("Enter Year: ");
        String temp_due_year = inputHelper.readString();
        int due_year = Integer.parseInt(temp_due_year);

        Date purchaseDueDate = new Date(due_year, due_month, due_day);
        if (purchaseDueDate.before(purchaseDate)) {
            throw new Exception("Unsuccessful. Purchase date should be before the Payment Due Date.");
        }

        //total cost
        System.out.println("Enter total cost : ");
        scanner.nextLine();
        String tempcost = inputHelper.readString();
        double cost = Double.parseDouble(tempcost);

        // vat amount
        double vat = 0.05 * cost;

        // newPurchase Creation
        Purchase newPurchase = new Purchase(purchaseNo, trn_number, purchaseDate,
                supplier.get(id), itemObject, mode, purchaseDueDate, cost, vat);
        return newPurchase;
    }

    public Purchase removePurchase() {
        System.out.println("*** Remove Purchase ***");
        System.out.println("Enter Purchase Number");

        scanner.nextLine();
        String number = inputHelper.readString();

        try {
            int purchasesNo = Integer.parseInt(number);

            //Wrong Purchase Number format (should be a 3-digit number
            if (purchasesNo > 999) {
                System.out.println("Unsuccessful. Invalid purchase Number");
                return null;
            }

            if (purchases.containsKey(purchasesNo)) {
                System.out.println("Purchases successfully deleted");
                return purchases.get(purchasesNo);
            } else {
                System.out.println("Unsuccessful. Purchase order does not exist");
                return null;
            }
        }
        //If String given for Purchase Number
        catch (NumberFormatException e) {
            System.out.println("Unsuccessful. Invalid purchase Number Format");
        }
        return null;
    }

    public void viewPurchase() {
        System.out.println("*** View Purchase ***");
        System.out.println("Enter Purchase Number");

        scanner.nextLine();
        String number = inputHelper.readString();

        try {
            int temp = Integer.parseInt(number);

            //Wrong Purchase Number format (should be a 3-digit number
            if (temp > 999) {
                System.out.println("Unsuccessful. Invalid purchase Number");
                return;
            }


            if (purchases.containsKey(temp)) {
                System.out.println("Purchase Information");
                System.out.println(purchases.get(temp));
            } else {
                System.out.println("Unsuccessful. Purchase order does not exist");
            }
        }
        //If String given for Purchase Number
        catch (NumberFormatException e) {
            System.out.println("Unsuccessful. Invalid purchase Number Format");
        }
    } //Function View Purchase End
}
