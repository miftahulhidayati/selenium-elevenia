Feature: Elevenia Cart
  As a user I should be able to add cart and delete cart

  Scenario: I add cart
    Given I navigate to "https://www.elevenia.co.id"
    And I enter "computer" into input field having xpath "//*[@id='AKCKwd']"
    And I click button search having xpath "//*[@id='AKCFrm']/div/button"
    And I click sort by most buying having xpath "//*[@id='searchCondition_wrap']/div[1]/ul/li[2]/a"
    And I click product having xpath "//*[@id='prod_28911164']/div/a[2]"
    And I enter "3" into input field having id "optionStock0"
    And I click button add to cart having xpath "/html/body/section/section/form[1]/div[1]/div[3]/div[6]/a[1]"
    And I check cart
    And I click Change Delivery having name "deliveryChangePopup"
    And I click cancel by xpath "//*[@id='frm']/article/p[3]/a[2]"
    And I click delete by xpath "//*[@id='frmTmall']/table/tbody/tr/td[7]/a[2]"
    When I click yes on delete pop up by id "chkDelPopY"
    Then Show note Empty Cart
