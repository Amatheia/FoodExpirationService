# Food Expiration Service User Documentation 

### Process

 This service allows you to enter a food category, then pick a specific food item based 
 on the category you selected. The rest service then determines how long the food is good 
 for.

### Output 

For a specific food category, use the form located on the 
"52.14.138.145:8080/foodexpirationservice" page to get an html result.

Output example for entering Meat as the category, Bacon as the Food Item:
Item: Bacon
Expiration: 1 Week

By going to the "expiration/categories" page, you can get JSON output of the different 
category options.
Output example:
[{"categoryName":"Dairy","categoryId":1},{"categoryName":"Meat","categoryId":2},
{"categoryName":"Fruit","categoryId":3},{"categoryName":"Vegetables","categoryId":4}]

By going to the "/expiration/items" page, you can get JSON output of the different item 
options. 
Output example:
[{"itemId":1,"itemName":"Hard Cheese Parmesan, Asiago, Romano",
"expirationTime":"3-6 Weeks","categoryId":1},{"itemId":2,"itemName":"Shredded Hard Cheese 
Parmesan, Asiago, Romano","expirationTime":"3-4 Weeks","categoryId":1}]

By going to the "/expiration/itemsByCategory?categoryId=enterIdHere" page, you can get 
JSON output of the different Item options by the specific Category Id that you enter in 
the URL where it says "enterIdHere".
[{"itemId":55,"itemName":"Apples","expirationTime":"1-2 Months","categoryId":3},
{"itemId":56,"itemName":"Apples Cut","expirationTime":"3-5 Days","categoryId":3}]

 By going to the "/expiration/itemsByName?itemName=enterNameHere" page, you can get JSON 
 output of the Item by the specific Item Name that you enter in the URL where it says 
 "enterNameHere".
 [{"itemId":55,"itemName":"Apples","expirationTime":"1-2 Months","categoryId":3}]
 
 By going to the "/expiration/categoriesByName?categoryName=enterNameHere" page, you can 
 get JSON output of the Category by the specific Category Name that you enter in the URL 
 where it says "enterNameHere".
 [{"itemId":55,"itemName":"Apples","expirationTime":"1-2 Months","categoryId":3}]

### How it works

We created a process that grabbed data from the <a href="www.eatbydate.com">Eat By Date</a> 
website and parsed/picked through that data using JSoup to get one output for the opened 
and refrigerated expiration time frame. We then transformed the data into a convenient 
interface for users to access as needed.

### Errors

500 Error: You have reached this page in error or the server may be down.

### Disclaimer

This service only includes fresh, refrigerated, opened expiration times. Frozen, unopened, 
or canned have been excluded.
