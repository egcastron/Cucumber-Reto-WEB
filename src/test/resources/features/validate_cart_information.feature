#Author: edisson.castronunez@tcs.com
#Languaje: EN

Feature: As a user I want to select and add products to a cart for make an online purchase}

  Background:
    Given the user is on the main page

  @Sc1
  Scenario: Adding products to cart
    When the user selects products from categories
      | categories                 | products                  |
      | Celulares y Tablets        | Celular Xiaomi Redmi Note |
      | Belleza y Cuidado Personal | Plancha Alisadora         |
      | Moda                       | Chaqueta Yumo             |
    And the user see information in the cart
    Then the user is on the cart page and will see the information

  @Sc2
  Scenario: Delete all products of cart
    When the user selects products from categories
      | categories                 | products                  |
      | Celulares y Tablets        | Celular Xiaomi Redmi Note |
      | Belleza y Cuidado Personal | Plancha Alisadora         |
      | Moda                       | Chaqueta Yumo             |
    And deletes the products of cart
    Then the user will see the message No hay productos en tu carrito
