Feature: Search and Place the Order for Products in the Cart.
@CartPage
Scenario: Add 4 products of same type in home page and verify in checkout page.
Given User is on the GreenCart Landing Page.
When User searched with Short name "Tom" and added four times of the Product and added to cart.
Then User verifies product name and Apply and Place Order button should be visible.