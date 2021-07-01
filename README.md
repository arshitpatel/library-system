# library-system
Provide API Support for library system


How to RUN in local
First way through mvn build
Clone this repository and build using command mvn clean install
Run this project as Application or run App.java class
server will start on port 8090. will configurable in App.java file.
Second way through jar
I have checked in jar also. So we can run directly using jar.
download this jar and run below command
java -jar library-system 0.0.1-SNAPSHOT.jar

this will start server at port 8090
API Info



For example :

```
curl -X POST \
  localhost:8090/user/register?name=Arshit&contact=123
Sample Output 200
{
    "uId": 4,
    "name": "Arshit",
    "contactNo": "123",
    "depositedAmount": 100,
    "ttalDue": 0
}

```

```
curl -X GET \
localhost:8090/user/3

{
    "uId": 4,
    "name": "Arshit",
    "contactNo": "123",
    "depositedAmount": 100,
    "ttalDue": 0
}

```

```
curl -X PUT \
localhost:8090/rent/item/1?uid=0

{
    "userId": 0,
    "itemId": 1,
    "rentedTime": "2021-07-01T09:05:44.490+0000",
    "dueForItem": 0,
    "dueDate": "2021-07-08T09:05:44.490+0000"
}


```

