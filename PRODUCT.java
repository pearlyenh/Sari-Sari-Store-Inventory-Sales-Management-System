package SARISARISTORE;
import java.util.Scanner;
import java.util.ArrayList;

public class PRODUCT {
    // attributes and feild are exactly the same
    Scanner scanner = new Scanner(System.in);
    static ArrayList<String> product = new ArrayList<>();
    static ArrayList<PRODUCT> products = new ArrayList<>();

    int productID;
    String barcode;
    String productName;
    String category;
    double unitCost; //total expense a company incurs to produce, store
    double sellingPrice;
    int quantity;
    int reorderLevel;


    PRODUCT(
        int productID,
        String barcode,
        String productName,
        String category,
        double unitCost,
        double sellingPrice,
        int quantity,
        int reorderLevel){
          
        this.productID = productID;
        this.barcode = barcode;
        this.productName = productName;
        this.category = category;
        this.unitCost = unitCost;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        }
    
    public int getProduct(){
        return productID;
    }
    public String getBarcode(){
        return barcode;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public double getUnitCost(){
        return unitCost;
    }
    public double getSellingPrice(){
        return sellingPrice;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getReorderLevel(){
        return reorderLevel;
    }

    // SETTERS
    public void setProductName(String newName){
        this.productName = newName;
    }
    public void setCategory(String newCategory){
        this.category = newCategory;
    }
    public void setSellingPrice(double newSellingPrice){
        this.sellingPrice = newSellingPrice;
    }
    public void setReorderLevel(int newReorderLevel){
        this.reorderLevel = newReorderLevel;
    }

    public void increaseStock(int amount){
        if (amount > 0){
            quantity = quantity + amount;
        }
        else {
            System.out.println("\nInvalid quantity.");
        }
    }
    public void decreaseStock(int amount){
        if (amount <= 0){
            System.out.println("\nInvalid quantity.");
        }
        else if (amount > quantity){
            System.out.println("\nInsufficient stock.");
        }
        else {
            quantity = quantity - amount;
        }
    }
    public Boolean isLowStock(){
        if (quantity <= reorderLevel){
            return true;
        }
        else {
            return false;
        }
    }
    public double calculateProfitPerUnit(){
        return sellingPrice - unitCost;
    }
    public boolean barcodeExists(String barcode){
        for(PRODUCT product : products){
            if(product.getBarcode().equals(barcode)){
                return true;
            }
        }
        return false;
    }

    public void addProduct(){
        while(true){
            System.out.println("\n========== ADD PRODUCT ==========");
            System.out.println("Please input BARCODE: ");
            barcode = scanner.nextLine().trim();

            if (barcode.isEmpty()){
                System.out.println("\nBarcode is required.");
                System.out.println("Fill up the barcode.");
            }
            else {
                break;
            }

            boolean exists = false;

                
            }
        }
    }

