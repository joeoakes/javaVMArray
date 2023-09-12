public class VendingMachine {
    //Define the class level Multi-dimensional array to store product information
    private String[][] products;

    //Constructor Method accepts the number of rows and COls
    public VendingMachine(int rows, int cols) {
        // Declare and dimension a Multi-dimensional array of Strings
        products = new String[rows][cols];
    }

    // Method to add a product to the vending machine element/slot in the Multi-dimensional array
    public void addProduct(int row, int col, String productName) {
        if (row >= 0 && row < products.length && col >= 0 && col < products[0].length) {
            products[row][col] = productName;
        } else {
            System.out.println("Invalid location for adding a product.");
        }
    }

    // Method to retrieve a product from the vending machine
    public String getProduct(int row, int col) {
        if (row >= 0 && row < products.length && col >= 0 && col < products[0].length) {
            String product = products[row][col];
            if (product != null) {
                products[row][col] = null; // Remove the product from the vending machine
                return product;
            } else {
                return "Empty slot";
            }
        } else {
            return "Invalid location";
        }
    }

    // Method to display the current state of the vending machine
    //Uses the nested for loop construct used to work with a Multi-dimensional array
    public void display() {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products[0].length; j++) {
                String product = products[i][j];
                if (product == null) {
                    System.out.print("[Empty] ");
                } else {
                    System.out.print("[" + product + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // constructs a 3 rows X 3 cols 
        VendingMachine vendingMachine = new VendingMachine(3, 3);  

        //vendingmachine is the object, addProduct() is the method
        vendingMachine.addProduct(0, 0, "Soda");  //row 0, col 0 
        vendingMachine.addProduct(0, 1, "Chips");
        vendingMachine.addProduct(0, 2, "Gum");
        vendingMachine.addProduct(1, 0, "poprocks");
        vendingMachine.addProduct(1, 1, "Candy");
        vendingMachine.addProduct(1, 2, "Gum");
        vendingMachine.addProduct(2, 2, "Water");

        //Show all the contents in the Vending Machine
        System.out.println("Vending Machine Contents:");
        vendingMachine.display();

        //Get some of the products from the Vending Machine product inventory
        System.out.println("\nGetting products from the vending machine:");
        System.out.println("1. " + vendingMachine.getProduct(0, 0));  //Get the soda
        System.out.println("2. " + vendingMachine.getProduct(0, 1));  //get the chips
        System.out.println("3. " + vendingMachine.getProduct(1, 1));  //get the candy
        System.out.println("4. " + vendingMachine.getProduct(2, 2));  //get the water

        //Display what is left in inventory
        System.out.println("\nUpdated Vending Machine Contents:");
        vendingMachine.display();  //Only Gum and poprocks are the products left
    }
}
