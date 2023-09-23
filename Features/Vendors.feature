Feature:Vendor

Scenario Outline: Add New Customer
  Given User launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    When User enter email as "<email>" and password as "<password>"
    When user click on login button
  Then User can view Dashboard
   When user click on customers menu
   And  User click on vendor item
  Then User can view vendor page
  When User enter Vendor name as "<Vendorname>" and password as "<Vendoremail>"
  And  User click on Search button
  And close browser
  
  Examples:
   |email|password|Vendorname|Vendoremail|
   |admin@yourstore.com|admin|Vendor 1|vendor1email@gmail.com|
   |admin@yourstore.com|admin|Vendor 2|vendor2email@gmail.com|