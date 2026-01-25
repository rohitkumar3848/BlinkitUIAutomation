Feature: Blinkit Login

  Background:
    Given user detects delivery location

  Scenario Outline:: Login with valid mobile number
      When User clicks on login button
      And User enters mobile number "<mobileNumber>"
      And User clicks continue
      Then OTP screen should appear
    Examples:
      | mobileNumber |
      | 9119740058   |

