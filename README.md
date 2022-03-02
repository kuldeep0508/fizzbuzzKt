# fizzbuzzKt
This is kotlin spring boot app solution of [fizz buzz problem](https://en.wikipedia.org/wiki/Fizz_buzz). 

**This solution is more focused at enterprise level.**

# Usage

This app exposes an endpoint `/api/fizz-buzz` which use request params
1. `input` : **MANDATORY PARAM** | User has to provide the number for which he/she wants to generate fizz-buzz. Sample value: 100
2. `type` : **OPTIONAL PARAM** | This param will be used to choose what type solution we want for fizz-buzz problem. This has been kept for future perspective.

For now this endpoint has basic protection which is configured in the code it-self.
`Base64(user:password)`

_SAMPLE REQUEST_

```curl
curl --location --request GET 'http://localhost:80/api/fizz-buzz?input=100&type=random' \
--header 'cache-control: no-cache' \
--header 'content-type: application/json' \
--header 'postman-token: 66b501f4-8ee0-c79f-2622-59fc714c2d19' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA=='
```

_SAMPLE RESPONSE_

```json
[
    1,
    2,
    "Fizz",
    4,
    "Buzz",
    "Fizz",
    7,
    8,
    "Fizz",
    "Buzz",
    11,
    "Fizz",
    13,
    14,
    "FizzBuzz"
]
```
### run via cli using jar

Follow below instructions:
1. run gradle build command
```
./gradlew clean build
```

2. Execute java command

```
java -jar .\build\libs\fizzbuzz-0.0.1-SNAPSHOT.jar
```

### run via docker

Run below commands:
1. Pull the image 

```
docker pull kuldeep0508/fizz-buzz-kt:latest
```

2. Run the image using below commands which is doing port forwarding too `9081:80`. 

```
docker run -p9081:80 kuldeep0508/fizz-buzz-kt:latest
```

**NOTE**: spring boot is getting up at `80`


After the app is up via any of the method then execute curl script using any of client (I have used `Postman`).

<img src="./docs/images/Postaman_fizz_buzz_screenshot.png">