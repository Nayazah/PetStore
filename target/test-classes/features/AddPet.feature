 Feature: Pet object that needs to be added to the store

 

 Scenario Outline: Adding Pets to Pet store
    Given add PET API is there with "<id>" "<name>" "<status>"
    When I post the "AddpetAPI" with http "post" request
    Then API call got success with return code 200
    And "status" in response body is "<statusval>"
    And verify id is mapped to animal "<name>" using "GetPetAPI"
   
    Examples: 
      | id    | name  | status|  statusval|
      | 127 |     cat  | Available|Available|
     
 
    