package net.serenitybdd.dojo.supermarket.model;

import java.util.Map;

/**
 * Created by 66515 on 12/10/2016.
 */
public class LineItem {
    private Product product;
    private Long quantity;

    public LineItem(Product product, Long quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public Long quantity() {
        return quantity;
    }

    public static LineItem create(Map.Entry<Product, Long> entry) {
        return new LineItem(entry.getKey(), entry.getValue());
    }

    public String name() {
        return product.name();
    }
}
