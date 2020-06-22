# Open Roulette

Allow change status to Open to a specific roulette

**URL** : `/api/roulette/{id}/open`

**Method** : `PUT`

**Data constraints** : NONE

**Header constraints** : NONE

**Data examples** : NO BODY

## Success Responses

**Condition** : The Roulette with {id} exists

**Code** : `200 OK`

**Content example** : NO DATA

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

* This api endpoint corresponding to the number two (2) endpoint of masivian test - Open Roulette
