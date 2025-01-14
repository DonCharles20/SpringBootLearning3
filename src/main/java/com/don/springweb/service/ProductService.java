package com.don.springweb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.don.springweb.Repository.ProductRepo;
import com.don.springweb.model.Product;

@Service//This annotation is used to indicate that the class is a service class in a Spring
public class ProductService {

    @Autowired
    ProductRepo repo;

    /* =Arrays.asList vs =new ArrayList<>(Arrays.asList)
     * Arrays.asList is a static method that returns a fixed-size list backed by the specified array.
     * The list is fixed-size because it is backed by the original array, and any changes to the list will be reflected in the array.
     * The list returned by Arrays.asList is a view of the original array, so it does not support operations that modify the list size.
     * The list returned by Arrays.asList is a List, not an ArrayList, so it does not support operations like add or remove.
     * The list returned by Arrays.asList is a read-only list, so it cannot be modified.
     * 
     * new ArrayList<>(Arrays.asList) creates a new ArrayList object that contains the elements of the specified array.
     * The new ArrayList object is a separate object from the original array, so changes to the list will not be reflected in the array.
     * The new ArrayList object is mutable, so it supports operations like add and remove.
     * The new ArrayList object is an ArrayList, so it supports all the operations provided by the ArrayList class.
     * The new ArrayList object is not a view of the original array, so changes to the list will not affect the original array.
     * 
     * 
     * 
     */
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "cannon Camera", 70000),
            new Product(103, "Shure Mic", 10000)
    ));

    public List<Product> getProducts() {
        //return products;
        return repo.findAll();
    }

    /*What is Stream Api and how does it work here:
     * Stream API is used to process collections of objects. 
     * A stream is a sequence of objects that supports various methods 
     * which can be pipelined to produce the desired result.
     * The features of Java stream are:
     * A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
     * Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
     * Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined.
     * Stream is used to compute the result and it does not modify the data structure.
     * Stream API makes the code more readable and maintainable.
     * Stream API is very useful for collection objects.
     * 
     * Here in the Below code we are using the Stream API to filter the product by Id
     * The List of products is converted to a stream 
     * and then we are using the filter method to filter the product by Id which is passed as a parameter
     * of the predicate function using lambda expression
     * and then we are using the findFirst method to get the first product from the filtered list
     * (Chance of getting multiple products is not there)
     * and then we are using the get method to get the product from the Optional object
     * 
     * 
     */
    public Product getProductById(int prodId) {
        /*
        return products.stream().filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(404, "Product Not Found", 0));
         */
        return repo.findById(prodId).orElse(new Product());
        /*what is the method find by ID?
        * it is a method that is provided by the JPA repository
        * it is used to find an object by its primary key
        * it returns an optional object
        * what is an optional object?
        * it is a container object that may or may not contain a non-null value
        * if a value is present, you can call get() to get the value
        * if a value is not present, there will be an error
        * you can also use orElse() to return a default value if the value is not present
        * findById() will show an error by default for the event that the value is not present
        * use orElse() to return a default value or use orElseThrow() to throw an exception, or Get() to get the value
        */
    }

    public void addProduct(Product prod) {
        //products.add(prod);
        repo.save(prod);
    }

    /*with the help of the jackson libary
     * we can convert the java object to json object
     * and vice versa
     * With the help of Postman we can test the API
     * by sending the json object as a request body
     * and we can see the response in the json format
     * Remembet to Use GET to get the data
     * and POST to add the data
     */
    public void updateProduct(Product prod) {
        /*int index=0;
        for (int i = 0; i <products.size(); i++) {
            if(products.get(i).getProdId()==prod.getProdId())
                index=i;
            
        }
        products.set(index,prod);*/
        /*
        for (Product item : products) {
            if (item.getProdId() == prod.getProdId()) {
                products.set(products.indexOf(item), prod);
                break;
            }
        }
        */
        /*This for each loop is used to iterate through the list of products
         * and then we are checking if the product id of the product in the list
         * is equal to the product id of the product which is passed as a parameter
         * if it is equal then we are using the set method to replace the product in the list
         * with the product which is passed as a parameter
         */
        repo.save(prod);//will check if the data is there if not, create a new one
    }

    public void deleteProduct(int prodId) {
        /*for (Product item : products) {
            if (item.getProdId() == prodId) {
                products.remove(products.indexOf(item));
                break;
            }

        }
        */
        repo.deleteById(prodId);

    }
    /*This for each loop is used to iterate through the list of products
         * and then we are checking if the product id of the product in the list
         * is equal to the product id of the product which is passed as a parameter
         * if it is equal then we are using the set method to Delete the product in the list
         * with the product which is passed as a parameter
     */

}
