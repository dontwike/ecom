<h1 align="center">API Documentation </h1>

# Admin Controller

GET <br />
​/admin -> adminHome <br />
GET <br />
​/admin​/categories -> GetCategoriesPage  <br /> 
GET <br />
​/admin​/categories​/add  -> GetCategoriesAddPage  <br /> 
POST <br />
​/admin​/categories​/add -> PostCategoriesAddPage   <br />
GET <br />
​/admin​/categories​/delete​/{id} -> DeleteCategory  <br /> 
GET <br />
​/admin​/categories​/update​/{id} -> UpdateCategory  <br /> 
GET <br />
​/admin​/product​/delete​/{id} -> DeleteProduct <br />
GET <br />
​/admin​/product​/update​/{id -> UpdateProduct  <br /> 
GET <br />
​/admin​/products -> GetProducts  <br /> 
GET <br />
​/admin​/products​/add -> GetProductsAdd  <br /> 
POST <br />
​/admin​/products​/add -> PostProduct  <br /> 

# Cart Controller

GET <br />
​/addToCart​/{id} -> addToCart  <br /> 
GET <br />
​/cart -> cart  <br  <br />
GET <br />
​/cart​/removeItem​/{index} -> cartItemRemove  <br  <br />
GET <br />
​/checkout -> checkout  <br  <br />

# Home Controller

GET <br />
​/ -> home  <br />
GET <br />
​/home -> home  <br />
GET <br />
​/shop -> shop  <br />
GET <br />
​/shop​/category​/{id} -> shopByCategory  <br />
GET <br />
​/shop​/viewproduct​/{id} -> ViewProduct  <br />

# login Controller

GET <br />
​/login -> login  <br />
GET <br />
​/register -> registerGet  <br />
POST <br />
​/register -> registerPost  <br />

# Operation Handler

GET <br />
​/actuator​/health -> handle  <br />
GET <br />
​/actuator​/health​/** -> handle  <br />

# Paytm Controller

GET <br />
​/payNow -> home1  <br />
POST <br />
​/payNow -> home  <br />
POST <br />
​/pgresponse -> getResponseRedirect  <br />
POST <br />
​/submitPaymentDetail -> getRedirect  <br />
