## About The Project

### COMP6461 – Fall 2021 - Data Communications & Computer Networks - Lab Assignment #1 

### Introduction 
In this assignment, a simple HTTP client application has been implemented and experimented it in real HTTP Servers (web servers). 
 
### Outline 
The following is a summary of the main tasks of the Assignment: 
1. Setup your development and testing environment. 
2. Study HTTP network protocol specifications. 
3. Build your own HTTP client library. 
4. Program your HTTP client application (curl command). 
5. (optional) Implement more HTTP protocol specifications. 
6. (optional) Enhance the functionalities of the HTTP client. 

### Run the below commands to test the application in console
 ```sh
httpc -t 'http://google.com'
```
 ```sh
httpc -v 'http://httpbin.org/get?course=networking&assignment=1' -o 6461.txt
```
 ```sh
httpc get -r 'https://httpbingo.org/redirect-to?url=http://www.example.com'
```
 ```sh
httpc get -v 'http://httpbin.org/get?course=networking&assignment=1'
```
 ```sh
httpc get 'http://httpbin.org/get?course=networking&assignment=1'
```
 ```sh
httpc post -h Content-Type:application/json --d '{"Assignment": 1}' http://httpbin.org/post
```