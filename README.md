# Prueba técnica Meep
El objetivo de la prueba es exponer un microservicio que obtenga, cada 30
segundos, los cambios que se han producido en la disponibilidad de vehículos, es
decir, que detecte nuevos vehículos disponibles y vehículos que dejen de estarlo.

Para obtener la información de los vehículos disponibles en cada momento se
usa el siguiente endpoint:
```
curl -X GET "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources?lowerLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-9.137115&companyZoneIds=545,467,473" -H "accept: application/json"
```
Destacar de esa llamada:
- obtiene los recursos (motos, bicis, paradas de bus, metro, etc.) que están
disponibles dentro de un marco geográfico, que viene definido por los
parámetros lowerLeftLatLon y upperRightLatLon dentro de la zona de
Lisboa.
- aplica el filtro `companyZoneIds=545,467,473` que devuelve datos sólo de
tres empresas de motosharing y carsharing que operan en Lisboa.


## Ejemplo
La llamada 1 al API de Meep retorna:
```
[
  "A",
  "B"
]
```

La llamada 2 al API de Meep retorna:
```
[
  "B",
  "C"
]
```

La solución implementada debería devolver algo como:
```
{
  added:[
    "C"
  ],
  removed: [
    "A"
  ]
}
```

## Preguntas  y respuestas

Te agradeceríamos que respondieras a las siguientes cuestiones:
- **¿Cómo de escalable es tu solución propuesta?**

Es relativamente escalable pero puede presentar ciertos retos. En primer lugar la persistencia debería hacerse en una base de datos en lugar de en memoria utilizando un esquema más o menos asi:

Base de datos relacional:
```text
Petición(parámetros) <== 1:n ==> Vehicle  // Para guardar los vehículos de la última petición
Petición(parámetros) <== 1:n ==> VehicleDiff()  // Para guardar los vehículos añadidos y eliminados (debería haber un flag que lo indique)
```
Quizá en este caso de uso concreto pueda funcionar bien una base de datos no relacional con el siguiente esquema de documento:
```text
Petición:
  params: String
  lastResult: [Vehicles]
  diff:{
    added:[Vehicles]
    removed:[Vehicles]
    updatedAt: Date
  }
```

La escalabilidad también presenta otro problema. Puede causar sobrecarga al lanzar varias llamadas a la vez al mismo API y requeriría de algún tipo de planificador o proceso que mire las llamadas pendientes cada x tiempo y, si es posible, dotar de algo de aleatoriedad a la generación de los tiempos de ejecución de la siguiente iteración (por parámetros). Es decir, que en lugar de ser 30 min fijos que pueda ser 30 min + tiempo aleatorio.

- **¿Qué problemas a futuro podría presentar? Si has detectado alguno, ¿qué
alternativas propones para solventar dichos problemas?**

Además de los presentados arriba relacionados con la escalabilidad diría que hay poca flexibilidad en la recogida de datos del API a la que se llama. Este problema podría solucionarse implementando una solución que separe más las capas y que no use el mismo DTO para recoger los datos del API y para almacenar la información. Para ello habría que mapear los resultados obtenidos en las llamadas a APIs en un objeto común con los datos que se quieran almacenar. En esta solución también vendría bien una base de datos no relacional basada en documentos.

