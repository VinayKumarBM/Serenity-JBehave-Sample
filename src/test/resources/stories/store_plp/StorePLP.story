Meta:
@testStore
@storePLP

Scenario: To verify that user is able to view product details
Meta:
@productDetails
Given the user is on the Store home page
When the user filters products by Category <category>
And the user selects the product <product> from PLP
Then the user should see all the product details of <product> on PDP

Examples:
|category	|product			|
|Phones		|Nexus 6			|
|Laptops	|MacBook Pro		|
|Monitors	|Apple monitor 24	|

Scenario: To verify the Pagination
Meta:
@productPagination
Given the user is on the Store home page
Then the user verifes the Pagination of PLP