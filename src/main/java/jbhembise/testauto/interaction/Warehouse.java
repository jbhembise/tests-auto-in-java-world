package jbhembise.testauto.interaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Warehouse {

    final Map<String, Integer> productsQuantities = new HashMap<>();

    public void add(String product, Integer quantity) {
        productsQuantities.put(product, quantity);
    }

    public boolean hasInventory(String product, Integer quantity) {
        return getInventory(product) >= quantity;
    }

    public void remove(String product, Integer quantity) {
        productsQuantities.put(product, productsQuantities.get(product) - quantity);
    }

    public Integer getInventory(String product) {
        return Optional.ofNullable(productsQuantities.get(product))
                .orElse(0);
    }
}
