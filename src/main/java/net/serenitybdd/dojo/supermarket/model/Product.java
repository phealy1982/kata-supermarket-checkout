package net.serenitybdd.dojo.supermarket.model;

/**
 * Created by 66515 on 03/10/2016.
 */
public class Product {

    private String name;
    private Double price;
    private Barcode barcode;

    public Product(String name, Barcode barcode, Double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static ProductBuilder withName(String name) {
        return new ProductBuilder(name);
    }

    public String name() {
        return this.name;
    }

    public Double price() {
        return this.price;
    }

    public Barcode barcode() {
        return barcode;
    }

    public static class ProductBuilder {
        private String name;
        private Double price;
        private Barcode barcode;

        public ProductBuilder(String name) {
            this.name = name;
        }

        public Product andWithPrice(Double price) {
            this.price = price;

            return new Product(this.name, this.barcode, this.price);
        }

        public ProductBuilder andBarcode(Barcode barcode) {
            this.barcode = barcode;
            return this;
        }
    }
}
