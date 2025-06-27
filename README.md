# EasyShop
Description : A Website for all your needs, from Electronics, Fashion, and Home.

What is Easy Shop? A Spring Boot based E-Commerce REST API that allows user to browse and find their favorite products, with an easy to use filtering system that filters on price, category, and even colors!

The Goal of EasyShop? To simulate a modern day e-commerce platform backend with a secure login/register features, product filtering, admin management tools, and shopping cart functionality. It demonstrates CRUD (Create, Read, Update, Delete) operations, user authentication, authorization, and dynamic filtering of resources.

The Tech Specs and Dependencies : 
- Spring Boot, Spring Security w/ JWT Authorization
- MySQL
- JDBC for DAO (Data Access Object patterns)
- Postman for API testing
- BCrypt for password hashing
- Maven for dependency management 

Key Features :
- Role Based Authorization between Admin + User 
- Product Search Filtering 
  - Category
  - Price Range
  - Color


🐞 Bugs Found & How We Solved Them
🐛 Bug 1: Products were not found
    Problem: When loading the application, no products would appear
    Solution : Fixed by running unit tests to be able to show products and implemented a filtering method that can filter products by color or price


🐛 Bug 2: Category Method didn't display category 
    Problem : The three categories wouldn't display on website
    Solution : Fixed by running unit test and connection the SQL workbench queries to connect to database and link categories to proper Category Controller and Database Classes 



Key Component: Correct method invocation in ProductsController

🚀 Getting Started
Clone the repo

Run provided SQL script to set up MySQL schema and seed users

Update /src/main/resources/application.properties with DB credentials and JWT secret

Run EasyShopApplication.java

Test endpoints using Postman

🙌 Final Notes
This project demonstrates how to build a secure, real-world Spring Boot e-commerce backend with custom DAO logic, robust error handling, and JWT-based session control.
