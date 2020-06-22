# Make a Bet

Allow make a bet to a specific roulette

**URL** : `/api/roulette/{id}/bet`

**Method** : `POST`

**Data constraints**

```json
{
    "value" : "{1-10000}",
    "betType": "{Numero, Color}",
    "color": "{Negro, Rojo}",
    "number": "{0-36}"
}
```

Note that `value` and `number` are numeric fields and `betType` and `color` are choosable fields.

**Header constraints**

The method requires a header with user-id. Values passed in the `user-id` header has not validation checks:

```
user-id: [1 to n number]
```

**Data examples**

```json
{
    "value" : 6400,
    "betType": "color",
    "color": "rojo",
    "number": 0
}
```

## Success Responses

**Condition** : The Roulette with {id} exists

**Code** : `201 Created`

**Content example** : Responses the roulette bet information.

```json
{
    "id": "5ef08a7207238162ebecdd47",
    "value": 6400.0,
    "betType": "color",
    "color": "rojo",
    "number": 0
}
```

## Error Responses

**Condition** : If provided invalid bet body.

**Code** : `400 BAD REQUEST`

**Content example** :

```json
{
    "status": "BAD_REQUEST",
    "timestamp": "2020-06-22T10:41:57.236",
    "message": "Validation errors",
    "errors": [
        "color value is invalid, available values included { negro, rojo }",
        "betType value is invalid, available values included { numero, color }",
        "number max value = 36",
        "value max value = 10000"
    ]
}
```
---------------------------------------

**Condition** : If provided {id} does not exist

**Code** : `400 BAD REQUEST`

**Content example** :

```json
{
    "status": "BAD_REQUEST",
    "timestamp": "2020-06-22T10:24:39.256",
    "message": "Roulette with id 5ef0844b0723816s2ebecdd46 does not exist",
    "errors": [
        "Roulette with id 5ef0844b0723816s2ebecdd46 does not exist"
    ]
}
```
---------------------------------------

**Condition** : If provided {id} (roulette) is closed

**Code** : `400 BAD REQUEST`

**Content example** :

```json
{
    "status": "BAD_REQUEST",
    "timestamp": "2020-06-22T11:00:58.78",
    "message": "Roulette with id 5ef08f4d69c05262cd7d1a9a is closed, it must be open to bet",
    "errors": [
        "Roulette with id 5ef08f4d69c05262cd7d1a9a is closed, it must be open to bet"
    ]
}
```

## Notes

* This api endpoint corresponding to the number Three (3) endpoint of masivian test - Make a Bet
