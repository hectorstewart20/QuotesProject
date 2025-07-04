
- Proyecto de Automatización - Quotes to Scrape Login

Este proyecto automatiza el proceso de login en [Quotes to Scrape](https://quotes.toscrape.com), usando el patrón POM junto con herramientas como Selenium, Cucumber, Maven y WebDriverManager.

---

 Herramientas y tecnologías

- Java 17+
- Maven
- Selenium WebDriver
- Cucumber JVM 7.15.0
- Gherkin (`.feature`)
- WebDriverManager
- Page Object Model (POM)
- VSCode
---
Instalación y configuración

1. Clona o descarga este proyecto

comando
git clone https://github.com/tu-usuario/quotes-login-automation.git
cd quotes-login-automation

2. Instala Java y Maven

- Java 17 o superior
- Maven (`mvn -v` debe funcionar desde la terminal)

3. Abre el proyecto en VSCode
Instalar la extensión **"Language Support for Java(TM)"** instalada en VSCode.
Configuración con archivo `.properties`
Este proyecto usa un archivo `config.properties` ubicado en `src/test/resources/` para definir parámetros como:
properties
base.url=https://quotes.toscrape.com/login
username=admin
password=admin
browser=chrome

Estos valores se leen mediante la clase `ConfigReader`, y se pueden sobreescribir desde la línea de comandos.


Ejecutar pruebas
Prueba completa (Chrome por defecto desde `config.properties`)

commando:
mvn test

Ejecutar con navegador específico desde consola

comando
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge


Ejecutar solo una etiqueta específica
	mvn test -Dcucumber.filter.tags=@exitoso

Ejecutar con navegador + etiqueta
	mvn test -Dbrowser=firefox -Dcucumber.filter.tags="@fallido"

---
Comando para limpiar y volver a ejecutar
mvn clean test


- Reporte HTML de resultados

Después de ejecutar las pruebas, se genera un reporte automáticamente en:
target/cucumber-report.html

Puedes abrirlo en tu navegador para ver:

- Escenarios ejecutados
- Pasos exitosos y fallidos
- Etiquetas

Nota: Este Readme fue armado con ayuda de herramientas IA así como algunos métodos usados como ConfigReader y otros. Los mismos fueron revisados y adaptados a las necesidades.
