package at.campus02.input;

import at.campus02.model.Item;
import at.campus02.model.Purchase;
import at.campus02.model.Supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InputPurchase {

  private Scanner scanner;

  public InputPurchase(Scanner scanner) {
    this.scanner = scanner;
  }

  public  Purchase addPurchase(ArrayList< Purchase > list, ArrayList <Supplier> list2) throws Exception {
      System.out.println("*** Add Purchase ***");
      System.out.println("Enter Purchase Number: ");
      // purchase number
     scanner.nextLine();
      String number =scanner.nextLine();

      int purchaseNo = 0;
      //If input empty
      if (number.isEmpty() || number.equals(" ")) {
        throw new Exception("Unsuccessful. Cannot leave Purchase No field empty");
      }

      try {
        purchaseNo = Integer.parseInt(number);

        //Wrong Purchase Number format (should be a 3-digit number)
        if (purchaseNo > 999) {
          throw new Exception("Unsuccessful. Invalid purchase Number");
        }

        for (Purchase purchase: list) {
          if (purchase.getPurchaseNo() == purchaseNo) {
            throw new Exception("Unsuccessful. Purchase order already exists");
          }
        }
      }
      //If String given for Purchase Number
      catch (NumberFormatException e) {
        throw new Exception("Unsuccessful. Invalid purchase Number Format");
      }

      // purchase number

      // TRN no.
      System.out.println("Enter TRN No.");
      int trn_number =scanner.nextInt();
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

      int day =scanner.nextInt();
      if (day < 1 || day > 31) {
        throw new Exception("Unsuccessful. Invalid purchase date.");
      }

      System.out.println("Enter Month: ");
      int month =scanner.nextInt();
      if (month < 1 || month > 12) {
        throw new Exception("Unsuccessful. Invalid purchase date.");
      }

      System.out.println("Enter Year: ");
      int year =scanner.nextInt();
      if (year <= 0) {
        throw new Exception("Unsuccessful. Invalid purchase date.");
      }

      // Date
      Date purchaseDate = new Date(year, month, day);

      // Supplier ID
      System.out.println("Enter Supplier ID");
     scanner.nextLine();
      String id =scanner.nextLine();

      //If supplier field is empty
      if (id.isEmpty() || id.equals(" ")) {
        throw new Exception("Error: No supplier details displayed, the input field cannot be empty/blank");
      }
      int count = 0;
      for (Supplier supplier: list2) {
        count++;
        if ((supplier.getSupplierId().equals(id))) {
          break;
        }
      }

      // Item No
      System.out.println("Enter Item No : ");
      //sc.nextLine();
      String itemnotemp =scanner.nextLine();

      //If input empty
      if (itemnotemp.isEmpty() || itemnotemp.equals(" ")) {
        throw new Exception("Adding Purchase Unsuccessful. ItemNo field is empty");
      }
      int itemno = Integer.parseInt(itemnotemp);

      //Item quanitity
      System.out.println("Enter Item quantity : ");
      //sc.nextLine();
      String quanitity_temp =scanner.nextLine();

      if (quanitity_temp.isEmpty() || quanitity_temp.equals(" ")) {
        throw new Exception("Unsuccessful. Cannot leave Purchase No field empty");
      }

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
      String mode =scanner.nextLine();
      if (mode.isEmpty() || mode.equals(" ")) {
        throw new Exception("Unsuccessful. Mode of payment should be entered (Blank/Empty)");
      }
      if (!(mode.equals("card") || mode.equals("cheque") || mode.equals("bank transfer"))) {
        throw new Exception("Unsuccessful. Mode of payment should be either of card / cheque / bank transfer");
      }

      //Payment Due Date
      System.out.println("*Payment Due Date*");
      System.out.println("Enter Day: ");
      String temp_due_day =scanner.nextLine();
      if (temp_due_day.isEmpty() || temp_due_day.equals(" ")) {
        throw new Exception("Unsuccessful. Payment due date should be entered");
      }
      int due_day = Integer.parseInt(temp_due_day);

      System.out.println("Enter Month: ");
      String temp_due_month =scanner.nextLine();
      if (temp_due_month.isEmpty() || temp_due_month.equals(" ")) {
        throw new Exception("Unsuccessful. Payment due date should be entered");
      }
      int due_month = Integer.parseInt(temp_due_month);

      System.out.println("Enter Year: ");
      String temp_due_year =scanner.nextLine();
      if (temp_due_year.isEmpty() || temp_due_year.equals(" ")) {
        throw new Exception("Unsuccessful. Payment due date should be entered");
      }
      int due_year = Integer.parseInt(temp_due_year);

      Date purchaseDueDate = new Date(due_year, due_month, due_day);
      if (purchaseDueDate.before(purchaseDate)) {
        throw new Exception("Unsuccessful. Purchase date should be before the Payment Due Date.");
      }

      //total cost
      System.out.println("Enter total cost : ");
     scanner.nextLine();
      String tempcost =scanner.nextLine();

      if (tempcost.isEmpty() || tempcost.equals(" ")) {
        throw new Exception("Unsuccessful. Cost of the PO should be entered");
      }
      double cost = Double.parseDouble(tempcost);

      // vat amount
      double vat = 0.05 * cost;

      // newPurchase Creation
      Purchase newPurchase = new Purchase(purchaseNo, trn_number, purchaseDate, list2.get(count), itemObject, mode, purchaseDueDate, cost, vat);
      return newPurchase;
    }

  public  int removePurchase(ArrayList <Purchase> list) {
      System.out.println("*** Remove Purchase ***");
      System.out.println("Enter Purchase Number");

     scanner.nextLine();
      String number =scanner.nextLine();
      //If input empty
      if (number.isEmpty() || number.equals(" ")) {
        System.out.println("Unsuccessful. Cannot leave Purchase No field empty");
        return -1;
      }

      try {
        int temp = Integer.parseInt(number);

        //Wrong Purchase Number format (should be a 3-digit number
        if (temp > 999) {
          System.out.println("Unsuccessful. Invalid purchase Number");
          return -1;
        }

        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getPurchaseNo() == temp) {
            System.out.println("Purchase order No " + temp + " Deleted\n");
            return i;
          }
        }
        System.out.println("Unsuccessful. Purchase order does not exist");
      }
      //If String given for Purchase Number
      catch (NumberFormatException e) {
        System.out.println("Unsuccessful. Invalid purchase Number Format");
      }

      return -1;
    }

  public void viewPurchase(ArrayList < Purchase > list) {
      System.out.println("*** View Purchase ***");
      System.out.println("Enter Purchase Number");

     scanner.nextLine();
      String number =scanner.nextLine();

      //If input empty
      if (number.isEmpty() || number.equals(" ")) {
        System.out.println("Unsuccessful. Cannot leave Purchase No field empty");
        return;
      }

      try {
        int temp = Integer.parseInt(number);

        //Wrong Purchase Number format (should be a 3-digit number
        if (temp > 999) {
          System.out.println("Unsuccessful. Invalid purchase Number");
          return;
        }

        for (Purchase purchase: list) {
          if (purchase.getPurchaseNo() == temp) {
            System.out.println("Purchase Information");
            System.out.println(purchase.toString());
            return;
          }
        }
        System.out.println("Unsuccessful. Purchase order does not exist");
      }
      //If String given for Purchase Number
      catch (NumberFormatException e) {
        System.out.println("Unsuccessful. Invalid purchase Number Format");
      }
    } //Function View Purchase End
}
