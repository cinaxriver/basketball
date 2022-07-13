### basketball


graphql query console:
http://localhost:8080/graphiql

### list players

```
query {
  allPlayers {
    name,
    surname,
    position
  }
}
```

### delete player
```
mutation {
  delete(id: 1) {
    name,
    position
  }
}
```

### create player
```
mutation {
  create(input: {name: "eritis", surname: "sicut", position: PG}) {
    id,
    name,
    position
  }
}
```



