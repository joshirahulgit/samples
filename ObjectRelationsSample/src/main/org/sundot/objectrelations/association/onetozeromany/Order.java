package org.sundot.objectrelations.association.onetozeromany;

/**
 * Created by rahul on 1/6/17.
 */
public class Order {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order:{ id: " + getId() + " }";
    }
}
