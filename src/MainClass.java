import at.campus02.input.InputPurchase;
import at.campus02.input.InputSupplier;
import at.campus02.model.Item;
import at.campus02.model.Purchase;
import at.campus02.model.Supplier;

import java.util.*;

public class MainClass {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws Exception {

    Item i1 = new Item(100, 20);

    Supplier supp1 = new Supplier("supp1001", "ABC", "0502375262", "abc@abc.com", 1001, 789);
    Purchase pur1 = new Purchase(100, 2000, new Date(2002, 12, 23), supp1, i1, "Card", new Date(2013, 26, 12), 800.36, 10.45);

    ArrayList <Supplier> supplierList = new ArrayList < > ();
    ArrayList < Purchase > purchaseList = new ArrayList < > ();
    purchaseList.add(pur1);
    supplierList.add(supp1);

    System.out.println("""
		       Accounting System
		       *******Purchases*******
		       \t1. Add purchase
		       \t2. Remove purchase
		       \t3. View purchase
		       *******at.campus02.model.Supplier*******
		       \t4. Add at.campus02.model.Supplier
		       \t5. Remove at.campus02.model.Supplier
		       \t6. View at.campus02.model.Supplier
		       """);
      int choice = 0;

      InputPurchase inputPurchase = new InputPurchase(sc);
      InputSupplier inputSupplier = new InputSupplier(sc);

      while (true) {
        System.out.println("Enter your choice (1-6)");
        choice = sc.nextInt();
        switch (choice) {
        case 1: {
          try {
            Purchase p1 = inputPurchase.addPurchase(purchaseList, supplierList);
            purchaseList.add(p1); // remove if not call by refernece
            break;
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        }

        case 2:
          int index = inputPurchase.removePurchase(purchaseList);
          if (index == -1) {
            //System.out.println("Unsuccessful. at.campus02.model.Purchase order does not exist");
          } else purchaseList.remove(index);
          break;

        case 3:
          inputPurchase.viewPurchase(purchaseList);
          break;

        case 4: {
          try {
            Supplier s1 = inputSupplier.addSupplier(supplierList);
            supplierList.add(s1); // remove if not call by refernece
            break;
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        }

        case 5:
          int pos = inputSupplier.deleteSupplier(supplierList);
          if (pos == -1) {
            System.out.println("at.campus02.model.Supplier Doesnt Exist");
          } else supplierList.remove(pos);
          break;

        case 6:
          inputSupplier.viewSupplier(supplierList);
          break;

        default:
          System.out.println("Enter a value between 1-6");
          System.exit(0);
        } //switch end
      } //while end
    } //Main End

} //Class end
