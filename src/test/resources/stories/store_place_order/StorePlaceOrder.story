Meta:
@testStore
@storePlaceOrder

Scenario: To verify that user sees an error when he tries to purchase without entering the details
Meta:
@placeOrderAlertMessage
Given the user is on the Store home page
When the user filters products by Category <category>
And the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user sees the products in cart
And the user places an order
And the user enters the order details <name>, <country>, <city>, <creditCard>, <month>, <year>
And the user should see an alert message <alertMsg>

Examples:
|category	|product		|message		|name	|country|city	|creditCard	|month	|year	|alertMsg								|
|Monitors	|ASUS Full HD	|Product added	|		|		|		|			|		|		|Please fill out Name and Creditcard.	|

Scenario: To verify that user is able to place an order
Meta:
@placeOrder
Given the user is on the Store home page
When the user filters products by Category <category>
And the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user sees the products in cart
And the user places an order
And the user enters the order details <name>, <country>, <city>, <creditCard>, <month>, <year>
And the user see confirmation message <confirmationMessage> with order details

Examples:
|category	|product		|message		|name		|country		|city		|creditCard			|month	|year	|confirmationMessage			|
|Monitors	|ASUS Full HD	|Product added	|John Doe	|United States	|New York	|4567654378904321	|12		|2025	|Thank you for your purchase!	|

Scenario: To verify that user is able to place an order as a registered user
Meta:
@placeOrderRegisteredUser
Given the user is on the Store home page
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
When the user filters products by Category <category>
And the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user sees the products in cart
And the user places an order
And the user enters the order details <name>, <country>, <city>, <creditCard>, <month>, <year>
And the user see confirmation message <confirmationMessage> with order details
And the user logs out of the Store

Examples:
|userName			|password	|category	|product			|message		|name		|country		|city		|creditCard			|month	|year	|confirmationMessage			|
|test321@gmail.com	|test321	|Laptops	|2017 Dell 15.6 Inch|Product added.	|John Doe	|United States	|New York	|7654456378904321	|1		|2022	|Thank you for your purchase!	|

Scenario: To verify that user is able to place an order with multiple products
Meta:
@multiProductOrder
Given the user is on the Store home page
When the user filters products by Category <category>
And the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user adds another product 'Nokia lumia 1520' to cart
And the user sees the products in cart
And the user places an order
And the user enters the order details <name>, <country>, <city>, <creditCard>, <month>, <year>
And the user see confirmation message <confirmationMessage> with order details

Examples:
|category	|product		|message		|name		|country		|city	|creditCard			|month	|year	|confirmationMessage			|
|Laptops	|MacBook Pro	|Product added	|Jane Doe	|United Kingdom	|London	|4321456765437890	|10		|2024	|Thank you for your purchase!	|

Scenario: To verify that user is able to place an order with multiple products as a registered user
Meta:
@multiProductOrderRegisteredUser
Given the user is on the Store home page
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
When the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user adds another product 'Sony vaio i5' to cart
And the user sees the products in cart
And the user places an order
And the user enters the order details <name>, <country>, <city>, <creditCard>, <month>, <year>
And the user see confirmation message <confirmationMessage> with order details
And the user logs out of the Store

Examples:
|userName			|password	|product		|message		|name		|country		|city	|creditCard			|month	|year	|confirmationMessage			|
|test321@gmail.com	|test321	|Iphone 6 32gb	|Product added.	|Jane Doe	|United Kingdom	|London	|4321456765437890	|10		|2024	|Thank you for your purchase!	|