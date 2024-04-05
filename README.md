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
   a. Merubah data menu order yang menu id nya tidak ada pada database
   b. Merubah data order dengan id ordernya tidak ada pada database
### Pembatalan Order
1. Pembatalan order dengan order id nya ada di database
2. Pembatalan order dengan order id nya tidak ada di database

## Pengujian 
- Data order dengan consumer id dan restaurant id nya ada pada database
Create consumer: POST /consumers
Precondition
Data Consumer
{
  "name": {
    "firstName": "Asep",
    "lastName": "Putra"
  }
}

Data Restoran
{
  "address": {
    "city": "Cimahi",
    "state": "Indonesia",
    "street1": "Jl. Maharmatatilaar",
    "street2": "Jl. Maha",
    "zip": "40156"
  },
  "menu": {
    "menuItems": [
      {
        "id": "1",
        "name": "Nasi Goreng Seafood",
        "price": "35.00"
      },
      {
        "id": "2",
        "name": "Bubur Ayam Special",
        "price": "22.00"
      }
    ]
  },
  "name": "DKResto"
}


Create Order : POST /orders
Data Test:
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
      "menuItemId": "1",
      "quantity": 2
    }
  ],
  "restaurantId": 1
}

Expected Result
{
  "orderId": 1
}

Actual Result


Melihat order : GET orders/1
Data Test
orderId : 1
Expected Result
{
  "orderId": 1,
  "orderTotal": 44.00,
  "state": "APPROVED"
}

Actual Result
![image](https://github.com/ameliadewi19/ftgo-order-service-test/assets/95133748/bea24cf7-84a7-423e-838b-c2dc3e1d5075)

