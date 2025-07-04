Feature: Login Quotes 

#Background: YA en la pagina de Quotes
 # Given estoy en la página de login

@exitoso
Scenario: TC_LOGIN_1 - Validación de entradas al login
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario y la contraseña válidos
    And hago clic en el botón de login
    Then deberia ver el link "Logout"

@fallido
    Scenario: TC_LOGIN_2 - Iniciar sesión con usuario incorrecto
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario "usuario" y la contraseña "admin"
    And hago clic en el botón de login
    Then debería ver el mensaje de error "Invalid username"

@fallido
  Scenario: TC_LOGIN_3 - Iniciar sesión con contraseña incorrecta
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario "admin" y la contraseña "12345"
    And hago clic en el botón de login
    Then debería ver el mensaje de error "Invalid password"

@fallido
  Scenario: TC_LOGIN_4 - Iniciar sesión con campos vacíos
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario "" y la contraseña ""
    And hago clic en el botón de login
    Then debería ver el mensaje de error "Error while logging in: please, provide your username."

@loginLogout
Scenario: TC_LOGIN_5 - Validación de logout luego de un login
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario "admin" y la contraseña "admin"
    And hago clic en el botón de login
    And hago clic en el link "Logout"
    Then deberia ver el link "Login"



@limite
Scenario Outline: TC_LOGIN_6 - Validación de distintas entradas límites al login
    Given estoy en la página principal
    When hago clic en el link "Login"
    And ingreso el usuario "<user>" y la contraseña "<pass>"
    And hago clic en el botón de login
    Then debería ver el mensaje de error "<errorMsg>"


Examples:
  | user                        | pass                    | errorMsg                  |
  |                             |                         |  Error while logging in: please, provide your username.|
  | usuarioValido               |                         |  Clave vacía               |
  |                             | claveValida             |  Error while logging in: please, provide your username.|
  | a                           | a                       |  Mínimo 1 carácter         |
  | aaaaaaaaaa                  | aaaaaaaaaa              |  Entrada válida (10 chars) |
  | a...a (255 chars)           | a...a (255 chars)       |  Máximo válido             |
  | a...a (256 chars)           | a...a (256 chars)       |  Exceso (límite +1)        |
  | DROP TABLE users;--        | 123456                  |  Inyección SQL             |

