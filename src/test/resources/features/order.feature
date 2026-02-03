Feature: Complete Blinkit Order Flow

  Background:
    Given user launches website url
    And user logs in successfully


  Scenario Outline: Search product and place order
    When user searches product "<category>"
    And user selects product "<productName>"
    And user adds product to cart
    And user opens cart
    And user proceeds to payment
    Then payment page should open

    Examples:
      | category | productName |
      | Kurkure  | Kurkure Masala Munch Crisps |
#      | Milk     | Amul Cow Milk               |

