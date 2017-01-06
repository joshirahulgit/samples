package org.sundot.objectrelations.association.onetozeromany;

/**
 * Created by rahul on 1/6/17.
 */
public class Main {
    public static void main(String[] args) {
        //Set data
        Customer customer = new Customer();
        customer.setName("Rahul");
        for (int i = 0; i < 5; i++) {
            Order order = customer.createNewOrder();
            order.setId(i);
        }

        //Read data
        System.out.println("Customer Info:");
        System.out.println(customer);
        System.out.println("Orders:");
        for (Order order : customer.getOrders()) {
            System.out.println(order);
        }
    }
}
