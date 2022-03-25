import java.util.ArrayList;
import java.util.Date;

public class Purchase {

    private int purchaseNo;
    private int trnNo;
    private Date date;
    private Supplier supp;
    private Item it;
    private String paymentMode;
    private Date paymentDueDate;
    private double totalCost;
    private double vatAmt;

    //Constructor
    public Purchase(int purchaseNo, int trnNo, Date date, Supplier supp, Item it, String paymentMode, Date paymentDueDate, double totalCost, double vatAmt) {
        this.purchaseNo = purchaseNo;
        this.trnNo = trnNo;
        this.date = date;
        this.supp = supp;
        this.it = it;
        this.paymentMode = paymentMode;
        this.paymentDueDate = paymentDueDate;
        this.totalCost = totalCost;
        this.vatAmt = vatAmt;
    }

    //Getters
    public int getPurchaseNo() {
        return purchaseNo;
    }
    public int getTrnNo() {
        return trnNo;
    }
    public Date getDate() {
        return date;
    }
    public Supplier getSupp() {
        return supp;
    }
    public Item getIt() {
        return it;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
    public Date getPaymentDueDate() {
        return paymentDueDate;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public double getVatAmt() {
        return vatAmt;
    }

    //Setters
    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }
    public void setTrnNo(int trnNo) {
        this.trnNo = trnNo;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setSupp(Supplier supp) {
        this.supp = supp;
    }
    public void setIt(Item it) {
        this.it = it;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void setVatAmt(double vatAmt) {
        this.vatAmt = vatAmt;
    }

    //To String
    @Override
    public String toString() {
        return "Purchase { \n" +
                "purchaseNo = " + purchaseNo +
                "\n\ttrnNo = " + trnNo +
                "\n\tdate = " + date +
                "\n\tsupp = " + supp +
                "\n\tit = " + it +
                "\n\tpaymentMode = '" + paymentMode + '\'' +
                "\n\tpaymentDueDate = " + paymentDueDate +
                "\n\ttotalCost = " + totalCost +
                "\n\tvatAmt = " + vatAmt +
                "\n}";
    }


}
