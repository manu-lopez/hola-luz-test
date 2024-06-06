### ONEFEES_TECH_TEST

### Compilamos dockerfile
`docker build -t hola-luz-test .`

### Ejecutamos contenedor
`docker run --volume=.\CSV_GENERATED:/app/CSV_GENERATED hola-luz-test`