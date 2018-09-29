package jbhembise.testauto.interaction;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    final String product;
    final Integer quantity;
    boolean filled;

    public Order(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void fill(Warehouse warehouse) {
        if (warehouse.hasInventory(product, quantity)) {
            warehouse.remove(product, quantity);
            this.filled = true;
        }
    }

    public boolean isFilled() {
        return this.filled;
    }
}
