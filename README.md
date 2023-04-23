# API REST with Hateoas

Il s'agit d'un exemple basique d'une API REST pour la gestion des employés d'une société X. Les informations sont stockées dans une base de données H2.
L'API implémente les opérations CRUD avec la base de données et dispose des fonctions de l'Hypermedia HATEOS.


## Installation
L'API n'est pas fournit en un fichier d'installation. Il s'agit simplement  d'un dossier à télécharger et à importer dans votre IDE préféré.

## Contrat
Cette section décrit la manière de communiquer et d'interagir avec l'API.

### Récupération de tous les employés
```
Request
  URI: http://localhost:9001/
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if all employees are successfully retrieved
    404 NOT FOUND if Employee cannot be found
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "_embedded": {
            "employeeList": [
                {
                    "id": 1,
                    "firstName": "Colleen ",
                    "lastName": "Myers",
                    "salary": "$1000",
                    "_links": {
                        "self": [
                            {
                                "href": "http://localhost:9001/1",
                                "title": "reading"
                            },
                            {
                                "href": "http://localhost:9001/update/1",
                                "title": "updating"
                            },
                            {
                                "href": "http://localhost:9001/delete/1",
                                "title": "deleting"
                            }
                        ],
                        "employees": {
                            "href": "http://localhost:9001/"
                        }
                    }
                },
                {
                    "id": 2,
                    "firstName": "Monica ",
                    "lastName": "Webb",
                    "salary": "$1100",
                    "_links": {
                        "self": [
                            {
                                "href": "http://localhost:9001/2",
                                "title": "reading"
                            },
                            {
                                "href": "http://localhost:9001/update/2",
                                "title": "updating"
                            },
                            {
                                "href": "http://localhost:9001/delete/2",
                                "title": "deleting"
                            }
                        ],
                        "employees": {
                            "href": "http://localhost:9001/"
                        }
                    }
                }
            ]
        },
        "_links": {
            "self": {
                "href": "http://localhost:9001/"
            }
        }
    }
```

### Récupération d'un employé
```
Request
  URI: http://localhost:9001/{id}
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if the Employee was successfully retrieved
    404 NOT FOUND if Employee cannot be found
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 1,
        "firstName": "Colleen ",
        "lastName": "Myers",
        "salary": "$1000",
        "_links": {
            "self": [
                {
                    "href": "http://localhost:9001/1",
                    "title": "reading"
                },
                {
                    "href": "http://localhost:9001/update/1",
                    "title": "updating"
                },
                {
                    "href": "http://localhost:9001/delete/1",
                    "title": "deleting"
                }
            ],
            "employees": {
                "href": "http://localhost:9001/"
            }
        }
    }
```
### Ajout d'un employé
```
Request
  URI: http://localhost:9001/
  HTTP Verb: POST
  Body: 
    {
        "firstName": "Sarah",
        "lastName": "Hant",
        "salary": "$4500"
    }

Response:
  HTTP Status:
    201 CREATED The request has been fulfilled and a new employee being created.
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 5,
        "firstName": "Sarah",
        "lastName": "Hant",
        "salary": "$4500",
        "_links": {
            "self": [
                {
                    "href": "http://localhost:9001/5",
                    "title": "reading"
                },
                {
                    "href": "http://localhost:9001/update/5",
                    "title": "updating"
                },
                {
                    "href": "http://localhost:9001/delete/5",
                    "title": "deleting"
                }
            ],
            "employees": {
                "href": "http://localhost:9001/"
            }
        }
    }
```
### Modification d'un employé
```
Request
  URI: http://localhost:9001/update/{id}
  HTTP Verb: PUT
  Body: 
    {
        "firstName": "Sarah",
        "lastName": "Hant",
        "salary": "$6300"
    }

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if Employee cannot be found 
```
### Suppression d'un employé
```
Request
  URI: http://localhost:9001/delete/{id}
  HTTP Verb: DELETE
  Body: Empty

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if Employee cannot be found
```

