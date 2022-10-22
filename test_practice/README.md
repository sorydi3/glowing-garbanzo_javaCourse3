# How to run the Spring Boot application using gradle

1. Open a command prompt and navigate to the folder containing the pom.xml
2. Type the following command:
   gradle bootRun
3. Open your browser at http://localhost:8080

# REST API

The REST API to the example app is described below.

## Get all deliveries

### Request

`GET /deliveries`

    curl -i -H 'Accept: application/json' http://localhost:8080/deliveries

### Response

        HTTP/1.1 200 OK
        Content-Type: application/json;charset=UTF-8
        Transfer-Encoding: chunked
        Date: Fri, 15 Mar 2019 14:59:00 GMT

        [
        {
            "id": 1,
            "name": "John",
            "address": "123 Main St",
            "city": "Anytown",
            "state": "CA",
            "zip": "12345",
            "phone": "123-456-7890",
            "email": "

[...]  
 }
]

## Get a delivery

### Request

`GET /deliveries/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/deliveries/1

### Response

        HTTP/1.1 200 OK
        Content-Type: application/json;charset=UTF-8
        Transfer-Encoding: chunked
        Date: Fri, 15 Mar 2019 14:59:00 GMT

        {
            "id": 1,
            "name": "John",
            "address": "123 Main St",
            "city": "Anytown",
            "state": "CA",
            "zip": "12345",
            "phone": "123-456-7890",
            "email": "

[...]  
 }

## Get all flowers

### Request

`GET /flowers`

    curl -i -H 'Accept: application/json' http://localhost:8080/flowers

### Response

        HTTP/1.1 200 OK
        Content-Type: application/json;charset=UTF-8
        Transfer-Encoding: chunked
        Date: Fri, 15 Mar 2019 14:59:00 GMT

        [
        {
            "id": 1,
            "name": "Rose",
            "color": "Red",
            "price": 1.99
        },
        {
            "id": 2,
            "name": "Tulip",
            "color": "Yellow",
            "price": 1.99
        },
        {
            "id": 3,
            "name": "Daisy",
            "color": "White",
            "price": 1.99
        }
        ]

## Get a flower

### Request

`GET /flowers/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/flowers/1

### Response

        HTTP/1.1 200 OK
        Content-Type: application/json;charset=UTF-8
        Transfer-Encoding: chunked
        Date: Fri, 15 Mar 2019 14:59:00 GMT

        {
            "id": 1,
            "name": "Rose",
            "color": "Red",
            "price": 1.99
        }

# DATA MODEL

The data model for this application is as follows:

## DELIVERY

id: Long
name: String
address: String
city: String
state: String
zip: String
phone: String
email: String

## FLOWER

id: Long
name: String
color: String
price: Double

## SHRUB

id: Long
name: String
color: String
price: Double

# DATABASE

The database for this application is H2. The database is initialized with the following data:

# LICENSE

This application is licensed under the MIT License. See the LICENSE file for details.
