package C.Models;

import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private Date orderDate;
    private List<Product> products;
    private boolean isPaid;
    private boolean delivered;
    private int CustomerID;
    private double totalPrice;

    public Order(int id, List<Product> products, boolean isPaid, boolean delivered, int customerID) {
        this.id = id;
        this.products = products;
        this.isPaid = isPaid;
        this.delivered = delivered;
        CustomerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
