# Authserver

This is an implememtation of Oauth2 authorization server in spring boot 

With this example you can obtain AccessToken and RefreshToken to use to secure your own APIs and provide user authorization to access your web services.

In this Example I used Inmemory client the user has only username and password for the porpuse of demonstration,
if you need to change anything please fork the repository


## Example for saving the user

 POST localhost:8088/service/oauth/token

### Authorization Basic Auth

  Username [client_id]
  Password [client_secret]

### Body raw(json)
  {
    "username": "username",
    "password": "password"
  }


## Example for getting access token 

  POST localhost:8088/service/oauth/token

### Authorization Basic Auth

  Username [client_id]
  
  Password [client_secret]
  
### Body urlencoded

  grant_type [password]
  
  username [username]
  
  password [user password]


  
