package C;

import C.Models.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {


    public static void main(String[] args) {

        List<Category> categoryList=new ArrayList<>();

        categoryList.add(new Category("fruits",1));
        categoryList.add(new Category("vegetables",2));
        categoryList.add(new Category("snacks",3));
        categoryList.add(new Category("detergents",4));

        List<Product> productList=new ArrayList<>();
        productList.add(new Product("apple",1,categoryList.get(0),14,1500));
        productList.add(new Product("carrot",2,categoryList.get(0),14,1600));
        productList.add(new Product("lemon",3,categoryList.get(0),14,1400));
//        productList.add(new Product("apple",4,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",5,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",6,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",7,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",8,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",9,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",10,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",11,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",12,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",13,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",14,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",15,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",16,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",17,categoryList.get(1),14,1500));
//        productList.add(new Product("apple",18,categoryList.get(1),14,1500));

        List<Customer>customerList=new ArrayList<>();

        Date now=new Date(new java.util.Date().getTime());
        customerList.add(new Customer("ad","madi",now,"mad75","664",1));
        customerList.add(new Customer("ad","madi",now,"mad7235","45",2));
        customerList.add(new Customer("asd","dfdv",now,"mad74","63",3));


        List<Order>orders=new ArrayList<>();
        orders.add(new Order(0,productList,true,true,0));


        Product productOptional=productList.stream()
                .filter(x->x.getCategory().getId()==1)
                .reduce((p1,p2)->p1.getPrice()<p2.getPrice()?p1:p2)
                .get();

        System.out.println(productOptional);


    }
}
