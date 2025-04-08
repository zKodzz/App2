# **TICS200: App #2 – Gestión de Proyectos en Java (POO)**

## **Profesores**
- **María Loreto Arriagada**  
  loreto.arriagada.v@edu.uai.cl

- **Paulina González**  
  paulina.gonzalez.p@edu.uai.cl

- **Justo Vargas**  
  justo.vargas@edu.uai.cl

## **Ayudante**
- **Diego Duhalde**  
  dduhalde@alumnos.uai.cl

---

## 1. Objetivos

1. **Estructurar** un programa en Java siguiendo principios de la **Programación Orientada a Objetos (POO)**:  
   - Herencia  
   - Encapsulamiento  
   - Paquetes  
   - Composición  
   - Interfaces  
   - Abstracción  
2. **Persistir datos** a un archivo CSV, manejando lectura y escritura de información.  
3. Practicar **herramientas de apoyo** a la programación: GIT (fork, pull requests, commits balanceados), debuggers, etc.

---

## 2. Enunciado

Imaginemos que una empresa multinacional necesita un **software de gestión de proyectos**. El objetivo es mantener un registro de los proyectos, las tareas asociadas y los equipos de trabajo. Al iniciar el programa, se leerá un archivo CSV (`proyectos.csv`) que representa el estado inicial del sistema. Al finalizar, todos los cambios se guardarán nuevamente en el mismo archivo.

### 2.1 Requerimientos funcionales

El programa debe:

1. Iniciarse desde la consola con:  
   ```bash
   java App2 proyectos.csv
   ```
   donde App2.java es la clase principal y proyectos.csv el archivo de persistencia.

2. Presentar un menú principal en consola, que permita acceder a las siguientes funciones:

   - **Gestión de Proyectos**
     - Listar proyectos existentes.
     - Crear un nuevo proyecto.
     - Eliminar un proyecto (solo si no tiene tareas activas).
     - Editar la información básica de un proyecto (nombre, descripción, fecha de inicio, etc.).

   - **Gestión de Tareas**
     - Listar tareas de un proyecto.
     - Agregar una tarea a un proyecto.
     - Eliminar una tarea (solo si no tiene subtareas o colaboradores asignados).
     - Editar una tarea (cambiar nombre, responsable, fecha estimada, etc.).
     - Mover una tarea de un proyecto a otro.

   - **Gestión de Equipos y Colaboradores**
     - Agregar un colaborador a un proyecto (o a una tarea específica).
     - Eliminar un colaborador (solo si no está asignado a tareas activas).
     - Cambiar el rol de un colaborador dentro de una tarea.

   - **Búsqueda/Reporte**
     - Buscar una tarea o proyecto por nombre (mostrar datos relevantes).
     - Reporte de proyectos activos, finalizados, o en riesgo (simplemente un campo de estado que se podría indicar en cada proyecto).

   - **Salir**
     - Guardar toda la información en proyectos.csv y finalizar el programa.

### 2.2 Supuestos y detalles

- Cada proyecto puede tener múltiples tareas, y cada tarea puede tener subtareas (opcional si desean implementar más profundidad).
- Al menos una clase abstracta o interfaz debe emplearse para representar algún concepto genérico (por ejemplo, "ElementoGestión" que represente algo con nombre, fecha y estado, pudiendo ser Proyecto o Tarea).
- Se sugiere utilizar colecciones de Java (ArrayList, HashMap, List, etc.) para administrar proyectos, tareas, colaboradores, etc.
- El usuario ingresa "información válida" (no se requiere validación exhaustiva).
- No hay campos vacíos en el CSV al iniciar.
- Se evaluará el uso de herencia, encapsulamiento y paquetes para organizar las clases (por ejemplo, un paquete models, otro services, etc.).

### 2.3 Formato del CSV

Un ejemplo de fila podría ser (en un formato indicativo):

```
Proyecto, "Sistema Contable", "Actualización de la plataforma contable", "2023-03-01", "ACTIVO"
Tarea, "Implementar módulo de facturación", "John Doe", "2023-03-15", "Sistema Contable"
Tarea, "Revisión de seguridad", "Jane Smith", "2023-04-10", "Sistema Contable"
Proyecto, "Portal de Recursos Humanos", "Portal interno para gestión de RRHH", "2023-02-10", "EN RIESGO"
...
```

Cada fila comienza con el tipo (Proyecto o Tarea), seguido de los datos correspondientes. Nota: Ustedes pueden definir exactamente el formato que más les convenga, mientras sea coherente con la lectura y escritura posterior.

## 3. Nuevos Requerimientos y Detalles de la Entrega

- **Lenguaje**: Java (versión 16 o superior, u OpenJDK 16+).
- **Grupos**: 4 o 5 personas (no se admitirán grupos de 6).
- **Fecha de entrega**: Miércoles 23 de Mayo a las 23:59.
- Por cada día de atraso se descuenta 1 punto, comenzando a las 00:00 del día siguiente.
  - Ejemplo: si entregan a las 00:00 del día siguiente, la nota máxima es 6.0.

### 3.1 Diagrama de Clases

Deben entregar un diagrama de clases que represente su solución:

- Cardinalidades (ej. un proyecto tiene N tareas, una tarea tiene 1 responsable, etc.)
- Herencia (si usan clases que extiendan de alguna clase base)
- Interfaces (si las usan)
- Composición o agregación (por ejemplo, un proyecto contiene un conjunto de tareas).

Se evaluará en particular el uso correcto de:

- Paquetes (organizar las clases en paquetes coherentes).
- Modificadores de Acceso (privado, público, protegido) y encapsulamiento.
- Herencia (si se crea una superclase ElementoGestion o un patrón similar).
- Colecciones (ArrayList, List, Map, etc.).
- Interfaces/Clases abstractas (al menos un uso sensato).

## 4. Formato de Entrega (vía repositorio GitHub)

### Fork del repositorio base

- Deberán forkear el repositorio: App2 en GitHub (o el que indique el curso).
- En ese repositorio forkeado, agregar a todos los integrantes del grupo como colaboradores.

### Commits balanceados y Pull Request

- Cada integrante del grupo debe tener aproximadamente la misma cantidad de commits.
- Se evaluará la participación equitativa a través del historial de commits.
- La entrega oficial será vía Pull Request hacia el repositorio original (o como indique la asignatura).

### Estructura del repositorio

- Código fuente en Java, organizado en paquetes (models, services, ui, etc.).
- Diagrama de clases (en formato imagen/PDF).
- Informe de diseño (PDF o Markdown) con:
  - Arquitectura (clases, paquetes, herencia, etc.).
  - Justificación del uso de colecciones y patrones de diseño (si aplican).
  - Manejo de modificadores de acceso.
  - Reflexiones finales / autoevaluación:
    - ¿Qué fue lo más desafiante de implementar en POO?
    - ¿Cómo controlaron la lectura y escritura de CSV?
    - ¿Qué aprendizajes surgieron del proyecto?
  - Explicación de uso de IA (si aplica):
    - ¿Qué tipo de ayuda proporcionó la herramienta?
    - ¿Cómo validaron o contrastaron las sugerencias?
- README explicando cómo compilar/ejecutar el programa, con info de cada integrante (nombre, correo, etc.).

### Compilación y ejecución

- Desde la raíz del proyecto, se debe poder compilar (por ejemplo, javac App2.java u otro comando, dependiendo de la estructura).
- Luego, ejecutar:
  ```bash
  java App2 proyectos.csv
  ```
- El programa mostrará un menú que permita realizar las acciones mencionadas (crear proyecto, agregar tarea, buscar, etc.).
- Al salir, se guardarán los cambios en proyectos.csv.

## 5. Rúbrica de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| 1. Funcionamiento general | 30% | <ul><li>El proyecto compila y se ejecuta correctamente.</li><li>Menús y submenús funcionan sin errores ni excepciones no controladas.</li><li>Guardado y lectura de proyectos.csv se realizan de forma coherente.</li></ul> |
| 2. Paradigma Orientado a Objetos | 30% | <ul><li>Uso adecuado de clases, encapsulamiento, herencia, interfaces y colecciones.</li><li>Organización en paquetes clara y lógica.</li><li>Aplicación de principios de OOP (mínima duplicación de código, coherencia en la jerarquía de clases, etc.).</li></ul> |
| 3. Arquitectura y diagrama de clases | 15% | <ul><li>Diagrama de clases con cardinalidades y relaciones (herencia, composición, etc.).</li><li>Documentación que aclare el rol de cada clase/paquete.</li></ul> |
| 4. Informe de diseño y reflexiones finales | 15% | <ul><li><strong>Informe de diseño</strong>: explica la arquitectura, justifica las decisiones (7%).</li><li><strong>Reflexiones</strong>: aprendizajes, desafíos, etc. (5%).</li><li><strong>Uso de IA</strong>: transparencia y validación (3%).</li></ul> |
| 5. Uso de Git (commits y pull request) / Organización del repositorio | 10% | <ul><li>Commits equilibrados entre integrantes (aporte individual visible).</li><li>Estructura del repositorio clara, con README que indique cómo compilar/ejecutar.</li></ul> |
| **Total** | **100%** |  |

### Penalizaciones y Bonus

- **Atrasos**: Resta 1 punto al máximo posible por día de atraso (comenzando a las 00:00 del día siguiente).
- **Grupos con más de 5 integrantes**: penalización (no se admite grupo de 6).
- **Grupos con menos integrantes**: puede existir un pequeño bonus, según políticas de la asignatura.

## 6. Ejemplo de Uso

```bash
# (1) Clonar/forkear el repositorio
git clone https://github.com/<usuario>/App2.git

# (2) Compilar
cd App2
javac src/*.java

# (3) Ejecutar
java src/App2 proyectos.csv
```

Se mostrará un menú en consola que permitirá:
- Listar proyectos
- Crear/editar/eliminar un proyecto
- Agregar/quitar tareas
- Asignar colaboradores
- Buscar tareas/proyectos
- etc.

Al seleccionar "Salir", se guardarán los cambios en proyectos.csv.

## 7. Conclusión

Este App #2 busca afianzar conocimientos de POO en Java, lectura/escritura de CSV, y la correcta aplicación de principios de diseño (herencia, encapsulamiento, interfaces, composición). Aseguren una arquitectura clara, un diagrama de clases que refleje su solución, y un uso equilibrado de GIT para evidenciar la contribución de cada integrante.
