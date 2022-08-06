## API Documentation 

# Admin Controller

GET <br />
​/admin -> adminHome , 
GET <br />
​/admin​/categories -> GetCategoriesPage , 
GET <br />
​/admin​/categories​/add  -> GetCategoriesAddPage , 
POST <br />
​/admin​/categories​/add -> PostCategoriesAddPage , 
GET <br />
​/admin​/categories​/delete​/{id} -> DeleteCategory , 
GET <br />
​/admin​/categories​/update​/{id} -> UpdateCategory , 
GET <br />
​/admin​/product​/delete​/{id} -> DeleteProduct , 
GET <br />
​/admin​/product​/update​/{id -> UpdateProduct , 
GET <br />
​/admin​/products -> GetProducts , 
GET <br />
​/admin​/products​/add -> GetProductsAdd , 
POST <br />
​/admin​/products​/add -> PostProduct , 

# Cart Controller

GET <br />
​/addToCart​/{id} -> addToCart , 
GET <br />
​/cart -> cart , 
GET <br />
​/cart​/removeItem​/{index} -> cartItemRemove , 
GET <br />
​/checkout -> checkout , 

# Home Controller

GET <br />
​/ -> home , 
GET <br />
​/home -> home , 
GET <br />
​/shop -> shop , 
GET <br />
​/shop​/category​/{id} -> shopByCategory , 
GET <br />
​/shop​/viewproduct​/{id} -> ViewProduct , 

# login Controller

GET <br />
​/login -> login , 
GET <br />
​/register -> registerGet , 
POST <br />
​/register -> registerPost , 

# Operation Handler

GET <br />
​/actuator​/health -> handle , 
GET <br />
​/actuator​/health​/** -> handle , 

# Paytm Controller

GET <br />
​/payNow -> home1 , 
POST <br />
​/payNow -> home , 
POST <br />
​/pgresponse -> getResponseRedirect , 
POST <br />
​/submitPaymentDetail -> getRedirect , 
