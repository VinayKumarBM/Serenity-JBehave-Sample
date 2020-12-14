Meta:
@testStore
@storeLogin

Scenario: To verify that user is able to login with valid credentials
Meta:
@validLogin
Given the user is on the Store home page
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
And the user logs out of the Store

Examples:
|userName			|password	|
|test321@gmail.com	|test321	|

Scenario: To verify that user is not able to login with invalid credentials
Meta:
@invalidLogin
Given the user is on the Store home page
When the user enters the credentials <userName> and <password> on the Login popup
Then the user should see a message <message>

Examples:
|userName			|password	|message								|
|janedoe@gmail.com	|test321	|User does not exist.					|
|test321@gmail.com	|test123	|Wrong password.						|
|					|			|Please fill out Username and Password.	|