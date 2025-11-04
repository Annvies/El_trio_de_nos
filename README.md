# Monedita

Monedita es una aplicación móvil que permite gestionar gastos e ingresos personales de manera sencilla, visual y accesible. 
El usuario puede registrar sus gastos diarios, clasificarlos por categoría, visualizar su saldo disponible en tiempo real y consultar búsquedas por fecha o categoría.
Además, cuenta con un modo claro y oscuro, pantalla de ayuda, y gestión de usuario (inicio de sesión, cambio de contraseña y cierre de sesión).

## Tecnologías utilizadas
- Lenguaje: Kotlin

- Entorno: Android Studio (ultima versión)

- Interfaz: XML y Material Design 3

- Persistencia de datos: SharedPreferences

- Control de versiones: GitHub

- Gestión del proyecto: Trello  


## Requisitos previos

Antes de comenzar la instalación, asegúrate de tener instalado y configurado lo siguiente en tu sistema:

-  Git (para clonar el repositorio)

- Android Studio (última versión, con los SDKs necesarios para la app)

- Cuenta de GitHub (aunque solo es necesaria si se quiere contribuir al proyecto, no para clonarlo).


## Instalación

Esta guía te llevará paso a paso desde la clonación del repositorio hasta la ejecución de la aplicación en un dispositivo o emulador.

### Clonar el repositorio
1. Copia este enlace del repositorio:
https://github.com/Annvies/El_trio_de_nos.git
2. Abre Android Studio (en la pantalla de inicio, antes de abrir un proyecto).
3. Selecciona la opción “Get from VCS” o “Clone Repository” (depende de la versión).
4. En el campo URL, pega el enlace del repositorio que copiaste.
5. Elige la carpeta donde quieres guardar el proyecto localmente.
6. Pulsa Clone.
7. Cuando aparezca el mensaje “Do you trust the authors of this project?”, haz clic en Trust Project para que Android Studio pueda compilarlo sin restricciones.
8. Espera a que se descargue y sincronice automáticamente el proyecto con Gradle (esto puede tomar un par de minutos).

### Configurar el SDK y Gradle (si es necesario)

- Si Android Studio pide actualizar el Gradle Plugin o el SDK, acepta las sugerencias.

- Verifica en la barra inferior que no haya errores.

- Si aparecen advertencias, usa Build, luego selecciona Clean Project y luego Build, y de ahí a Rebuild Project.

### Instalación de elementos externos requeridos
Para que la instalación y la configuración del proyecto sean exitosas se requiere de la descarga de un archivo externo "google-services.json" el cual estará subido en el drive del grupo correspondiente en la carpeta "Final".
Una vez se realice la descarga del archivo se deberá ingresar a android studio, ir al apartado de vista "project" y abrir la carpeta del proyecto para luego arrastar/copiar el archivo descargado en la subcarpeta "app".
Una vez realizado este poceso el usuario debería poder correr la aplicación sin ningún problema.

### Crear o elegir un dispositivo de prueba

#### Emulador Android (AVD):

- Ve a Tools → Device Manager.

- Crea un dispositivo virtual con Android 8.0 o superior.

- Inícialo antes de ejecutar la app.

#### Dispositivo físico:

- Activa el modo desarrollador y depuración USB.

- Conecta el teléfono a la PC.

- Acepta el permiso de conexión en tu teléfono.

  



## Ejecutar la aplicación

1. Haz clic en el botón Run App (parte superior de Android Studio).
2. Espera unos segundos mientras se compila y se instala la app.
3. Una vez iniciada, verás la pantalla de Log In, donde puedes ingresar tus datos o crear una cuenta.

## Solución de errores comunes
- Gradle sync failed: Clic en Sync Project with Gradle Files.
- Error de dependencias: Verifica conexión a internet y limpia el proyecto.
- App no se instala en el emulador: Reinicia el AVD o reduce la versión mínima del SDK.
- Pantalla en blanco: Revisa que el tema y los recursos estén sincronizados (colors.xml y themes.xml).


## Autores

* **Dewuard Freddy Maydana Quispe** 
* **Tony Osvaldo Clavel Alberto** 
* **Ángela de Jesús Valcarce Arumbary** 

