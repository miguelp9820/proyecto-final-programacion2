=========================================
PROYECTO FINAL - PROGRAMACIÓN II
=========================================

Nombre del estudiante: Miguel Angel Peguero Mena  
Matrícula: 100419333  
Nombre del proyecto: Sistema CRUD y Reportes con base de datos Sakila  
Materia: Lenguaje de Programación II  
Universidad: Universidad Autónoma de Santo Domingo (UASD)

-----------------------------------------
DESCRIPCIÓN GENERAL
-----------------------------------------

Este proyecto implementa un sistema de consola en Java que permite la gestión de:

- Actores
- Películas
- Ciudades

Cada módulo incluye funciones de:
- Crear
- Leer
- Actualizar
- Eliminar
- Exportación a CSV y JSON
- Estadísticas por consola

-----------------------------------------
REQUISITOS
-----------------------------------------

- Java 17 o superior (funciona con JavaSE-23)
- Conexión a base de datos MySQL con el esquema "sakila" instalado
- Archivo `config.properties` correctamente configurado

-----------------------------------------
INSTRUCCIONES DE USO
-----------------------------------------

⚠️ Este proyecto es una aplicación de consola, por lo tanto **no se ejecuta con doble clic**.

1. Asegúrese de que el archivo `config.properties` esté en el mismo directorio que el `.jar`.

2. Abra la consola (CMD o Terminal), navegue hasta la carpeta del proyecto y ejecute el siguiente comando:

   java -jar proyecto_final_uasd.jar

3. Siga las instrucciones por consola para usar los menús de actores, películas y ciudades.

-----------------------------------------
ESTRUCTURA DE LA ENTREGA
-----------------------------------------

📦 proyecto_final_uasd_entrega/
├── proyecto_final_uasd.jar            # Ejecutable del sistema
├── config.properties                  # Archivo con configuración de conexión
├── documentation/                     # Carpeta con documentación generada por Javadoc
│   └── index.html                     # Archivo principal para ver la documentación
├── uml_diagrama.png                   # Imagen con el diagrama UML
├── src/                               # Código fuente (opcional si el profe lo pide)
└── README.txt                         # Este documento

-----------------------------------------
AUTOR
-----------------------------------------
Nombre: Miguel Angel Peguero Mena  
Matrícula: 100419333
Correo: miguelpeguero468@gmail.com
