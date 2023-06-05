# lablecturaconsumo
Este repositorio contiene el código para un sistema de facturación implementado en Java. El sistema gestiona las lecturas de consumo para diferentes tipos de clientes y calcula sus respectivas facturas basadas en sus datos de consumo.

## Clase Lectura

La clase Lectura representa una lectura de consumo y tiene los siguientes atributos:

- suministro (int): El número de suministro asociado a la lectura.
- lecturaAnterior (LocalDate): La fecha de la lectura anterior.
- lecturaActual (LocalDate): La fecha de la lectura actual.
- consumoKWH (int): El consumo en kilovatios-hora.
- categoria (String): La categoría del cliente.

## Clase Cliente

La clase Cliente es una clase abstracta que representa a un cliente. Tiene los siguientes atributos:

- suministro (int): El número de suministro asociado al cliente.
- lecturas (List<Lectura>): Una lista de lecturas de consumo para el cliente.
- montoConsumo (double): El monto total a facturar por el consumo del cliente.
- PRECIO_KWH (int): Una constante que define el precio por kilovatio-hora.

## Clase TarifaSocial

La clase TarifaSocial extiende Cliente y representa a un cliente con tarifa social. Tiene un atributo adicional:

- porcentajeTolerancia (int): El porcentaje de tolerancia para el consumo.

## Clase Residencial

La clase Residencial extiende Cliente y representa a un cliente residencial.

## Clase Industrial

La clase Industrial extiende Cliente y representa a un cliente industrial. Tiene un atributo adicional:

- porcentajeSubsidio (int): El porcentaje de subsidio para el consumo.

## Clase Comercio

La clase Comercio extiende Cliente y representa a un cliente comercial. Tiene un atributo adicional:

- porcentajeComercio (int): El porcentaje para el consumo comercial.

## Interfaz Calculable

La interfaz Calculable define un método calcularConsumo() que debe ser implementado por las clases que implementen esta interfaz.

## Clase Facturador

La clase Facturador contiene métodos para procesar los datos de consumo y generar facturas. Tiene los siguientes métodos:

- procesarConsumos(List<Calculable> clientes): Procesa los datos de consumo para una lista de clientes y calcula sus facturas.
- generarFacturas(List<Cliente> clientes): Genera un archivo que contiene el número de suministro y el monto de consumo para cada cliente.

## Clase Test

La clase Test se utiliza para probar la funcionalidad del sistema de facturación. Realiza las siguientes tareas:

- Lee las lecturas de consumo utilizando el método estático tomarDatosLecturas().
- Instancia la clase Facturador e invoca el método procesarConsumos(...), pasando la lista de clientes almacenada en el atributo estático.
- Invoca el método generarFacturas(...), pasando la lista de clientes almacenada en el atributo estático.
