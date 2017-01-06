package org.sundot.objectrelations.association.onetozeromany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 1/6/17.
 */
public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public List<Order> getOrders() {
        return orders;
    }

    private List<Order> orders;

    public Customer() {
        this.orders = new ArrayList<Order>();
    }

    public Order createNewOrder() {
        Order order = new Order(this);
        orders.add(order);
        return order;
    }

    @Override
    public String toString() {
        return "Customer:{ name: " + getName() + " }";
    }
}
