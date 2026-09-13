package SARISARISTORE;
import java.util.Scanner;
import java.util.ArrayList;

public class PRODUCT {
    // attributes and feild are exactly the same
    Scanner scanner = new Scanner(System.in);
    static ArrayList<String> product = new ArrayList<>();
    static ArrayList<PRODUCT> products = new ArrayList<>();

    //attributes
    int productID;
    String barcode;
    String productName;
    String category;
    double unitCost; //hose much one item costs you to acquire
    double sellingPrice;
    int quantity; //current stock
    int initialQuantity;//original stock when purchased/added
    int reorderLevel;

// OOP encapsulation - Constructor → gives the object its starting values
// Setter → changes/updates a value
//Getter → gets/reads a value
    PRODUCT(
        //Constructor - initialization (same name as the class and does not have to return a value not even void)
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
    // GETTERS
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
    public void addProduct(){
            System.out.println("\n========== ADD PRODUCT ==========");
            System.out.println("Please input BARCODE: ");
            barcode = scanner.nextLine().trim();
            if (barcode.isEmpty()){
                System.out.println("\nBarcode is required.");
                return;
            }
            if (!barcode.matches("\\d+")){
                System.out.println("\nInvalid barcode. Numbers only.");
                return;
            }
            
            for (PRODUCT product : products) {
                if (product.getBarcode().equals(barcode)) {

                    System.out.println("\nProduct already exists.");
                    System.out.println("Product: " + product.getProductName());
                    System.out.println("Current Stock: " + product.getQuantity());

                    System.out.println("\nWould you like to restock this product?");
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    int ifrestock = scanner.nextInt();

                    switch (ifrestock) {
                        case 1:
                            System.out.println("\nEnter restock quantity:");
                            int amount = scanner.nextInt();
                            product.increaseStock(amount);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    return;
                }
            }

            System.out.println("\nEnter Product Name:");
            productName = scanner.nextLine().trim();
            if (productName.isEmpty()){
                System.out.println("\nProduct name is required.");
                return;
            }

            System.out.println
            ("\nCATEROGY OPTIONS: " +
            "\n1. Junk Food / Snacks" +
            "\n2. Canned Goods" +
            "\n3. Drinks / Beverages" +
            "\n4. Noodles / Soup" +
            "\n5. Personal Care" +
            "\n6. Beauty / Makeup" +
            "\n7. School Supplies" +
            "\n8. Household" +
            "\n9. Grocery / Cooking" +
            "\n10. Candies / Sweets" +
            "\n11. Baby Products" +
            "\n12. Others");

            System.out.println("\nEnter Category Choice: ");
            int cChoice = scanner.nextInt();

            if(cChoice > 12 || cChoice == 0){
                System.out.println("\nInvalid category");
                return;
            }

            System.out.println("\nPURCHASE TYPE: ");
            System.out.println("[1] Bundle / Pack");
            System.out.println("[2] Individual");
            int purchaseType = scanner.nextInt();

            double totalPurchaseCost = 0;
            double unitCost = 0;
            int totalPieces = 0;

            switch (purchaseType) {
                case 1:
                    System.out.println("\nPrice per Bundle");
                    double bundlePrice = scanner.nextDouble();

                    if(bundlePrice <= 0){
                        System.out.println("Price must be greater than 0");
                        return;
                    }
                    System.out.println("How many bundles did you buy?");
                    int numberOfBundles = scanner.nextInt();
                    if (numberOfBundles <= 0){
                        System.out.println("Number of bundles must be greater than 0.");
                        return;
                    }
                    System.out.println("How many pieces are in each bundle?");
                    int piecesPerBundle = scanner.nextInt();

                    if(piecesPerBundle <= 0){
                        System.out.println("Pieces must be greater than 0.");
                        return;
                    }
                    
                    // Calculation of Total purchase cost + total pieces + unit cost

                    totalPurchaseCost = bundlePrice * numberOfBundles;
                    totalPieces = piecesPerBundle * numberOfBundles;
                    unitCost = totalPurchaseCost / totalPieces;

                    initialQuantity = totalPieces;
                    break;
                case 2:
                    System.out.println("\nPrice per piece: ");
                    double pricePerPiece = scanner.nextDouble();

                    if (pricePerPiece <= 0){
                        System.out.println("Price must be greater than 0.");
                        return;
                    }
                    System.out.println("\nHow many pieces did you buy?");
                    int quantityBought = scanner.nextInt();

                    if(quantityBought <= 0){
                        System.out.println("\nQuantity must be greater than 0.");
                        return;
                    }

                    unitCost = pricePerPiece;
                    initialQuantity = quantityBought;
                    totalPieces = quantityBought;

                    totalPurchaseCost = pricePerPiece * quantityBought;
                    break;
                default:
                    System.out.println("Invalid purchase type.");
                    return;
            }
            System.out.println("\n===== PURCHASE SUMMARY =====");
            System.out.println("Total Purchase Cost: " + totalPurchaseCost);
            System.out.println("Total Pieces: " + initialQuantity);
            System.out.println("Unit Cost: " + unitCost);

            System.out.println("\nEnter selling price: ");
            sellingPrice = scanner.nextDouble();

            if (sellingPrice <= unitCost){
                System.out.println("\nERROR!");
                System.out.println("Selling price must be higher than unit cost.");
                System.out.println("Unit Cost: " + unitCost);
                System.out.println("Minimum selling price must be greater than unit cost.");
                return;
            }
    }
}

