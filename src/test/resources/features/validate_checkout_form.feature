#Author: edisson.castronunez@tcs.com
#Languaje: EN

Feature: As a user I want to enter data in the checkout form for make an online purchase

  Background:
    Given the user is on the main page
    When the user selects one products from categories and makes login
      | categories          | products                  | email                | password             |
      | Celulares y Tablets | Celular Xiaomi Redmi Note | edissongcn@gmail.com | ContrasenaDificil123 |

  @Sce1
  Scenario Outline: Validate save button filling filling all the required fields
    When the user enters its information
      | celular   | direccion   | barrio   | departamento   | municipio   | numeroid   |
      | <celular> | <direccion> | <barrio> | <departamento> | <municipio> | <numeroid> |
    Then the user will watch the save button enabled
    Examples:
      | celular          | direccion | barrio   | departamento | municipio | numeroid   |
      | 3212924649       | cra 1 18  | san luis | Cordoba      | Chinu     | 1072405182 |
      | 3212924649       |           | san luis | Cordoba      | Chinu     | 1072405182 |
      | 32129246sd       | cra 1 18  | san luis | Cordoba      | Chinu     | 1072405182 |
      | 3212924649       | cra 1 18  | san luis | Cordoba      | Chinu     | 107240518d |
      | 3212924649321321 | cra 1 18  | san luis | Cordoba      | Chinu     | 1072405182 |
      | 3212924649       | cra 1 18  | san luis | Antioquia    | Andes     | 1072405182 |
      | 3212924649       | cra 1 18  | san luis | Antioquia    | Segovia   | 1072405182 |

  @Sce2
  Scenario: fill phone field with 16 digits
    When the user enters its information
      | celular          | direccion | barrio   | departamento | municipio | numeroid   |
      | 3212924649321321 | cra 1 18  | san luis | Cordoba      | Chinu     | 1072405182 |
    Then the user will watch the info in phone field equals to 3212924649321321
