package domain.products;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import util.*;

/**
 *
 * @author Niels
 */
public class Order {

    private Date orderDate;
    private double shippingCharge;
    private int orderID;
    private int status;
    private Address shippingAddress;
    private Set<Item> itemSet;
    private final double TAX = 1.2;

    public Order(Date orderDate, double shippingCharge, int orderID, int status, Address shippingAddress) {
        this.orderDate = orderDate;
        this.shippingCharge = shippingCharge;
        this.orderID = orderID;
        this.status = status;
        this.shippingAddress = shippingAddress;
        itemSet = new HashSet<>();
    }

    public void addItem(Product product, int quantity) {
        itemSet.add(new Item(product, quantity, product.getPrice() * quantity));
    }

    public void removeItem(Item item) {
        itemSet.remove(item);
    }

    public void changeQuantity(Item item, int quantity) {
        for(Item i : itemSet) {
            if (item.equals(i)) {
                item.changeQuantity(quantity);
            }
        }
    }

    public void returnItems() {

    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public double getFinalPrice() {
        double sum = 0;
        for(Item item : itemSet) {
            sum += item.getSumPrice();
        }
        return sum * TAX;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
