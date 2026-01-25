Feature: Blinkit Product Search
  Scenario Outline: Search and open product detail page
    When user searches product "<category>"
    Then user selects product "<productName>"
    And product detail page should open

    Examples:
      | category | productName |
      | Bread    | English Oven Milk Bread |
#      | Namkeen  | Haldiram's Bhujia |
#      | Biscuits | Parle Marie Biscuits |
#      | Kurkure  | Kurkure Masala Munch Crisps |
#      | Milk     | Amul Gold Full Cream Milk |


