# ftgo-order-service-test
Repositori ini merupakan skenario test dan juga pengujian yang dilakukan pada aplikasi ftgo untuk memenuhi tugas mata kuliah PPLBO

## Team Member
1. Amelia Dewi Agustiani | 211524002
2. Dafa Nurul Fauziansyah | 211524006
3. Salsabila Maharani Putri | 211524026

## Scenario Test
### Penambahan Order
1. Data order dengan consumer id dan restaurant id nya ada pada database
2. Data order dengan consumer id nya tidak ada pada database
3. Data order dengan restaurant id nya tidak ada pada database
4. Data order dengan consumer id dan restaurant id tidak ada pada database
5. Data order dengan tidak lengkap fieldnya
6. Data order dengan tidak sesuai value dengan jenis datanya
### Perubahan Order 
1. Merubah data order dengan id ordernya ada pada database
2. Merubah data menu order yang menu id nya ada pada database
   - Merubah data menu order yang menu id nya tidak ada pada database
   - Merubah data order dengan id ordernya tidak ada pada database
### Pembatalan Order
1. Pembatalan order dengan order id nya ada di database
2. Pembatalan order dengan order id nya tidak ada di database
### Melihat Order
1. Melihat order approved
4. Melihat order yang id nya tidak ada di database

## Pengujian 
### 1. Penambahan data order dengan consumer id dan restaurant id nya ada pada database
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan consumer id dan restaurant id nya ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran dan consumer yang akan digunakan sudah terdaftar.                   | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Data order tersimpan dalam database.<br>Result: <br>{ "orderId": 1 } |
| **Actual Result** | Data order tersimpan dalam database.<br>Result: <br>{ "orderId": 1 } |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/63079505-bd07-43b4-aa47-295d8fa2ff18) |  

**Test Data**  
```json
{
  "consumerId": 1,
  "deliveryAddress": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "2",
      "quantity": 2
    }
  ],
  "restaurantId": 1
}
```

### 2. Penambahan data order dengan consumer id nya tidak ada pada database
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan consumer id nya tidak ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Consumer not found with id 0” |
| **Actual Result** | Order ter-create, menampilkan kode response 200.<br>Result: <br>{ "orderId": 2 } |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/ccfcc524-0a23-4536-a93d-35b6e7d96491) |  

**Test Data**  
```json
{
  "consumerId": 0,
  "deliveryAddress": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "1",
      "quantity": 2
    }
  ],
  "restaurantId": 1
}
```

### 3. Penambahan data order dengan restaurant id nya tidak ada pada database
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan restaurant id nya tidak ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran dan consumer yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Restaurant not found with id 0”. |
| **Actual Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Restaurant not found with id 0”. |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/b9a1602d-ce30-4f67-b83b-5297c3b7bc8c) |  

**Test Data**  
```json
{
  "consumerId": 1,
  "deliveryAddress": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "2",
      "quantity": 2
    }
  ],
  "restaurantId": 0
}
```

### 4. Penambahan data order dengan consumer id dan restaurant id tidak ada pada database
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan consumer id dan restaurant id tidak ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | - | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Customer not found with id 0. Restaurant not found with id 0”. |
| **Actual Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Restaurant not found with id 0”.|
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/5ef8f8c1-1959-4067-b884-6a510a668394) |  

**Test Data**  
```json
{
"consumerId": 0,
  "deliveryAddress": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "1",
      "quantity": 2
    }
  ],
  "restaurantId": 0
}
```

### 5. Penambahan data order dengan tidak lengkap fieldnya 
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan tidak lengkap fieldnya |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran dan consumer yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Quantity of menu must be more than 0” |
| **Actual Result** | Order ter-create, menampilkan kode response 200.<br>Result: <br>{ "orderId": 4 } |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/a1779b3d-3e39-466f-ab13-f7aa805292ab) |  

**Test Data**  
```json
{
  "consumerId": 1,
  "deliveryAddress": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "1"
    }
  ],
  "restaurantId": 1
}
```

### 6. Penambahan data order dengan tidak sesuai value dengan jenis datanya 
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan tidak sesuai value dengan jenis datanya |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran dan consumer yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak ter-create, menampilkan kode response 500 dengan message error “Address must be string” |
| **Actual Result** | Order ter-create, menampilkan kode response 200.<br>Result: <br>{ "orderId": 5 } |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/aacf3142-bca1-4655-b475-5d8b729b455f) |  

**Test Data**  
```json
{
  "consumerId": 1,
  "deliveryAddress": {
    "city": 123,
    "state": "Indonesia",
    "street1": "Jl Sangkuriang Barat 2",
    "street2": "string",
    "zip": "40511"
  },
  "deliveryTime": "2024-04-05T07:31:02.414Z",
  "lineItems": [
    {
      "menuItemId": "1",
      "quantity": 3
    }
  ],
  "restaurantId": 1
}
```

### 7. Merubah data menu order yang menu id nya ada pada database 
Berikut adalah test nya:

| Scenario      | Merubah data menu order yang menu id nya ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order dan menu yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /order/{orderId}/revise<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | {<br>  "orderId": 1,<br>  "state": "APPROVED",<br>  "orderTotal": "66.00"<br>} |
| **Actual Result** | {<br>  "orderId": 1,<br>  "state": "APPROVED",<br>  "orderTotal": "44.00"<br>} |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/27f6fcd5-c5ae-46c6-a4c7-b2fb824ef72f) |  

**Test Data**  
orderId = 1   
```json
{
  "revisedOrderLineItems": [
    {
      "menuItemId": "2",
      "quantity": 3
    }
  ]
}
```

### 8. Merubah data menu order yang menu id nya tidak ada pada database 
Berikut adalah test nya:

| Scenario      | Merubah data menu order yang menu id nya tidak ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /order/{orderId}/revise<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Order tidak berhasil dirubah, menampilkan kode response 500 dengan message error “Menu not found with id 4” |
| **Actual Result** | {<br>  "orderId": 1,<br>  "state": "APPROVED",<br>  "orderTotal": "44.00"<br>} |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/9dfb9132-f628-473e-8961-0063678f40cf) |  

**Test Data**  
orderId = 1   
```json
{
  "revisedOrderLineItems": [
    {
      "menuItemId": "4",
      "quantity": 3
    }
  ]
}
```

### 9. Merubah data order dengan id ordernya tidak ada pada database 
Berikut adalah test nya:

| Scenario      | Merubah data order dengan id ordernya tidak ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | - | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /order/{orderId}/revise<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Menampilkan kode response 404 |
| **Actual Result** | Menampilkan kode response 404 |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/d1ba3a6d-4e2b-4f3f-923c-4d0fb4d6eca7) |  

**Test Data**  
orderId = 10
```json
{
  "revisedOrderLineItems": [
    {
      "menuItemId": "4",
      "quantity": 3
    }
  ]
}
```

### 10. Pembatalan order dengan order id nya ada di database  
Berikut adalah test nya:

| Scenario      | Pembatalan order dengan order id nya ada di database  |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /order/{orderId}/cancel<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | {<br>  "orderId": 5,<br>  "state": "CANCELLED",<br>  "orderTotal": "105.00"<br>} |
| **Actual Result** | {<br>  "orderId": 5,<br>  "state": "APPROVED",<br>  "orderTotal": "105.00"<br>} |
| **Test Result** | FAIL |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/b0eb4ea6-bbc8-4488-a598-b46b81f7099e) |  

**Test Data**  
orderId = 5

### 11. Pembatalan order dengan order id nya tidak ada di database  
Berikut adalah test nya:

| Scenario      | Pembatalan order dengan order id nya tidak ada di database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /order/{orderId}/cancel<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Expected Result** | Menampilkan kode response 404 |
| **Actual Result** | Menampilkan kode response 404 |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/8a47c859-c4b4-4531-bdd1-97c41faf2fb1) |  

**Test Data**  
orderId = 9

### 12. Melihat order approved   
Berikut adalah test nya:

| Scenario      | Melihat order approved |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik GET /orders/{orderId}<br>4. Klik Try it Out<br>5. Klik Execute |
| **Expected Result** | {<br>  "orderId": 1,<br>  "state": "APPROVED",<br>  "orderTotal": "44.00"<br>} |
| **Actual Result** | {<br>  "orderId": 1,<br>  "state": "APPROVED",<br>  "orderTotal": "44.00"<br>} |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/3f466469-0186-4b72-b3f0-a143f7d8232e) |  

**Test Data**  
orderId = 1

### 13. Melihat order yang id nya tidak ada di database
Berikut adalah test nya:

| Scenario      | Melihat order approved |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data order yang akan digunakan sudah terdaftar. | 
| **Steps To Execute** | 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik GET /orders/{orderId}<br>4. Klik Try it Out<br>5. Klik Execute |
| **Expected Result** | Menampilkan kode response 404 |
| **Actual Result** | Menampilkan kode response 404 |
| **Test Result** | PASS |
| **Screenshot** | ![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/87d931fd-d3e7-4c9b-872e-aacb60d2bfbc) |  

**Test Data**  
orderId = 20
