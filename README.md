
# Libreria UD

**Libreria UD** es un sistema de gestión de documentos académicos que permite administrar y consultar documentos de distintos tipos, tales como **Libros**, **Ponencias** y **Artículos**.  
El sistema permite a los usuarios crear una cuenta, registrar documentos de su autoría y realizar reservas de documentos creados por otros usuarios, siempre que estos se encuentren disponibles.

---

## 🧩 Funcionalidades principales

- Registro e inicio de sesión de usuarios
- Creación de documentos de tipo:
  - Libro
  - Ponencia
  - Artículo
- Consulta de documentos mediante búsquedas
- Reserva de documentos según su disponibilidad
- Visualización del estado de los documentos y reservas
- Gestión básica del historial de acciones del usuario

---

## 🗂️ Estructura del proyecto

Al clonar o descargar el repositorio desde GitHub, encontrarás **tres partes principales**:

- **frontend/**  
  Contiene los archivos **HTML, CSS y JavaScript** que conforman la interfaz gráfica del sistema.

- **backend/**  
  Contiene el proyecto desarrollado en **Java**, el cual se despliega como una aplicación web utilizando Servlets.

- **scripts_sql/**  
  Contiene:
  - Un script para la **creación de la base de datos y sus tablas**
  - Un script para **cargar datos de prueba** en la base de datos

---

## ⚙️ Requisitos previos

Antes de ejecutar el proyecto, asegúrate de contar con:

- **Java JDK** (versión compatible con Eclipse y Tomcat)
- **Eclipse IDE for Enterprise Java**
- **Apache Tomcat v9.x**
- **PostgreSQL**
- **PgAdmin** o **DBDesigner** (para visualización y gestión de la base de datos)

---

## 🚀 Configuración y ejecución del proyecto

### 1️⃣ Configuración del servidor Apache Tomcat

El proyecto fue desarrollado utilizando **Eclipse IDE**, por lo que es necesario configurar el servidor de la siguiente manera:

1. Abrir Eclipse
2. Ir a la vista **Servers**
3. Agregar un nuevo servidor:
   - Seleccionar **Apache Tomcat v9.x**
4. Configurar la ruta donde se encuentra instalado Tomcat
5. Finalizar la configuración

Este proceso es equivalente al descrito en el **Manual de Usuario** del proyecto.

---

### 2️⃣ Configuración de la base de datos

1. Crear una base de datos en PostgreSQL con el nombre:
2. Ejecutar el script SQL de **creación de tablas**
3. Ejecutar el script SQL de **carga de datos de prueba**
4. Ajustar la conexión a la base de datos dentro del proyecto Java, verificando:
- Nombre de la base de datos
- Usuario
- Contraseña
- Puerto de conexión

---

### 3️⃣ Configuración de librerías (JAR)

Dentro del proyecto Java ubicado en la carpeta **backend**, realizar lo siguiente:

1. Ir a la ruta:
2. Importar los **JAR** contenidos en esta carpeta al **Build Path** del proyecto
3. Algunas librerías del Servlet serán proporcionadas directamente por el servidor Tomcat y **no generarán conflictos** si el servidor fue configurado correctamente

---

### 4️⃣ Ejecución del aplicativo

1. Agregar el proyecto Java al servidor Tomcat
2. Iniciar el servidor desde Eclipse
3. Verificar que el despliegue se realice sin errores

---

### 5️⃣ Acceso al sistema

1. Abrir el archivo **HTML de la página principal** desde el navegador
2. Si no existe una sesión activa, el sistema redirigirá automáticamente al **inicio de sesión**
3. Una vez autenticado, se podrá acceder a todas las funcionalidades del sistema

---

## 🧑‍💻 Uso del sistema

Una vez desplegado correctamente, el usuario podrá:

- Crear una cuenta
- Iniciar sesión
- Registrar documentos de su autoría
- Consultar documentos disponibles
- Reservar documentos de otros usuarios
- Visualizar información detallada de los documentos

---

## ✍️ Autores

- Juan Sotelo  
- Nicolas Castro  
- Henry Jhonmarcos  
