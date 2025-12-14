# Player Scores Tapir Starter

- Serveur HTTP en Scala
- Utilise *Cats Effect*, *Http4s* et *Tapir*.  

## Si on veut juste tester :
```bash
sdt clean compile
sdt test
```

## Si on vraiment run et GET & POST

```bash
sdt clean compile
sdt run
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

```