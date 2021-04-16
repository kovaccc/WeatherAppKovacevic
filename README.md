# WeatherAppKovacevic - Weather forecast application
WeatherAppKovacevic is  android application that enables viewing forecasts of cities all over the world.

## About

Android project that has it's own API that allows communication of the application and Weather API available on the web server. The API is based on the REST architecture and it is using Retrofit and OkHttpClient with method GET to get response from service. The results retrieved are structured in a **JSON** transport format.

**Android version 30.0.3**
## Features
The android app lets you: 
 - Get weather from REST API 
 - Search for the city for which you want to view the forecast
 - Get error messages in case of unsuccessful response

## Tech-stack
The project seeks to use recommended practices and libraries in Android development. 
 - MVVM architecture (Viewmodel + LiveData)
 - Data Binding
 - Hilt dependency injection 
 - Retrofit2
 - OkHttp3
 - Gson
 - ...

## Screenshots
![image](https://user-images.githubusercontent.com/75457058/115037023-54515500-9ece-11eb-8363-450805194740.png)
![image](https://user-images.githubusercontent.com/75457058/115037056-5ca99000-9ece-11eb-9f0d-cfdbc29e3870.png)

## Permissions

WheatherAppKovacevic requires the following permissions in AndroidManifest.xml: 

-  Internet permission is used for getting response from web service

## Setup
1. Clone the repository
```
https://github.com/kovaccc/WheatherAppKovacevic.git
```
2. Open the project with your IDE/Code Editor
3. Run it on simulator or real Android device 
