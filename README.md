# **TICS200: App #2 – Gestión Agrícola en Java (POO)**

Compilación y ejecución

Desde la raíz del proyecto, se debe poder compilar (por ejemplo, javac App2.java u otro comando, dependiendo de la estructura).
Luego, ejecutar:
**java App2 cultivos.csv**
El programa mostrará un menú que permita realizar las acciones mencionadas (crear cultivo, registrar actividad, buscar, etc.).
Al salir, se guardarán los cambios en cultivos.csv.

# Informe de Diseño y Justificación de la Solución  
**Tarea 2: Gestión Agrícola en Java (POO)**  
**TICS 200**  

---

## Alumnos  
- Simon Belmar  
- Lucas Molina  
- Martina Uribe  

**Sección:** 1  
**Profesor:** Maria Loreto Arriagada  
**Fecha:** 03 de Mayo del 2025  

---

## 1. Informe de diseño

### 1.1 Arquitectura (clases, paquetes, herencia, etc.)

La arquitectura del sistema se fundamenta en una estructura orientada a objetos organizada y modular, donde las clases, paquetes, herencia e interfaces definen la forma en que los componentes se agrupan, relacionan y comunican para cumplir con los objetivos funcionales y no funcionales.

**Clases**  
El sistema está diseñado con un enfoque orientado a objetos, donde las clases representan las entidades principales del dominio agrícola. Por ejemplo:  
- **GestorActividades:** Clase central que maneja la creación, actualización, eliminación y consulta de actividades relacionadas con cultivos.  
- **Actividad:** Modela cada tarea agrícola con atributos como tipo, fecha y descripción.  
- **Cultivo:** Representa un cultivo específico dentro de una parcela.  
- **Parcela:** Contiene múltiples cultivos, reflejando la composición del sistema.  

Cada clase encapsula sus datos y comportamientos, respetando el principio de encapsulación para proteger el estado interno y exponer sólo métodos controlados.

**Paquetes**  
El código está organizado en paquetes que agrupan clases con responsabilidades similares, por ejemplo:  
- `services`: Contiene clases como GestorActividades que implementan la lógica de negocio para la gestión de actividades.  
- Otros paquetes organizan modelos de datos y utilidades, mejorando la modularidad y facilitando el mantenimiento y la navegación del código.

**Herencia**  
Actualmente, el código no implementa jerarquías de herencia explícitas, pero la arquitectura es extensible para permitir crear subclases especializadas, por ejemplo, diferentes tipos de actividades agrícolas que hereden de una clase base `Actividad`. Esto favorece la reutilización y la extensión futura del sistema.

**Interfaces**  
Se utilizan interfaces para definir contratos que las clases implementan, promoviendo la abstracción y flexibilidad, y permitiendo un diseño desacoplado y extensible.

**Relaciones entre clases**  
- **Composición:** Una Parcela contiene una colección de Cultivos, y cada Cultivo contiene una colección de Actividades, lo que implica una relación fuerte donde la existencia de los objetos contenidos depende del contenedor.  
- **Agregación:** GestorActividades mantiene referencias a las actividades que gestiona, pero no controla su ciclo de vida, indicando una relación más débil.
## Diagrama de Clases UML

A continuación se muestra el diagrama de clases que representa la arquitectura del sistema:

![Diagrama de Clases UML](http://www.plantuml.com/plantuml/png/ZP7HQi8m58RlynI7tbWd2hijGnG7Op36q2SufiVkZ3GfIUg5Rk--cCMkfS9srtpz3z-VavNpQ7rRAp61ZK973XhBMdA3YfoG0JbuGoj98Pm5m1ouX09O-tZGfjvR2c3dmrWLcMoLvwDnWRwmym-Rd_DI0Cm0AqiLsiHoMK3wd8RuqN0flaJIfX-tj9uRCvIY35akiQJEkxwYWRcZEHRG7SRsxbVoZvK7akyOq2DwYY2ufUL6ij7zv0mieU8JsdoiUIBdZLttsf__UHzfwQ_Rn1mfhbdterp6JVRBJ61B2Y_DoOdhUsVt6TpDvv2zPjrZ522DzaoQH4A3M2Vf1qTtZ2FcnaWLag43NWhj6EAuWrRZfI_P0vuWfm-g6sMc8Y59yBobYfstk5S4vxJoI8Ox_rKj5f_BmPXOaIxRMdq3)

| Clase principal      | Relación  | Clase relacionada | Tipo de relación | Cardinalidad |
|----------------------|-----------|-------------------|------------------|--------------|
| Parcela              | contiene  | Cultivo           | Composición      | 1-N          |
| Cultivo              | contiene  | Actividad         | Composición      | 1-N          |
| GestorActividades    | gestiona  | Actividad         | Agregación       | N            |

---

### 1.2 Justificación del uso de colecciones y patrones de diseño

**Uso de colecciones**  
Se utilizan colecciones (como `List` y `Map`) para manejar grupos dinámicos de objetos relacionados, por ejemplo, listas de actividades dentro de un cultivo o cultivos dentro de una parcela. Las colecciones permiten:  
- Almacenamiento flexible sin tamaño fijo.  
- Operaciones eficientes de iteración, búsqueda y ordenamiento.  
- Mejor claridad y mantenimiento del código.

**Patrones de diseño**  
Aunque no se menciona un patrón de diseño formal, la arquitectura sigue principios como:  
- Responsabilidad única: Cada clase tiene funciones claras y delimitadas.  
- Encapsulación: Protección del estado interno.  
- Modularidad: Separación en paquetes y clases con responsabilidades específicas.  
- Posible uso futuro de patrones como Factory o Strategy para extender la creación o comportamiento de actividades.

---

### 1.3 Manejo de modificadores de acceso

El manejo de modificadores de acceso sigue las buenas prácticas de encapsulamiento propias de Java, utilizando principalmente los modificadores `private`, `public` y el acceso por defecto para controlar la visibilidad y protección de los atributos y métodos, limitando la visibilidad de los datos y exponiendo solo las operaciones necesarias para la interacción con otras clases.

- **private:** Para atributos internos que no deben ser accesibles desde fuera de la clase, como listas de actividades o datos internos de `GestorActividades`.  
- **public:** Para métodos que forman la interfaz pública de la clase, permitiendo la interacción con otras partes del sistema (ej. métodos para crear, actualizar o eliminar actividades).  
- **Acceso por defecto (package-private):** Para miembros que deben ser visibles sólo dentro del mismo paquete, facilitando la colaboración entre clases relacionadas sin exponerlas globalmente.

Este control de acceso asegura que el estado interno de las clases esté protegido y que la interacción con ellas se realice únicamente a través de métodos definidos, promoviendo la integridad de los datos y facilitando el mantenimiento del código.

Además, el código no muestra uso de modificadores `protected` ni herencia directa en la clase `GestorActividades`, pero la estructura permite extender funcionalidades mediante herencia o implementación de interfaces si se requiere en futuras ampliaciones.

---

## 2. Reflexiones finales / autoevaluación

### 2.1 ¿Qué fue lo más desafiante de implementar en POO?

Lo más desafiante de implementar en programación orientada a objetos (POO) suele ser el cambio de paradigma, ya que implica pasar de una forma de pensar procedimental a una basada en objetos que combinan datos y comportamientos en una sola unidad. Este cambio mental requiere entender cómo modelar el problema real en clases, objetos, y sus relaciones.

Además, un reto importante es el diseño adecuado de la herencia. La herencia puede generar jerarquías rígidas y acoplamientos excesivos entre clases, lo que dificulta la evolución y mantenimiento del sistema. Cambios en una clase base pueden afectar inesperadamente a todas las clases derivadas, provocando fragilidad y problemas de reutilización si no se diseña bien.

---

### 2.2 ¿Cómo controlaron la lectura y escritura de CSV?

En la tarea, la lectura y escritura de archivos CSV se gestionan mediante una implementación personalizada en la clase `CsvService`, que permite manejar cultivos y sus actividades asociadas de forma estructurada. Para la lectura, se utiliza `Files.readAllLines()` para cargar el archivo completo, filtrando y procesando solo las líneas relevantes. Se emplea una expresión regular que considera comillas para separar correctamente los campos, incluso si contienen comas internas. Las actividades se extraen mediante expresiones regulares y se asocian a cada cultivo.

Para la escritura, se usa un `BufferedWriter` que formatea cada cultivo y sus actividades en líneas CSV, utilizando streams para convertir las listas en cadenas delimitadas adecuadamente. Este enfoque brinda control total sobre el formato, maneja correctamente comillas y separadores, y mejora la modularidad al centralizar la funcionalidad en una clase dedicada.

En resumen, esta solución personalizada asegura un manejo preciso y eficiente de archivos CSV con estructuras complejas, garantizando la integridad y correcta interpretación de los datos.

---

### 2.3 ¿Qué aprendizajes surgieron del proyecto?

A lo largo del avance del proyecto, pudimos aprender a aplicar de forma práctica los principios de la programación orientada a objetos, como encapsulamiento, modularidad y responsabilidad única.

Asimismo, comprendimos lo importante que es diseñar una arquitectura flexible para facilitar el mantenimiento y evolución del sistema del código. También desarrollamos habilidades en la gestión de archivos CSV complejos, mejorando nuestro manejo en el ámbito del procesamiento de datos.

Por último, pudimos fortalecer el trabajo en equipo respetando buenas prácticas de codificación, planificando de forma más organizada la estructura del código y utilizando colecciones para gestionar grandes volúmenes de información de la manera más eficiente posible.

---

## 3. Explicación de uso de IA

### 3.1 ¿Qué tipo de ayuda proporcionó la herramienta?

La herramienta de inteligencia artificial nos proporcionó apoyo en distintas partes del proyecto, principalmente sugiriendo mejoras en el diseño de clases, ejemplos de uso de colecciones en Java y estrategias para el manejo correcto de archivos CSV.

Además, resultó útil para aclarar nuestras dudas sobre buenas prácticas de programación orientada a objetos y optimizar algunos fragmentos de código, haciéndolos así más claros y eficientes.

---

### 3.2 ¿Cómo validaron o contrastaron las sugerencias?

Validamos las sugerencias de la herramienta consultando la documentación oficial de Java y realizando pruebas unitarias sobre nuestro código.

También analizamos en equipo cada recomendación para asegurarnos que cumpliera adecuadamente con los requisitos de la tarea.

De igual modo, evaluamos su impacto en la claridad, funcionalidad y mantenibilidad del sistema antes de incorporarlas de manera definitiva.

También es importante señalar que la inteligencia artificial fue empleada únicamente como un recurso de apoyo, sin reemplazar nuestro propio criterio y análisis. Cada sugerencia proporcionada por Chat GPT fue revisada de manera crítica y se complementó con nuestros conocimientos y experiencia personal.

