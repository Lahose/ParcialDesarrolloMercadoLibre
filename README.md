# Examen Mercado Libre
Este proyecto nos permite identificar si un humano es mutante o no mediante su secuencia de ADN. La API detecta si un humano es mutante o no analizando la matriz, y si esta encuentra más de una secuencia de cuatro letras iguales, ya sea de forma horizontal, oblicua o vertical, entonces es un mutante.

## Nivel 1
Este programa fue hecho con Java

## Nivel 2
API REST para detectar mutantes, en Render: https://parcialdesarrollomercadolibre.onrender.com/
- Endpoint: /mutant/
- Metodo: POST
- Formato del Body:
```
{ "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"] }
```

## Nivel 3
Devuelve un JSON con el conteo de mutantes y humanos verificados.
- Endpoint: /stats/
- Metodo: GET
- Formato de Respuesta:
```
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
```

## Ejemplos
Prueba Unitaria Mutante:
```
{ "dna": ["ACTG", "ACCG", "ACAT", ACGC"] }
```
Respuesta: "mutant": true

Prueba Unitaria No Mutante:
```
{ "dna": ["AAAC","AAAG","ACAG","TCCG"] }
```
Respuesta: "mutant": false

## Diagrama de Secuencia
![SecuenciaMercadoLibre](https://github.com/user-attachments/assets/28b6db03-8c12-42c3-9cf0-ee731beae077)

## Pruebas
Se usa Postman para realizar las pruebas. Para realizar las pruebas, se deben seguir los siguientes pasos:
1. Crear un POST y un GET
2. En el POST, se pega el siguiente enlace: http://localhost:8080/mutant. Luego, se ingresa uno de los ejemplos mencionados anteriormente o inventados por uno mismo y se verifica la respuesta.
3. En el GET, se pega el siguiente enlace: http://localhost:8080/stats. Esto nos devuelve un JSON con el conteo de mutantes y humanos verificados.
