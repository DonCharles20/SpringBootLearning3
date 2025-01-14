package com.don.springweb.Contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*@Contoller
 In Spring, a Controller is a class annotated with @Controller 
 that handles incoming HTTP requests and determines the response sent back to the client. 
 It acts as a mediator between the user interface (UI) and the application logic, 
 managing the flow of data. Controllers typically receive requests, 
 process them with the help of service layers, and return a view name or a model object. 
 These views are usually JSP, Thymeleaf, or other template engines, 
 which generate the UI for the client. 
 The @Controller annotation is part of the Spring MVC framework 
 and is used when building web applications that follow the Model-View-Controller (MVC) design pattern.

 Controllers use method-level annotations like @RequestMapping or its variants 
 (@GetMapping, @PostMapping, etc.) to map HTTP requests to specific methods. 
 These methods can then use models or attributes to pass data to the views. 
 Additionally, they rely on Model or ModelAndView objects to prepare the data needed by the view. 
 Controllers are best suited for traditional web applications 
 where server-side rendering of HTML pages is a core requirement.
 */

/*@RestController
A RestController is a specialized version of the Controller in Spring, 
annotated with @RestController. It is used for building RESTful(Representational State Transfer) web services, 
where the response is typically data (in formats like JSON or XML) rather than an HTML page. 
The @RestController annotation combines @Controller and @ResponseBody, 
meaning that every method within the class returns the response body directly, 
eliminating the need for manual inclusion of @ResponseBody on each method.

RestControllers are ideal for APIs that are consumed by other applications,
such as mobile apps or JavaScript-based frontends. 
They process incoming HTTP requests, 
handle application logic (often through service layers), and send back data as responses. 
For example, a method returning a Java object
will have it automatically serialized into JSON or XML, 
depending on the client’s request headers and the Spring configuration.
*/

@Controller
public class HomeController {

    @RequestMapping("/")
    /**
     * Handles HTTP GET requests for the root URL ("/").
     * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
     * can also use @GetMapping("/")
     * 
     * The @RequestMapping annotation is used to map web requests to specific handler
     * methods in Spring MVC and Spring Boot applications. In this case, it maps the root URL ("/")
     * to the greet() method. When a user accesses the root URL of the application, this method
     * will be invoked, and it will return the string "Welcome", which can be used to render a view
     * or as a response body.
     * 
     * @return A welcome message as a String.
     */
    @ResponseBody/*
    The @ResponseBody annotation in Spring is used to indicate 
    that the return value of a method should be written directly to the HTTP response body, 
    rather than being interpreted as a view name.
    It is primarily used to send data (such as JSON, XML, or plain text) 
    directly to the client in RESTful web services or when building APIs. 

    When a method is annotated with @ResponseBody,
     Spring skips the view resolution process. 
     Instead, the return value of the method is serialized 
     into a suitable format (e.g., JSON or XML) and 
     sent back to the client as the HTTP response body. 
     This serialization is handled automatically by Spring's message converters
     
     */
    public String greet() {
        return "Welcome";
    }
    
    @RequestMapping("/about")
    public String about(){
        return"Me";
    }
    /*Front Controller:
     * In Spring MVC, the Front Controller is a design pattern that provides a centralized entry point 
     * for handling all web requests. The DispatcherServlet is the front controller in Spring MVC, 
     * which intercepts incoming requests and delegates them to appropriate handler methods 
     * within controller classes. It manages the entire request handling process, including 
     * view resolution, exception handling, and more.
     */

}
