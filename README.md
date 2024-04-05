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
