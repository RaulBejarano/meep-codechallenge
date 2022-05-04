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
