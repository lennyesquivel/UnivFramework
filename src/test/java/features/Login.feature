Feature: App Login

Scenario Outline: Opening home page after login
Given user is on banking landing page
When user logs in with user <username> and password <password>
Then login is <verification>

Examples:
|username			|password 	|verification	|
|"lenny@gmail.com"	|"12dth3"	|"false"		|
|"test99@gmail.com"	|"123456"	|"true"			|
|"dwfas@gmail.com"	|"rgwer"	|"false"		|
|"adasdf@gmail.com"	|"adv23"	|"false"		|