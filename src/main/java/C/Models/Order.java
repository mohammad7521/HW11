package C.Models;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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

    public Order(int id, Date orderDate, List<Product> products, boolean isPaid, boolean delivered, int customerID, double totalPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.products = products;
        this.isPaid = isPaid;
        this.delivered = delivered;
        CustomerID = customerID;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "\nid=" + id +
                "\norderDate=" + orderDate +
                "\nproducts=" + products +
                "\nisPaid=" + isPaid +
                "\ndelivered=" + delivered +
                "\nCustomerID=" + CustomerID +
                "\ntotalPrice=" + totalPrice+"\n";}
    }
