
# <img align="center" alt="Java" height="80" width="100" src="https://pngimg.com/uploads/parking/parking_PNG71.png"> Api Parking

## Versão Graphql:

 - Sem relatório momentâneamente

Utilize o playground para testar as queries e mutations. <br />
clique no link abaixo:
## [Graphiql Playground aqui](https://parkinggraphql-production.up.railway.app/graphiql) <br />


##### ***Queries:***
```graphql
  accessControls: [AccessControl]
  findByVehiclePlate(vehiclePlate: String): AccessControl
  establishmentById(id: ID): Establishment
  establishments: [Establishment]
  vehicleById(id: ID): Vehicle
  vehicles: [Vehicle]
```

##### ***Mutations:***
```graphql
- Access Control
registerEntry(plate: String, type: VehicleType,establishmentId: ID): AccessControl
registerExit(plate: String): AccessControl
createAccessControl(establishmentId: ID): AccessControl

- Establishment
addEstablishment(establishmentInput: EstablishmentInput): Establishment
updateEstablishment(establishmentId: ID, establishmentInput: EstablishmentInput): Establishment
deleteEstablishment(establishmentId: ID): Establishment
inactiveEstablishment(establishmentId: ID): Establishment

- Vehicle
addVehicle(vehicleInput: VehicleInput): Vehicle
updateVehicle(vehicleId: ID,vehicleInput: VehicleInput): Vehicle
deleteVehicle(vehicleId: ID): Vehicle
inactiveVehicle(vehicleId: ID): Vehicle
```
### ***Tecnologias utilizadas:***
- Linguagem Java  <br />
- Framework Spring
- Postgres  <br />
- Deploy: Railway <br />


<div style="display: inline_block">
   <img align="center" alt="Java" height="70" width="40" src="https://seeklogo.com/images/J/java-logo-7833D1D21A-seeklogo.com.png">
   <img align="center" alt="Spring" height="40" width="40" src="https://github.com/harrissondutra/harrissondutra/blob/main/.img/logo-spring.png">
   <img align="center" alt="Postgres" height="40" width="40" src="https://github.com/harrissondutra/harrissondutra/blob/main/.img/postgresql_logo_icon_170835.png">
   <img align="center" alt="Railway" height="50" width="50" src="https://images.crunchbase.com/image/upload/c_pad,f_auto,q_auto:eco,dpr_1/h3m0hmstlq9maq7t8tyc">
</div>


