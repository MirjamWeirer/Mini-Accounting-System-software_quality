public class Supplier {

    private String supplierId;
    private String companyName;
    private String number;
    private String email;
    private int tradeLicenseNo;
    private int vatRn;

    //Constructors
    public Supplier(){}

    public Supplier(String supplierId, String companyName, String number, String email, int tradeLicenseNo, int vatRn) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.number = number;
        this.email = email;
        this.tradeLicenseNo = tradeLicenseNo;
        this.vatRn = vatRn;
    }

    //Getters
    public String getSupplierId() {
        return supplierId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getNumber()       {
        return number;
    }
    public String getEmail() {
        return email;
    }
    public int getTradeLicenseNo() {
        return tradeLicenseNo;
    }
    public int getVatRn() {
        return vatRn;
    }

    //Setters
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTradeLicenseNo(int tradeLicenseNo) {
        this.tradeLicenseNo = tradeLicenseNo;
    }
    public void setVatRn(int vatRn) {
        this.vatRn = vatRn;
    }

    //To String
    @Override
    public String toString() {
        return "Supplier { \n" +
                "supplierId = " + supplierId +
                "\n\tcompanyName = '" + companyName + '\'' +
                "\n\tnumber = '" + number + '\'' +
                "\n\tnemail = '" + email + '\'' +
                "\n\ttradeLicenseNo = " + tradeLicenseNo +
                "\n\tvatRn = " + vatRn +
                "\n}";
    }
}
