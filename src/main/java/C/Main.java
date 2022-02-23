package C;

import C.Models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static List<Product> productList=new ArrayList<>();
    public static List<Category> categoryList=new ArrayList<>();
    public static List<Customer> customerList=new ArrayList<>();
    public static List<Order>orders=new ArrayList<>();

    static void addCategories(){

        Category fruits=new Category("fruits");
        Category vegetables=new Category("vegetables");
        Category snacks=new Category("snacks");
        categoryList.add(fruits);
        categoryList.add(vegetables);
        categoryList.add(snacks);

    }

    static void addCustomer(){
        customerList.add(new Customer("andreas","jackson","mad75","664",1));
        customerList.add(new Customer("chris","wood","mad7235","45",2));
        customerList.add(new Customer("dina","davidson","mad74","63",3));
    }

    static void addProducts(){
        productList.add(new Product("apple",1,categoryList.get(0),20,1500));
        productList.add(new Product("carrot",2,categoryList.get(0),14,1600));
        productList.add(new Product("lemon",3,categoryList.get(0),30,1400));
        productList.add(new Product("lettuce",4,categoryList.get(1),30,800));
        productList.add(new Product("broccoli",5,categoryList.get(1),14,900));
        productList.add(new Product("chips",6,categoryList.get(2),100,1200));
        productList.add(new Product("chocolate",7,categoryList.get(2),57,1900));
    }


    static int productListTotalPrice(List<Product> products){
        int total=0;

        for (Product p:products
             ) {
            total+=p.getPrice();
        }

        return total;
    }

    static void addOrders() {
        List<Product> products = new ArrayList<>();
        products.add(productList.get(0));
        products.add(productList.get(1));

        List<Product> products2 = new ArrayList<>();
        products2.add(productList.get(2));
        products2.add(productList.get(3));


        try {
            String sampleDate = "2021/9/05";
            String sampleDate2 = "2020/08/18";
            String sampleDate3 = "2020/01/18";
            Date orderDate = new SimpleDateFormat("yyyy/mm/dd").parse(sampleDate);
            Date orderDate2 = new SimpleDateFormat("yyyy/mm/dd").parse(sampleDate2);
            Date orderDate3 = new SimpleDateFormat("yyyy/mm/dd").parse(sampleDate3);
            Order order1 = new Order(1, orderDate, products, false, true, 0, productListTotalPrice(products));
            Order order2 = new Order(2, orderDate2, products2, true, false, 2, productListTotalPrice(products2));
            Order order3 = new Order(2, orderDate2, products2, true, false, 2, productListTotalPrice(products2));

            orders.add(order1);
            orders.add(order2);
            orders.add(order3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void showAllProducts(){
        for (Product p:productList
             ) {
            System.out.println(p);
        }
    }

    static List<Product> filterProductsByCategory(Category category){

       return productList.stream()
                .filter(x->x.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    static List<Order> filterOrdersByDate(Date startDate,Date endDate){

        return orders.stream()
                .filter(x->x.getOrderDate().compareTo(startDate)>0)
                .filter(x->x.getOrderDate().compareTo(endDate)<0)
                .collect(Collectors.toList());
    }


    static Optional<Product> cheapestInACategory(Category category){

        return productList.stream()
                .filter(x->x.getCategory().equals(category))
                .reduce((p1,p2)->p1.getPrice()<p2.getPrice()?p1:p2);
    }

    public static void main(String[] args) {

        addCategories();
        addProducts();
        addCustomer();
        addOrders();

        System.out.println();
        System.out.println();
        System.out.println("showing all products:");
        showAllProducts();

        System.out.println();
        System.out.println();

        Scanner scanner=new Scanner(System.in);


        System.out.println("filtering products by vegetable category:");
        System.out.println(filterProductsByCategory(categoryList.get(1)));

        System.out.println("...");
        System.out.println("...");
        System.out.println("showing all orders");
        System.out.println(orders);
        System.out.println();
        System.out.println("filtering orders by orders between 2020/01/01 to 2021/01/01");

        try {
            Date date=new SimpleDateFormat("yyyy/mm/dd").parse("2020/01/01");
            Date endDate= (new SimpleDateFormat("yyyy/mm/dd").parse("2021/01/01"));

            System.out.println(filterOrdersByDate(date, endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("...");
        System.out.println("...");
        System.out.println("...");

        System.out.println("finding the cheapest product in snacks category");

        System.out.println(cheapestInACategory(categoryList.get(2)));
    }
}
