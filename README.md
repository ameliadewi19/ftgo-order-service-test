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

## Pengujian 
### Penambahan Order
1. Data order dengan consumer id dan restaurant id nya ada pada database
   Create consumer: POST /consumers
   Data Consumer:
   ```
   {
      "name":
     {
      "firstName": "Asep",
      "lastName": "Putra"
     }
   }
   ```
