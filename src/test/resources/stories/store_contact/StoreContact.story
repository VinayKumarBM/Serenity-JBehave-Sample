Meta:
@testStore
@storeContact

Scenario: To verify that user is able to send message to Contact
Meta:
@contact
Given the user is on the Store home page
When the user enters the contact details <contactEmail>, <contactName> and <contactMessage> on the Contact popup
Then the user should see a message <message>

Examples:
|contactEmail		|contactName	|contactMessage							|message					|
|johndoe@gmail.com	|John Doe		|Sending a message to contact John Doe.	|Thanks for the message!!	|