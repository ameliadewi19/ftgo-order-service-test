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
### Penambahan Order
1. Penambahan data order dengan consumer id dan restaurant id nya ada pada database.
Berikut adalah test nya:

| Scenario      | Penambahan data order dengan consumer id dan restaurant id nya ada pada database |
|:--------------|:---------------------------------------------------------------------------------|
| **Preconditions** | Data restoran dan consumer yang akan digunakan sudah terdaftar.                   | 
| **Steps To Execute**| 1. Mengakses Swagger UI pada localhost:8082/orders/index.html<br>2. Klik order-controller<br>3. Klik POST /orders<br>4. Klik Try it Out<br>5. Masukkan test data pada request body (lihat bagian Test Data di bawah)<br>6. Klik Execute |
| **Test Data**| Lihat contoh JSON di bawah. |
| **Expected Result**| Pass |
| **Actual Result**| Pass |
| **Test Result**| PASS |

**Test Data**  
```json
{
  "consumerId": 100,
  "deliveryAddress": {
    "city": "bandung",
    "state": "indonesia",
    "street1": "ciwaruga",
    "street2": "polban",
    "zip": "12345"
  },
  "deliveryTime": "2024-04-05T07:59:41.408Z",
  "lineItems": [
    {
      "menuItemId": "001",
      "quantity": "1"
    },
    {
      "menuItemId": "002",
      "quantity": "2"
    },
    {
      "menuItemId": "003",
      "quantity": "1"
    },
    {
      "menuItemId": "004",
      "quantity": "2"
    },
    {
      "menuItemId": "005",
      "quantity": "1"
    }
  ],
  "restaurantId": 3
}
