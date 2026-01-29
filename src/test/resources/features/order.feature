Feature: Complete Blinkit Order Flow

  Scenario Outline: Search product and place order
    When user searches product "<category>"
    And user selects product "<productName>"
    And user adds product to cart
    And user opens cart
    And user proceeds to payment
    Then payment page should open

    Examples:
      | category | productName |
     | Namkeen  | Haldiram's Nagpur Sev Bhujia  |
#     | Bread    | English Oven Milk Bread |
#
#     | Biscuits | Parle-G Glucose Biscuit |
#      | Kurkure  | Kurkure Masala Munch Crisps |
#    | Milk     | Amul Gold Milk |
