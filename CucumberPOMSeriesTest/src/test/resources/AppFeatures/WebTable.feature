Feature: Webtable Feature
@Webtable
Scenario: Webtable practice
Given user is on practice page
When user gets the highest price of the table

Scenario Outline: Fixed Header Table
Given user is on practice page
When get all the names position and amount from the table which belongs to the "<City>"
 Examples: 
|City|
|Chennai|
|Pune|

Scenario: RadioButton checked
Given user is on practice page
When radio button is working fine



