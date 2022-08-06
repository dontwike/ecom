## API Documentation 

# Admin Controller

GET
​/admin -> adminHome , 
GET
​/admin​/categories -> GetCategoriesPage , 
GET
​/admin​/categories​/add  -> GetCategoriesAddPage , 
POST
​/admin​/categories​/add -> PostCategoriesAddPage , 
GET
​/admin​/categories​/delete​/{id} -> DeleteCategory , 
GET
​/admin​/categories​/update​/{id} -> UpdateCategory , 
GET
​/admin​/product​/delete​/{id} -> DeleteProduct , 
GET
​/admin​/product​/update​/{id -> UpdateProduct , 
GET
​/admin​/products -> GetProducts , 
GET
​/admin​/products​/add -> GetProductsAdd , 
POST
​/admin​/products​/add -> PostProduct , 

# Cart Controller

GET
​/addToCart​/{id} -> addToCart , 
GET
​/cart -> cart , 
GET
​/cart​/removeItem​/{index} -> cartItemRemove , 
GET
​/checkout -> checkout , 

# Home Controller

GET
​/ -> home , 
GET
​/home -> home , 
GET
​/shop -> shop , 
GET
​/shop​/category​/{id} -> shopByCategory , 
GET
​/shop​/viewproduct​/{id} -> ViewProduct , 

# login Controller

GET
​/login -> login , 
GET
​/register -> registerGet , 
POST
​/register -> registerPost , 

# Operation Handler

GET
​/actuator​/health -> handle , 
GET
​/actuator​/health​/** -> handle , 

# Paytm Controller

GET
​/payNow -> home1 , 
POST
​/payNow -> home , 
POST
​/pgresponse -> getResponseRedirect , 
POST
​/submitPaymentDetail -> getRedirect , 
