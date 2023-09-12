public class VendingMachine {
    private String[][] products; //Multi-dimensional array to store product information

    public VendingMachine(int rows, int cols) {
        products = new String[rows][cols];
    }

    // Method to add a product to the vending machine
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
        vendingMachine.addProduct(1, 1, "Candy");
        vendingMachine.addProduct(2, 2, "Water");

        System.out.println("Vending Machine Contents:");
        vendingMachine.display();

        System.out.println("\nGetting products from the vending machine:");
        System.out.println("1. " + vendingMachine.getProduct(0, 0));
        System.out.println("2. " + vendingMachine.getProduct(0, 1));
        System.out.println("3. " + vendingMachine.getProduct(1, 1));
        System.out.println("4. " + vendingMachine.getProduct(2, 2));

        System.out.println("\nUpdated Vending Machine Contents:");
        vendingMachine.display();
    }
}
