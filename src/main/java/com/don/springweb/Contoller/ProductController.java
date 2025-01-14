package com.don.springweb.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.don.springweb.model.Product;
import com.don.springweb.service.ProductService;


/*Http Methods in Rest API:
 *what is @GetMapping:
 * The @GetMapping annotation is used to map HTTP GET requests onto specific handler methods in Spring MVC controllers.
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
 * Purpose: Maps HTTP GET requests to a specific method.
 * Use Case: Fetch or retrieve data from the server without modifying any resources.
 * example: Fetching a list of products from a database or an API.
 * Commonly used for fetching a web page or an API resource.
 * 
 * What is @PostMapping:
 * The @PostMapping annotation is used to map HTTP POST requests onto specific handler methods in Spring MVC controllers.
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
 * Purpose: Maps HTTP POST requests to a specific method.
 * Use Case: Create a new resource or submit data to the server.
 * example: Creating a new user account or submitting a form.
 * Commonly used for submitting form data or creating a new record in a database.
 * 
 * What is @RequestMapping:
 * The @RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
 * It is a method-level annotation that is used to define request mappings for Spring MVC controllers.
 * Purpose: Maps web requests to specific or multiple handler methods or classes.
 * Use Case: Define URL patterns and HTTP methods that a controller can handle.
 * 
 * what is @PutMapping:
 * The @PutMapping annotation is used to map HTTP PUT requests onto specific handler methods in Spring MVC controllers.
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).
 * Purpose: Maps HTTP PUT requests to a specific method.
 * Use Case: Update an existing resource on the server.
 * example: Updating a user profile or modifying an existing password in a database.
 * Commonly used for updating an existing record or resource.
 * 
 * what is @DeleteMapping:
 * The @DeleteMapping annotation is used to map HTTP DELETE requests onto specific handler methods in Spring MVC controllers.
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).
 * Purpose: Maps HTTP DELETE requests to a specific method.
 * Use Case: Delete an existing resource from the server.
 * example: Deleting a user account or removing a record from a database.
 * Commonly used for deleting an existing record or resource.
 * 
 */
@RestController//This annotation is used to indicate that the class is a REST controller in a Spring application.
public class ProductController {

    @Autowired
    ProductService service;
    /*Using autowired we can acess the ProductService class and its methods */

    @RequestMapping("/products")//since request is universal we can also use @GetMapping("/products")
    public List<Product> getProduct() {
        return service.getProducts();
    }
    //This will return a list of products from service

    @GetMapping("/products/{prodId}")
    /*The {} are used to specify the path variable in the URL
     * The @PathVariable annotation is used to bind the path variable to the method parameter
     * The value of the path variable is passed as an argument to the method
     * 
     */
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }//when using GET on postman, this will return the product by id

    @PostMapping("/products")
    /* What is RequestBody and how does it work:
     * The @RequestBody annotation is used to bind the HTTP request body to a method parameter in a Spring MVC controller.
     * It indicates that a method parameter should be bound to the body of the HTTP request.
     * The @RequestBody annotation can be used to handle JSON, XML, or other types of data in the request body.
     * When a request is made to the controller, Spring will automatically convert the request body into the specified method parameter type.
     * The @RequestBody annotation is commonly used in RESTful web services to handle data sent in the request body.
     *
    */
    public void addProduct(@RequestBody Product prod) {
        System.out.println(prod);
        service.addProduct(prod);
    }//When using POST on postman, this will add a product converting from JSON forman to java
    //Rember to match the atribute names on JSON with the corrsposding class

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);

    }//When using PUT on postman, this will replace the product by ID

    @DeleteMapping("/products/{prodId}")//Here we are using @DeleteMapping to delete the product by ID
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
    
}
