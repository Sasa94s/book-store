# API Documentation
> Postman Collection is available as [JSON](./src/main/resources/Auth-App.postman_collection.json) for view/download.

## Create User

Creates User account if the username does not exist, and password complexity is achieved.

Endpoint:
`POST` `/api/user/create`
### Sample Request Body
```json
{
  "username": "Sasa94s",
  "password": "passw0rD!",
  "confirmPassword": "passw0rD!"
}
```
### Sample Response Body
```json
{
    "id": 1,
    "username": "Sasa94s",
    "password": "$2a$10$Y2.R/jdeiG61tLnq5zmPEOFyaiyv.z5TlLOVvbfNIOXvu2bX7xM/y"
}
```

## Login User

Authenticates User according to a valid registered username and password. 

Endpoint:
`POST` `/api/user/login`
### Sample Request Body
```json
{
  "username": "Sasa94s",
  "password": "passw0rD!"
}
```
### Sample Response Header
```
"Authorization": Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTYXNhOTRzIiwiZXhwIjoxNjMyNDM4MDk5fQ.HK4mAxhF-1DBTGITnTCPd9LpwyY7W9wYdeuNNWUWh40k3a4xR8q97SzmNHSxjYT76oJazFmQZiGdCcavY0SlUw
```


## Get User by ID

Retrieves User information by ID

Endpoint:
`GET` `/api/user/id/{id}`
### Sample Response Body
```json
{
  "id": 1,
  "username": "Sasa94s",
  "password": "$2a$10$Y2.R/jdeiG61tLnq5zmPEOFyaiyv.z5TlLOVvbfNIOXvu2bX7xM/y"
}
```

## Get User by Username

Retrieves User information by ID

Endpoint:
`GET` `/api/user/username/{username}`
### Sample Response Body
```json
{
  "id": 1,
  "username": "Sasa94s",
  "password": "$2a$10$Y2.R/jdeiG61tLnq5zmPEOFyaiyv.z5TlLOVvbfNIOXvu2bX7xM/y"
}
```


