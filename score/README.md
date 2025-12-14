# Player Scores Tapir Starter

- Serveur HTTP en Scala
- Utilise *Cats Effect*, *Http4s* et *Tapir*.  

## Si on veut juste tester :
```bash
sbt clean compile
sbt test
```

## Si on vraiment run et GET & POST

```bash
sbt clean compile
sbt run
```

### GET `/scores`
Retourne la liste des scores actuellement stockés en mémoire

### POST `/scores`
Permet d’ajouter un nouveau score
Body JSON attendu :
```json
{
  "player": "alex",
  "score": 1200,
  "difficulty": "hard"
}

### DELETE `/scores`
supprime tous les scores stockés en mémoire
utile pour repartir a zero lors des tests

```