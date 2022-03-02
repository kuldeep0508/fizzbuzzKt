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

