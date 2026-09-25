package SARISARISTORE;
import java.util.Scanner;
import java.util.ArrayList;

public class PRODUCT {
    // attributes and feild are exactly the same
    Scanner scanner = new Scanner(System.in);
    static ArrayList<PRODUCT> products = new ArrayList<>();

    //attributes
    int productID;
    static int nextProductID = 1;
    String barcode;
    String productName;
    String category;
    double unitCost; //hose much one item costs you to acquire
    double sellingPrice;
    int quantity; //current stock
    int initialQuantity;//original stock when purchased/added
    int reorderLevel;

    static double bundlePrice;

// OOP encapsulation - Constructor → gives the object its starting values
// Setter → changes/updates a value
//Getter → gets/reads a value
    PRODUCT(
        //Constructor - initialization (same name as the class and does not have to return a value not even void)
        String barcode,
        String productName,
        String category,
        double unitCost,
        double sellingPrice,
        int quantity,
        int reorderLevel){
          
        this.productID = nextProductID;
        nextProductID++;
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
    public void setUnitCost(double newUnitCost){
        this.unitCost = newUnitCost;
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
                    scanner.nextLine();

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
            "\n1. Food & Snacks" +
            "\n2. Drinks & Beverages" +
            "\n3. Personal & Beauty Care" +
            "\n4. Household Products" +
            "\n5. School & Office Supplies" +
            "\n6. Baby Products" +
            "\n7. Grocery & Cooking" +
            "\n8. Others");

            System.out.println("\nEnter Category Choice: ");
            System.out.println("//Bisaya Version");
            int cChoice = scanner.nextInt();

            switch (cChoice) {
                case 1:
                    category = "Food & Snacks";
                    break;
                case 2:
                    category = "Drinks & Beverages";
                    break;
                case 3:
                    category = "Personal & Beauty Care";
                    break;
                case 4:
                    category = "Household Products";
                    break;
                case 5:
                    category = "School & Office Supplies";
                    break;
                case 6:
                    category = "Baby Products";
                    break;
                case 7:
                    category = "Grocery & Cooking";
                    break;
                case 8:
                    category = "Others";
                    break;
                default:
                    if(cChoice > 8 || cChoice == 0){
                        System.out.println("\nInvalid category");
                        return;
                    }
                    break;
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
                    bundlePrice = scanner.nextDouble();

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
                    System.out.println("Bisaya version");
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
            double profitPerUnit = sellingPrice - unitCost;
            System.out.println("Profit per Unit: " + profitPerUnit);

            System.out.println("\nEnter low-stock level: ");
            reorderLevel = scanner.nextInt();

            if (reorderLevel < 0){
                System.out.println("\nInvalid low-stock level.");
                return;
            }

            PRODUCT newProduct = new PRODUCT(
                barcode,
                productName,
                category,
                unitCost,
                sellingPrice,
                initialQuantity,
                reorderLevel
            );
            //add newProduct to products ArrayList
            products.add(newProduct);

            System.out.println
            ("\n===== PRODUCT ADDED SUCCESSFULLY =====" + 
                "Product Name: " + productName +
                "Category: " + category +
                "Unit Cost: " + unitCost +
                "Selling Price: " + sellingPrice +
                "Quantity: " + initialQuantity +
                "Profit per Unit: " + profitPerUnit);
    }
    public void restockProduct() {

        System.out.println("\n===== RESTOCK PRODUCT =====");

        System.out.println("Enter product barcode:");
        String barcode = scanner.nextLine().trim();

        // FIND PRODUCT USING BARCODE
        PRODUCT foundProduct = null;

        for (PRODUCT product : products) {
            if (product.getBarcode().equals(barcode)) {
                foundProduct = product;
                break;
            }
        }

        // CHECK IF PRODUCT EXISTS
        if (foundProduct == null) {
            System.out.println("\nProduct not found.");
            System.out.println("Please add the product first.");
            return;
        }

        System.out.println("\n===== PRODUCT INFORMATION =====");

        System.out.println("Product Name: " + foundProduct.getProductName());
        System.out.println("Current Stock: " + foundProduct.getQuantity());
        System.out.println("Current Unit Cost: " + foundProduct.getUnitCost());
        System.out.println("Selling Price: " + foundProduct.getSellingPrice());


        System.out.println("\n===== NEW PURCHASE =====");

        System.out.println("Purchase Type:");
        System.out.println("[1] Bundle / Pack");
        System.out.println("[2] Individual");

        int purchaseType = scanner.nextInt();


        double newPurchaseCost = 0;
        int newQuantity = 0;
        double newUnitCost = 0;


        if (purchaseType == 1) {

            System.out.println("\nPrice per Bundle:");
            double bundlePrice = scanner.nextDouble();

            if (bundlePrice <= 0) {
                System.out.println("Invalid bundle price.");
                return;
            }


            System.out.println("How many bundles did you buy?");
            int numberOfBundles = scanner.nextInt();

            if (numberOfBundles <= 0) {
                System.out.println("Invalid number of bundles.");
                return;
            }


            System.out.println("How many pieces are in each bundle?");
            int piecesPerBundle = scanner.nextInt();

            if (piecesPerBundle <= 0) {
                System.out.println("Invalid number of pieces.");
                return;
            }


            // CALCULATE NEW PURCHASE COST
            newPurchaseCost = bundlePrice * numberOfBundles;

            // CALCULATE NEW QUANTITY
            newQuantity = numberOfBundles * piecesPerBundle;

            // CALCULATE NEW UNIT COST
            newUnitCost = newPurchaseCost / newQuantity;


        } else if (purchaseType == 2) {

            System.out.println("\nPrice per Piece:");
            double pricePerPiece = scanner.nextDouble();

            if (pricePerPiece <= 0) {
                System.out.println("Invalid price.");
                return;
            }


            System.out.println("How many pieces did you buy?");
            int quantityBought = scanner.nextInt();

            if (quantityBought <= 0) {
                System.out.println("Invalid quantity.");
                return;
            }


            // SET NEW QUANTITY
            newQuantity = quantityBought;

            // SET NEW UNIT COST
            newUnitCost = pricePerPiece;

            // CALCULATE NEW PURCHASE COST
            newPurchaseCost = pricePerPiece * quantityBought;


        } else {

            System.out.println("Invalid purchase type.");
            return;
        }


        // CALCULATE OLD INVENTORY COST
        double oldInventoryCost =
                foundProduct.getQuantity() * foundProduct.getUnitCost();


        // CALCULATE COMBINED INVENTORY COST
        double combinedInventoryCost = oldInventoryCost + newPurchaseCost;

        // CALCULATE COMBINED QUANTITY
        int combinedQuantity = foundProduct.getQuantity() + newQuantity;

        // CALCULATE UPDATED AVERAGE UNIT COST
        double updatedUnitCost = combinedInventoryCost / combinedQuantity;

        System.out.println("\n===== RESTOCK SUMMARY =====");
        System.out.println("Previous Stock: " + foundProduct.getQuantity());
        System.out.println("Bisaya version");
        System.out.println("New Stock Added: " + newQuantity);
        System.out.println("Updated Stock: " + combinedQuantity);

        System.out.println("Previous Unit Cost: " + foundProduct.getUnitCost());
        System.out.println("New Purchase Unit Cost: " + newUnitCost);
        System.out.println("Updated Average Unit Cost: " + updatedUnitCost);

        System.out.println("\nDo you want to continue with the restock?");
        System.out.println("//Bisaya version of this one...");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int confirmation = scanner.nextInt();

        if (confirmation == 1) {

            foundProduct.increaseStock(newQuantity);

            foundProduct.setUnitCost(updatedUnitCost);

            System.out.println("\nProduct restocked successfully.");
            System.out.println("//Bisaya version of this one...");
            System.out.println("Updated Stock: " + foundProduct.getQuantity());
            System.out.println("Updated Unit Cost: " + foundProduct.getUnitCost());

        } else {
            System.out.println("\nRestock cancelled.");
            System.out.println("//Bisaya version of this one...");
            System.out.println("//Bisaya version of this one...");
            System.out.println("//Bisaya version of this one...");
        }
    }
}

