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
2. Melihat order cancelled
3. Melihat order revised
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
