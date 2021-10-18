# COMP6461_Lab_Assignment_1
COMP6461 – Fall 2021 
Computer Networks & Protocols  
Lab Assignment # 1 

Run the below commands to test the application in console

httpc -t 'http://google.com'
httpc -v 'http://httpbin.org/get?course=networking&assignment=1' -o 6461.txt
httpc get -r 'https://httpbingo.org/redirect-to?url=http://www.example.com'
httpc get -v 'http://httpbin.org/get?course=networking&assignment=1'
httpc get 'http://httpbin.org/get?course=networking&assignment=1'
httpc post -h Content-Type:application/json --d '{"Assignment": 1}' http://httpbin.org/post