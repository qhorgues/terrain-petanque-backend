Le backend utilise mariadb.

Pour lancer le backend, va falloir crée un utilisateur :

```SQL
CREATE USER 'terrain_petanque'@'localhost' IDENTIFIED BY 'password-group1';
CREATE DATABASE terrain_petanque;
GRANT INSERT, SELECT, UPDATE, DELETE ON terrain_petanque.* TO 'terrain_petanque'@'localhost';
FLUSH PRIVILEGES;
```

Pour les endpoints :

Utilisateur : `http://localhost:8081/api/v1/users`
Terrain : `http://localhost:8081/api/v1/courts`
Reservation : `http/localhost:8081/api/v1/reservations`

Les DTO d'entrées :

Utilisateur :
```JSON
{
  "name": "Nom",
  "surname": "Prénom",
  "mail": "nom.prenom@test.com", 
  "password": "test", "username": 
  "Prénom Nom" 
}
```

Terrain : 
```JSON
{
  "name": "Nom",
  "description": "Je suis un terrain",
  "quantity": 5,
  "coordinates": {
    "latitude": 50.0,
    "longitude": 10.0
  }
}
```

Reservations :
```JSON
{
  "reservation": 3
}
```
