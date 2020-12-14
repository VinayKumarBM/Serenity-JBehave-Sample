Meta:
@testStore
@storeCart

Scenario: To verify that user is able to add and delete products from cart
Meta:
@addToCart
Given the user is on the Store home page
When the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user adds another product 'HTC One M9' to cart
And the user should see a message <message>
And the user adds another product 'Iphone 6 32gb' to cart
And the user should see a message <message>
And the user sees the products in cart
And the user deletes all the products on cart

Examples:
|product	|message		|
|Nexus 6	|Product added	|

Scenario: To verify that product added to cart by user will still be in cart even after logging out
Meta:
@cartHistory
Given the user is on the Store home page
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
When the user selects the product <product> from PLP
And the user adds the product to cart
Then the user should see a message <message>
And the user sees the products in cart
And the user logs out of the Store
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
And the user sees the products in cart
And the user deletes all the products on cart
And the user logs out of the Store

Examples:
|userName			|password	|product	|message		|
|test321@gmail.com	|test321	|Nexus 6	|Product added.	|