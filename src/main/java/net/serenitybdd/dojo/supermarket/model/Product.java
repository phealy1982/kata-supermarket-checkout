package net.serenitybdd.dojo.supermarket.model;

/**
 * Created by 66515 on 03/10/2016.
 */
public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
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

    public static class ProductBuilder {
        private String name;
        private Double price;

        public ProductBuilder(String name) {
            this.name = name;
        }

        public Product andWithPrice(Double price) {
            this.price = price;

            return new Product(this.name, this.price);
        }
    }
}
