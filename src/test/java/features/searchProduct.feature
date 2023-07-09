Feature: Search and Place the Order for Products

@OffersPage
Scenario Outline: Search for a Product both in home and Offers page
Given User is on the GreenCart Landing Page.
When User searched with Short name <Name> and extracted actual name of the Product.
Then User searched with Short name <Name> in Offers page to check if the Product exists.

Examples:
|Name|
|Tom|
|Man|
|Straw|