package junit.sales;

// Class to hold sales data for a particular product.
class ProductSalesData {
    SalesRecord salesRecord;
    int totalSales;

    // Constructor to initialize the sales data.
    ProductSalesData(SalesRecord salesRecord) {
        this.salesRecord = salesRecord;
        this.totalSales = salesRecord.getProductPrice() * salesRecord.getItemsSold();
    }
}

class TopSalesFinder {
    private ProductSalesData[] productSalesDataArray; // Array to hold the sales data for each product.
    private int arraySize; // Variable to hold the size of the array

    // Constructor to initialize the top sales finder.
    public TopSalesFinder() {
        this.productSalesDataArray = new ProductSalesData[10]; // Initialize the array with a size of 10.
        this.arraySize = 0; // Initialize the size to 0.
    }

    public void registerSale(SalesRecord record) {
        // If the array is full, double its size.
        // Dynamic Array inspiration/help from https://www.geeksforgeeks.org/creating-a-dynamic-array-in-java/ .
        if (arraySize == productSalesDataArray.length) {
            ProductSalesData[] newProductSalesData = new ProductSalesData[productSalesDataArray.length * 2];
            System.arraycopy(productSalesDataArray, 0, newProductSalesData, 0, productSalesDataArray.length);
            productSalesDataArray = newProductSalesData;
        }
        // If the product is already in the array, update its total sales.
        for (int i = 0; i < arraySize; i++) {
            if (productSalesDataArray[i].salesRecord.getProductId().equals(record.getProductId())) {
                productSalesDataArray[i].totalSales += record.getProductPrice() * record.getItemsSold();
                return;
            }
        }
        // If the product is not in the array, add it to the array.
        productSalesDataArray[arraySize++] = new ProductSalesData(record);
    }

    public String[] findItemsSoldOver(int amount) {
        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            if (productSalesDataArray[i].totalSales > amount) {
                count++;
            }
        }
        // Create an array to hold the product IDs
        String[] result = new String[count];
        int index = 0;
        // Add the product IDs to the array.
        for (int i = 0; i < arraySize; i++) {
            if (productSalesDataArray[i].totalSales > amount) {
                result[index++] = productSalesDataArray[i].salesRecord.getProductId();
            }
        }
        return result;
    }

    public void removeSalesRecordsFor(String id) {
        int index = 0;
        // Remove the sales records for the product with the given ID.
        for (int i = 0; i < arraySize; i++) {
            if (!productSalesDataArray[i].salesRecord.getProductId().equals(id)) {
                productSalesDataArray[index++] = productSalesDataArray[i];
            }
        }
        arraySize = index;

        // If the array is less than 25% full, halve its size.
        if (arraySize < productSalesDataArray.length / 4) {
            ProductSalesData[] newProductSalesDataArray = new ProductSalesData[productSalesDataArray.length / 2];
            System.arraycopy(productSalesDataArray, 0, newProductSalesDataArray, 0, arraySize);
            productSalesDataArray = newProductSalesDataArray;
        }
    }

    public int getArrayLength() {
        return productSalesDataArray.length;
    }
}
