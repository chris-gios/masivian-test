# Close Roulette

Allow change close a specific roulette

**URL** : `/api/roulette/{id}/close`

**Method** : `PUT`

**Data constraints** : NONE

**Header constraints** : NONE

**Data examples** : NO BODY

## Success Responses

**Condition** : The Bets of the roulette with the provided {id}

**Code** : `201 Created`

**Content example** : Responses the bets List information.

```json
[
    {
        "id": "5ef0909e69c05262cd7d1a9c",
        "value": 10000.0,
        "betType": "colOR",
        "color": "ROJO",
        "number": 10
    },
    {
        "id": "5ef090ae69c05262cd7d1a9d",
        "value": 5000.0,
        "betType": "colOR",
        "color": "ROJO",
        "number": 15
    }
]
```

## Error Response

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

## Notes

* This api endpoint corresponding to the number four (4) endpoint of masivian test - Close Roulette
