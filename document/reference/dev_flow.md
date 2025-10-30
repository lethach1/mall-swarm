# mall

## Tech Stack

### Backend Technologies

Technology | Name
----|----
Spring Boot | Container + MVC framework
Spring Security | Authentication and authorization framework
MyBatis | ORM framework
MyBatisGenerator | Data layer code generator
PageHelper | MyBatis paging plugin
Swagger-UI | Documentation tool
Hibernator-Validator | Validation framework
Elasticsearch | Search engine
RabbitMq | Message queue
Redis | Distributed cache
MongoDb | NoSQL database
Docker | Application container engine
Druid | Database connection pool

### Frontend Technologies

Technology | Name
----|----
Vue | Frontend framework
Vue-router | Routing framework
Vuex | Global state management framework
Element | Frontend UI framework
Axios | HTTP utility for frontend
Js-cookie | Cookie management utility

### Framework Setup

Feature | Complete
----|----
Integrate MyBatis | ✔
Integrate MyBatisGenerator | ✔
Integrate SpringSecurity | ✔
Integrate Swagger-UI | ✔
Integrate Hibernator-Validator | ✔
Logging Function | ✔
Monitoring Function | ✔
CRUD Demo | ✔
Organize Package Structure | ✔
SpringAOP General Log Handler | ✔
SpringAOP Failure Return Handler | ✔
CommonResult General Response Wrapper | ✔
SpringSecurity Restful Authentication | ✔
JWT Login/Register/Token Get | ✔
JTA Transaction | ✔
Unit Testing | ✔
OSS Upload Function | ✔
Elasticsearch Search Function | ✔
HTTPS Support | ✔
Redis Numeric ID Generation | ✔
SpringTask Scheduled Task Support | ✔
Docker Container Deployment | ✔
Config Separation Prod/Test | ✔
ELK Log Collection | ✔
RabbitMq Async Communication | ✔
RestTemplate Service Communication | ✔
SpringSecurity Permission Management | ✔
Integrate SpringCloud |

### Development Tools

Tool | Download Link
----|----
IDEA Dev Tool | https://www.jetbrains.com/idea/download
Redis GUI Tool | https://redisdesktop.com/download
Mongo GUI Tool | https://robomongo.org/download
Local Host Management | https://oldj.github.io/SwitchHosts/
Linux SSH Tool | http://www.netsarang.com/download/software.html
DB Management Tool | http://www.formysql.com/xiazai.html
DB Design Tool | http://powerdesigner.de/
Prototyping Tool | https://www.axure.com/
Mindmap Tool | http://www.edrawsoft.cn/mindmaster
GIF Recording Tool | https://www.screentogif.com/

### Admin Features

#### Admin Login ✔

- Admin User Registration
- Retrieve Token after Admin Login
- Token Refresh

#### Product Management ✔

> **Category Management**

- View Category List by Parent Category ID, paginated
- Add/Edit/Delete Category
- Move Product to Category

> **Brand Management**

- View Brand List by Name, paginated
- Add/Edit/Delete Brand
- View All Products of Brand

> **Attribute Category Management**

- Add Attribute Category (Name)
- Paginated Query All Attribute Categories
- Delete Attribute Category
- Edit Attribute Category Name
- Get Attribute Category Info

> **Attribute Management**

- Get Attribute/Parameter list by Category (Paginated, types supported)
- Add Attribute
- Get Single Attribute
- Edit Attribute
- Batch Delete Attributes
- Paginated Query All Attributes

> **Add Product**

- Choose Category: Lookup by category id
- Choose Brand: Query all brands
- Choose Freight Template: Query all templates
- Set Member Price: Query all member levels, pass List<PmsMemberPrice>
- Add Ladder Price: Pass List<PmsProductLadder>
- Set Full-Reduction Price: Pass List<PmsProductFullReduction>
- Choose Attribute Category: Get all attribute categories, get specs and params by id (type=0⇒spec, type=1⇒param)
- Choose Spec and Generate Inventory: Frontend handles
- Add Sku Inventory: Pass List<PmsSkuStock>
- Set Attribute Image: Set to pic and album_pics fields
- Add Product Parameter: Pass List<PmsProductAttributeValue>
- Add Custom Product Spec: Pass List<PmsProductAttributeValue>
- Associate Subject: Pass List<CmsSubjectProductRelation>
- Associate Preferred: Pass List<CmsPrefrenceAreaProductRelation>

> **Edit Product**

- Get Product by ID
- Get Product Basic Info: Category, Brand, Freight Template Names
- Get Promotion Info: Member Prices, Ladder Prices, Full-Reduction
- Get Attribute Info: Attribute Category, Sku Inventory, Specs and Params
- Get Association Info: Subjects and Preferred
- Edit Product Info: Attribute Category and Spec cannot be modified, only support single sku edit/delete/add; if modifiable, show old sku inventory and attribute category simultaneously

> **Product Pagination Query**

- Product Status: All, Published, Unpublished, Pending, Rejected (publishStatus verifyStatus)
- Product Name (%name%)
- Product Serial (productSn)
- Product Category ID (productCategoryId)
- Product Brand ID (brandId)
- Batch Operations: Publish/Unpublish, Recommend, New, Transfer Category, Move to Recycle, Audit
- View Logs: Audit Logs and Operation Logs
- SKU: Batch Edit by Product or SKU Serial

> **Product Recycle Management**

- Paginated Recycle Product List
- Restore Recycled Product

#### Promotion Management

> **Flash Sale Management**
- Flash Sale List
- Activate/Deactivate Flash Sale
- Set Flash Sale Products
- Add/Edit/Delete Flash Sale

> **Coupon Management**
- Coupon List
- Add/Edit/Delete Coupon
- View Coupon Logs

> **Activity Management**
- Activity List
- Add/Edit/Delete Activity
- Activate/Deactivate Activity
- Publish to Ads

> **Home Recommendation**
- Brand Recommendation: List, Recommend Toggle, Sort, Delete, Add Multiple Brands
- New Products: List, Recommend Toggle, Sort, Delete, Add Multiple Products
- Popular Products: List, Recommend Toggle, Sort, Delete, Add Multiple Products
- Featured Topics: List, Recommend Toggle, Sort, Delete, Add Multiple Topics
- Ad Management: List, On/Off, Sort, Delete, Add/Edit Ad

#### Content Management

> **Subject Management**
- Subject List: View, Delete, Recommend Subject
- Add/Edit Subject: Choose Category, Add/Delete Related Products
- Subject Category Management: Toggle Display, Sort, Edit/Delete Category

> **Preferred Topics**
- Preferred List: Toggle Display, Sort, Delete
- Add/Edit Preferred: Relate/Delete Products

> **Topic Management**
- Subject List: View, Delete, Hot Topics
- Topic Category Management: Toggle Display, Sort, Edit/Delete Category

> **Help Management**
- Help List: View, Delete, Toggle Display
- Add/Edit Help: Choose Category
- Help Category Management: Toggle Display, Sort, Edit/Delete Category

#### User Management

> **User Management**
- User List: Enable, Delete, Bulk Send SMS
- Batch Operations: Bulk SMS, Site Messaging, Push, Set Tag, Give Coupon
- View/Edit User Info: User Details (Stats, Addresses, Orders), Edit Data, Login Logs
- Purchasing Power Filter: Recent Spending, Order Count, Total Spend, Avg. Order, Categories, Member Level, User Tag
- User Tag Management: List, Add, Edit, Delete
- Member Level Setup: List, Add, Edit, Set Default

> **Growth Value & Points**
- Growth Value and Points Query: List, Details, Modify Values
- Task Rewards: New User Tasks, Daily Tasks
- More Rules: Growth Value Rules, Points Rules, Points Spend Settings

#### Order Management

> **Order List**
- Order Search: Number, Receiver Name/Number, Status, Category, Source, Submit Time
- Order Actions: View, Close, Ship, Track, Delete
- Batch Actions: Batch Ship, Close, Delete

> **View Order**
- Order Status: Submit, Pay, Ship, Confirm Receipt, Complete Review
- Order Actions: Modify Invoice, Modify Receiver, Edit Items, Edit Costs, Send Site Message, Close Order, Remark, Cancel, Track, Delete
- Basic Info: Order, Discount, User Info
- Invoice Info: Type, Title, Content, Receiver Info
- Receiver Info: Name, Phone, Zip, Address
- Item Info: All Item Basic Info
- Cost Info: Total & Discounts
- Operation Info: Status Change Logs

> **Order Setup**
- Flash Sale Timeout
- Normal Order Timeout
- Order Auto Complete Time
- Auto End Transaction Time
- Auto Review Time

> **Return Request Processing**
- Return Request Search: Service Number, Receiver Name/Number, Status, Apply Time, Operator, Handle Time
- Batch Delete
- View Details: Return Items, Service Info, Confirm/Reject Return, Confirm Receipt

> **Return Reason Setup**
- Reason List: Type, Sort, Is Enabled, Add Time
- Add/Edit Reasons: as above
- Batch Delete

#### Permission Management ✔

> **Permission Management**
- Add/Delete/Edit Permission, Return Permission as Tree
- Role Management: Add/Delete/Edit/List Roles, Get/Set Permissions by Role
- Member Management: Add/Edit/Delete/List Members, Assign Role, Get Member Role, Assign/Revoke Permissions, Get Permission List

Role | Menu
----|----
Admin | All Menu Permissions
Operations | Home, User, Promotion, Operations, Content
Finance | Home, Stats, Finance
Designer | Home, Product
Customer Service | Home, Product, Order

### Portal Features

#### Product Search ✔

> **Comprehensive Search**
- Search by Title, Subtitle, Keywords
- Filter: Aggregate Results if Category not selected, choose most frequent, filter fields after category select
- Sort: Newest, Sales, Price
- Search Result Fields: ID, Image, Name, Subtitle, Price, Sales, New, Params, Brand, Category
- API: Import/Insert/Update to ES from DB, Delete API
- Brand/Category/Attribute Filtering by Aggregated Results

> **Product Recommendation**
- Recommend related by brand, category, name, keyword, subtitle (configurable quantities)
- Recommendations based on weekly browsing or search history

> **Hot Search**
- Aggregate user search history for top terms

> **Search Suggestion**
- Aggregate user search history for suggestion words

#### Shopping Flow ✔

> **Cart**
- Add Product to Cart
- Cart List: Main Image, Name, Qty, Spec
- Edit Cart Qty
- Re-select Spec
- Delete Cart Item

> **Create Order**
- Generate Order Confirm: Shipping, Item, Price, Invoice, Payment Method
- Choose Shipping Address: Default Address
- Choose Coupons & Points: Show Usable & Unusable
- Calculate Price: Total, Shipping, Coupon Discount, Points Discount, Promotion Discount
- Choose Payment Method: Online & COD
- Calculate Payable: Total + Shipping - Coupon - Points - Promo

> **Submit Order**
- Convert Confirm Info to Order
- Remove Relevant Cart Items
- Add Order & Lock Inventory
- Online Payment Choices: Alipay, WeChat, UnionPay, ApplePay

> **Pay Order**
- Change status to "Paid"; Deduct Inventory

> **Cancel Order (Unpaid)**
- Auto-cancel unpaid after timeout, unlock inventory, return coupon & points

#### Member Module (My Account) ✔

> **My Follows**
- Followed Brand List: Logo, Name, Address, Fans
- Unfollow
- List of Favorites

> **My Collections**
- Collected Products: Main Image, Name, Highlight, Price, Find Similar
- Collected Subjects: Image, Title, Subtitle, Favorite, Views, Comments
- Collected Topics: Image, Title, Subtitle, Favorite, Views, Comments

> **My Footprints**
- Browsed Products: Image, Name, Highlight, Price, Find Similar
- Remove Record
- View Browsing List

> **Member Login/Register**
- Login: HTTPS Login
- Register: Username, Password, Phone, SMS Code
- Get Verification Code: Backend generates, code bound to phone
- Forgot Password: Phone, SMS Code, New Password
- Logout
