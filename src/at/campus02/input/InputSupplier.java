package at.campus02.input;

import at.campus02.model.Supplier;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class InputSupplier { 
  
    private Scanner scanner;

    public InputSupplier(Scanner scanner) {
        this.scanner = scanner;
    }

    public Supplier addSupplier(Map<String, Supplier> suparr) throws Exception {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the supplier details: ");
      System.out.println("Enter supplierID: ");
      String suppID = sc.nextLine();

        if (suparr.containsKey(suppID)) {
          throw new IdDoesNotExistException("Error: Supplier not added, SupplierID already exists in the system.");
        }


      //If supplier field is empty
      if (suppID.isEmpty() || suppID.equals(" ")) {
        throw new Exception("Error: The Supplier ID input field cannot be empty/blank");

      }

      System.out.println("Enter companyName: ");

      String companyName = sc.nextLine();

      if (companyName.isEmpty() || companyName.equals(" ")) {
        throw new Exception("Error: Supplier not added, Company Name is left blank");

      }

      System.out.println("Enter Contact Number: ");
      String number = sc.nextLine();

      if (number.isEmpty() || number.equals(" ")) {
        throw new Exception("Error: Supplier not added, Contact Details Number is left blank.");

      }

      if (!(number.substring(0, 2).equals("05")) || number.length() != 10) {
        throw new Exception("Error: Supplier not added, Number needs to be of the format “05XXXXXXXX” where X are numbers.");
      }

      System.out.println("Enter email: ");
      String email = sc.nextLine();

      if (email.isEmpty() || email.equals(" ")) {
        throw new Exception("Error: Supplier not added, Email is left blank.");

      }

      int atCount = 0;
      int Atindex = 0;
      boolean domainfound = false;
      for (int i = 0; i < email.length(); i++) {
        if (email.charAt(i) == '@') {
          atCount++;
          Atindex = i;
          break;

        }

      }

      if (atCount != 1 || !(email.substring(Atindex, email.length()).contains(".")))
        throw new Exception("Error: Supplier not added, email isn’t in the correct format.The prefix appears to the left of the @ symbol. The domain appears to the right of the @ symbol");

      System.out.println("Enter tradeLicenseNo: ");
      int tradeLicenseNo = sc.nextInt();

      String texttradeLicense = Integer.toString(tradeLicenseNo);

      if (texttradeLicense.isEmpty() || texttradeLicense.equals(" ")) {
        throw new Exception("Error: Supplier not added, Trade Licence No. is left blank.");
      }

      int noOfDigitsTL = String.valueOf(tradeLicenseNo).length();

      if (noOfDigitsTL != 6)
        throw new Exception("Error: Supplier not added, Trade License number needs to be a 6 digit number.");

      System.out.println("Enter VAT registration Number: ");
      int vatRn = sc.nextInt();
      String vattext = Integer.toString(vatRn);

      if (vattext.isEmpty() || vattext.equals(" ")) {
        throw new Exception("Error: Supplier not added, VAT Registration Number is left blank");

      }

      int noOfDigitsVAT = String.valueOf(vatRn).length();

      if (noOfDigitsVAT != 7) {
        throw new Exception("Error: Supplier not added, VAT RN needs to be a 7 digit number.");
      }

      Supplier s1 = new Supplier(suppID, companyName, number, email, tradeLicenseNo, vatRn);
      suparr.put(s1.getSupplierId(),s1);
      System.out.println("Supplier added successfully");
      return s1;

    } //Function Add Supp End

    public Supplier deleteSupplier(Map <String, Supplier > suppliers) {
      System.out.println("*** delete Supplier ***");
      System.out.println("Enter Supplier ID");
      scanner.nextLine();
      String id = scanner.nextLine();

      //If supplier field is empty
      if (id.isEmpty() || id.equals(" ")) {
        System.out.println("Error: The input field cannot be empty/blank.");
        return null;
      } //if end
      
      if (suppliers.containsKey(id)){
        System.out.println("Supplier successfully deleted");
        return suppliers.get(id);
      }else{
        System.out.println("Supplier does not exist in the database so it isn't deleted.");
        return null;
      }

    } //Function Delete Supp End

    public void viewSupplier(Map <String, Supplier > list) {
      System.out.println("*** View Supplier ***");
      System.out.println("Enter Supplier ID");
      scanner.nextLine();
      String id = scanner.nextLine();

      //If supplier field is empty
      if (id.isEmpty() || id.equals(" ")) {
        System.out.println("Error: No supplier details displayed, the input field cannot be empty/blank");
        return;
      } //if end


        if (list.containsKey(id)) {
          System.out.println("Supplier Information");
          System.out.println(list.get(id));
        }else {
          System.out.println("Read/View Unsuccessful: Supplier ID does not exist");
        }
    } //ViewSupplier End
}