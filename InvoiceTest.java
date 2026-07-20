 class Invoice {
     private String partNumber;
     private String partDescription;
     private int Quantity;
     private float pricePerItem;
     public Invoice(String partNumber, String partDescription, int Quantity, float pricePerItem) {
         this.partNumber = partNumber;
         this.partDescription = partDescription;
         setQuantity(Quantity);
         setPricePerItem(pricePerItem);
     }
     public String getPartNumber() {
         return partNumber;
     }
     public String getPartDescription() {
         return partDescription;
     }
     public int getQuantity() {
         return Quantity;
     }
     public float getPricePerItem() {
         return pricePerItem;
     }
     public void setQuantity(int Quantity) {
         this.Quantity = Math.max(Quantity, 0);
     }
     public void setPricePerItem(float pricePerItem) {
         this.pricePerItem = Math.max(pricePerItem, 0);
     }
     public float getInvoiceAmount() {
         return Quantity * pricePerItem;
     }
 }

 public class InvoiceTest {
        public static void main(String[] args) {
            Invoice invoice = new Invoice("A123", "Hammer", 5, 1.50f);

            // Display the details of the invoice
            System.out.println("Part Number: " + invoice.getPartNumber());
            System.out.println("Part Description: " + invoice.getPartDescription());
            System.out.println("Quantity: " + invoice.getQuantity());
            System.out.println("Price per Item: $" + invoice.getPricePerItem());
            System.out.println("Invoice Amount: $" + invoice.getInvoiceAmount());

            // Test with negative quantity and price per item
            Invoice invalidInvoice = new Invoice("B456", "Nails", -3, -2.50f);
            System.out.println("\nTesting with invalid values:");
            System.out.println("Part Number: " + invalidInvoice.getPartNumber());
            System.out.println("Part Description: " + invalidInvoice.getPartDescription());
            System.out.println("Quantity (should be 0): " + invalidInvoice.getQuantity());
            System.out.println("Price per Item (should be 0): $" + invalidInvoice.getPricePerItem());
            System.out.println("Invoice Amount (should be 0): $" + invalidInvoice.getInvoiceAmount());

        }
 }


