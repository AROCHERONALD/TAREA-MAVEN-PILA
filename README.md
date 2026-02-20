Agregando README documentado del proyecto
# Tarea Maven + Dependencias + Validación de Expresiones + Ofuscación

## Objetivo de la práctica

En esta tarea trabajé con dos proyectos dentro del mismo repositorio.\
La idea principal fue practicar cómo conectar proyectos con Maven, crear
una librería propia, usarla desde otro proyecto y luego aplicar
ofuscación para proteger el código.

También se realizó ingeniería inversa para analizar qué tanto cambia el
código después de ser ofuscado y comprobar que el programa sigue
funcionando igual.

------------------------------------------------------------------------

##  Estructura del repositorio

El repositorio contiene:

/umg.edu.gt.data-structure.stack\
/stackHandler\
/evidencias\
README.md

-   **umg.edu.gt.data-structure.stack** → Es la librería donde
    implementé la pila manualmente.
-   **stackHandler** → Es el proyecto que usa la librería para validar
    expresiones.
-   **evidencias** → Contiene todas las capturas solicitadas.
-   **README.md** → Documento explicando todo el proceso.

------------------------------------------------------------------------
##  Parte A -- Dependencia entre proyectos

Primero trabajé en la librería:

Verifiqué que el `groupId`, `artifactId` y `version` estuvieran
correctos y luego ejecuté:

``` bash
mvn clean package
```

Después agregué esa misma dependencia en el proyecto `stackHandler`
usando exactamente las mismas coordenadas.

Luego compilé el handler desde consola:

``` bash
mvn clean package
```
Ambos proyectos compilaron correctamente.

------------------------------------------------------------------------

## Parte B -- Implementación de la pila

En la librería implementé manualmente una pila enlazada, sin usar
`Stack` de Java.

Creé las clases necesarias como:

-   Node
-   LinkedStack

También agregué métodos adicionales para cumplir lo solicitado:

-   Método para saber cuántos elementos tiene la pila
-   Método para obtener el nodo inicial

En el proyecto `stackHandler` utilicé esa pila para validar expresiones
algebraicas.

Probé desde consola los siguientes casos:

Caso válido:

(a+b) \* \[c-d\]\
Resultado: true

Caso inválido:

(\[)\]\
Resultado: false

Todas las pruebas se ejecutaron desde el `main` y desde la terminal.

------------------------------------------------------------------------

## Parte C -- Ofuscación

Para proteger el código configuré ProGuard dentro del `pom.xml` de ambos
proyectos usando un perfil Maven.

Ejecuté el siguiente comando:

``` bash
mvn clean package -Pobfuscate
```

Esto generó:

-   Un JAR normal
-   Un JAR ofuscado

Se puede ver claramente que el JAR ofuscado es más pequeño y los nombres
internos cambian.

------------------------------------------------------------------------

## Parte D -- Ingeniería inversa

Utilicé CFR para decompilar el JAR ofuscado.

Al revisar el código decompilado observé que:

-   Los nombres de clases cambian (por ejemplo: `a.java`)
-   Los métodos ya no tienen nombres descriptivos
-   La estructura es más difícil de leer

Sin embargo, aunque el código pierde claridad, todavía se puede entender
la lógica general si se analiza con cuidado.

------------------------------------------------------------------------

## Parte E -- Prueba de regresión

Ejecuté el JAR ofuscado desde consola usando:

``` bash
java -cp "target\stackHandler-1.0.0-obfuscated.jar;RUTA\.m2\repository\umg\edu\gt\data-structure-stack\1.0.0\data-structure-stack-1.0.0.jar" umg.edu.gt.handler.App
```

También probé enviando una expresión como parámetro:

``` bash
java -cp "target\stackHandler-1.0.0-obfuscated.jar;RUTA\.m2\repository\umg\edu\gt\data-structure-stack\1.0.0\data-structure-stack-1.0.0.jar" umg.edu.gt.handler.App "([)]"
```

El resultado fue el mismo que con el JAR normal.

### Conclusión de la prueba

La ofuscación no cambió el funcionamiento del programa.\
El sistema sigue validando correctamente las expresiones.\
Solo se modificaron los nombres internos del código.

------------------------------------------------------------------------

## Evidencias

En la carpeta `evidencias/` incluí:

-   Compilación de ambos proyectos
-   Ofuscación aplicada
-   Comparación entre JAR normal y ofuscado
-   Código decompilado
-   Ejecución del main desde consola
-   Pruebas con expresiones válidas e inválidas

------------------------------------------------------------------------

## ✅ Conclusión general

En esta práctica comprendí mejor cómo funciona Maven con múltiples
proyectos, cómo crear una librería propia y usarla desde otro proyecto.

También aprendí cómo aplicar ofuscación y qué tan efectiva es para
dificultar la lectura del código.
