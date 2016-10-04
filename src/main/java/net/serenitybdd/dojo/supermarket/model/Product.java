package net.serenitybdd.dojo.supermarket.model;

/**
 * Created by 66515 on 03/10/2016.
 */
public class Product {

    private String name;
    private Barcode barcode;

    public Product(String name, Barcode barcode) {
        this.name = name;
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name +
                '}';
    }

    public static ProductBuilder withName(String name) {
        return new ProductBuilder(name);
    }

    public String name() {
        return this.name;
    }

    public Barcode barcode() {
        return barcode;
    }

    public static class ProductBuilder {
        private String name;
        private Barcode barcode;

        public ProductBuilder(String name) {
            this.name = name;
        }

        public Product andWithBarcode(Barcode barcode) {
            this.barcode = barcode;
            return new Product(this.name, this.barcode);
        }

        public Product andWithBarcode(String barcodeValue) {
            this.barcode = new Barcode(barcodeValue);
            return new Product(this.name, this.barcode);
        }
    }
}
