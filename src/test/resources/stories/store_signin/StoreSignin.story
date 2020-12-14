Meta:
@testStore
@storeSignin

Scenario: To verify that user is able to sign up with valid credentials
Meta:
@validSignin
Given the user is on the Store home page
When the user enters the <userName> and <password> on the Signin popup
Then the user should see a message <message>
When the user enters the credentials <userName> and <password> on the Login popup
Then the user <userName> should be logged into the store
And the user logs out of the Store

Examples:
|userName			|password	|message				|
|test%s@gmail.com	|test321	|Sign up successful.	|

Scenario: To verify that user is not able to signin with invalid credentials
Meta:
@invalidSignin
Given the user is on the Store home page
When the user enters the <userName> and <password> on the Signin popup
Then the user should see a message <message>

Examples:
|userName			|password	|message								|
|janedoe@gmail.com	|			|Please fill out Username and Password.	|
|test321@gmail.com	|test321	|This user already exist.				|
|					|test123	|Please fill out Username and Password.	|
|					|			|Please fill out Username and Password.	|