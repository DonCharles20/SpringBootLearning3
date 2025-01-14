package com.don.springweb.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*What is lombok, what does it do and how it helps:
Lombok is a library that helps reduce boilerplate code in Java classes.
It provides a set of annotations that generate code during compilation,
such as getters, setters, constructors, and more.
By using Lombok annotations, developers can write more concise and readable code,
as they don't have to manually write repetitive code for common tasks.
For example, instead of writing getters and setters for each field in a class,
developers can use the @Data annotation from Lombok to generate them automatically.
This can help reduce the amount of code that needs to be written and maintained,
making the codebase cleaner and easier to work with.
Lombok is commonly used in Java projects to improve developer productivity and reduce code duplication.
*/

//@Data
/*what is @Data and what does it do and how it works:
 * The @Data annotation is a Lombok annotation that generates getters, setters,
 * toString, equals, and hashCode methods for the fields in a Java class.
 * By using @Data, developers can avoid writing boilerplate code for these common tasks,
 * making the codebase more concise and readable.
 * The @Data annotation is often used in conjunction with other Lombok annotations,
 * such as @Getter and @Setter, to further reduce the amount of code that needs to be written.
 * For example, instead of writing separate getter and setter methods for each field in a class,
 * developers can use @Data to generate them automatically.
 * This can help improve developer productivity and reduce the likelihood of errors in the codebase.
 * The @Data annotation is commonly used in Java projects to simplify the creation of data classes
 * and reduce the amount of repetitive code that needs to be written.
 */

//@AllArgsConstructor
/*what is @AllArgsConstrcutor what does it do and how it works:
 * The @AllArgsConstructor annotation is a Lombok annotation that generates a constructor
 * for a Java class that initializes all fields in the class.
 * By using @AllArgsConstructor, developers can avoid writing boilerplate code for constructors
 * that take multiple arguments, making the codebase more concise and readable.
 * The @AllArgsConstructor annotation is often used in conjunction with other Lombok annotations,
 * such as @Data and @NoArgsConstructor, to further reduce the amount of code that needs to be written.
 * For example, instead of writing a constructor that initializes each field in a class,
 * developers can use @AllArgsConstructor to generate it automatically.
 * This can help improve developer productivity and reduce the likelihood of errors in the codebase.
 * The @AllArgsConstructor annotation is commonly used in Java projects to simplify the creation of data classes
 * and reduce the amount of repetitive code that needs to be written.
 * 
 */
@Component
@Entity
/*What is @Entity?
 * The @Entity annotation is a JPA (Java Persistence API) annotation that marks a Java class as an entity.
 * An entity is a lightweight persistence domain object that represents a table in a relational database.
 * By marking a class with @Entity, developers can map the class to a database table and define the fields
 * and relationships of the entity using JPA annotations.
 * The @Entity annotation is used to create a mapping between a Java class and a database table,
 * allowing developers to perform CRUD (Create, Read, Update, Delete) operations on the entity using JPA.
 * Entities are typically used to represent data in a database and provide a way to interact with the database
 * using object-oriented programming concepts.
 * The @Entity annotation is commonly used in JPA applications to define the structure of database tables
 * and map them to Java classes for data manipulation.
 * 
 * When using a JPA repository, the entity class must be annotated with @Entity to indicate that it is a persistent entity.
 */
public class Product {
    @Id//this lets the JPA know that this is the primary key
    //what is a Primary Key?
    //A primary key is a unique identifier for a record in a database table.
    //It uniquely identifies each record in the table and is used to enforce entity integrity.
    //A primary key must contain unique values and cannot contain null values.
    //In relational databases, a primary key is typically defined as a column or set of columns that uniquely identify each record in a table.
    //Primary keys are used to establish relationships between tables and ensure data integrity in the database.
    //In JPA, the @Id annotation is used to specify the primary key of an entity class.
    //The @Id annotation is applied to the field or property that represents the primary key of the entity.
    //The primary key field must be unique and cannot contain null values.
    //The @Id annotation is used to indicate that a field is the primary key of the entity.
    //The primary key field is used to uniquely identify each record in the database table.
    //The @Id annotation is commonly used in JPA applications to define the primary key of an entity class.
    private int prodId;
    private String prodName;
    private int price;


    //Constructor is not needed since I have Lombok @AllArgsConstructor
    //for the sake of following the tutorial I made it
    //ran into an error where it needed a defaut constrcutor
    public Product(){

    }
    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }
    //Setters and getters are not needed since I have Lombok
    //for the sake of following the tutorial I made them
    public int getProdId(){
        return prodId;
    }
    public void setProdId(int prodid){
        this.prodId=prodid;
    }

    public String getProdName(){
        return prodName;
    }
    public void setProdName(String prodName){
        this.prodName=prodName;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }

    @Override
    public String toString() {
        return "Product[prodId=" + prodId 
                + ", prodName=" + prodName 
                + ", price=" + price 
                + "]";
    }


}
