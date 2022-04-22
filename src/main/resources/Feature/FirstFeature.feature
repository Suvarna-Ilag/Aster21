Feature: Add 5 Products to cart

Scenario: User Should not add more than 5 products to the cart
Given User Logs  into the system
When User add 5 products to the cart
And User add 6 th products to the cart
Then User will get error 

