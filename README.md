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
1. Penambahan data order dengan consumer id dan restaurant id nya ada pada database
| Scenario      | Test adding an order with invalid items (not existing in the database). |
| :----------- | :------------|
| **Preconditions** | 1. The FTGO application is deployed and running. | 
|              | 2. All microservices (consumer service, restaurant service, order service, kitchen service, accounting service, order history service, and API gateway) are operational.|
|              | 3. Necessary data such as consumers and menu items are available in the system. |
|              | 4. The restaurant ID used in this scenario exists in the database. |
|              | 4. Once the request body JSON is filled, click on the "Execute" button to send the request to the server. |
| **Step To Execute**     | 1. Open Swagger UI in localhost:8082/orders/index.html |
|              | 2. Look for the section where the request body JSON input in POST /orders section, then click Try it Out. |
|              | 3. Write the JSON in Test Data for creating an order. |
|              | 4. Once you've filled in the request body JSON, click on the "Execute" button to send the request to the server. |
| **Expected Result**| |
| **Actual Result**| |
| **Test Result**| PASS|

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
``` 
