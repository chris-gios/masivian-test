# Find All Roulettes

Allow to retrieve the list of all Roulettes with the status

**URL** : `/api/roulette`

**Method** : `GET`

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
        "id": "5ef0837d8c7d632616ebd66f",
        "open": false
    },
    {
        "id": "5ef0844b07238162ebecdd46",
        "open": true
    }
]
```

## Notes

* This api endpoint corresponding to the number five (5) endpoint of masivian test - Close Roulette
