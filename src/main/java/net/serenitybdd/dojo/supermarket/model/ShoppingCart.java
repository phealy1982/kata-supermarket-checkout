package net.serenitybdd.dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShoppingCart {

    private final List<Product> items = new ArrayList<>();

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public ShoppingCartAdder add(Product product) {
        return new ShoppingCartAdder(this, product);
    }

    public int numberOfItems() {
        return items.size();
    }

    public int numberOf(Product product) {
        int productCounter=0;
        for(Product item : items){
            if(item.barcode().equals(product.barcode())) {
                productCounter++;
            }
        }
        return productCounter;
    }

    public List<Product> getDistinctItems() {
        return items.stream().distinct().collect(Collectors.toList());
    }

    public Map<Product, Long> getItemsWithCount() {
       return items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final Product product;

        public ShoppingCartAdder(ShoppingCart shoppingCart, Product product) {
            this.shoppingCart = shoppingCart;
            this.product = product;
        }

        public void times(int quantity) {
            for(int count = 0; count < quantity; count++) {
                shoppingCart.addItem(product);
            }
        }
    }
}
