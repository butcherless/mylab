Feature: Operaciones API Departamentos
  Probar las operaciones ofrecidas por la API de Departamentos

  @api
  Scenario: Get colleción vacía de departamentos
    Given the resource departamentosFoo
    When request departamento by name dep-1
    Then the get http code should be 200
    # empty collection


  @api
  Scenario: Create departamento
    Given the resource departamentosFoo
    When I supply the departamento name dep-1
    Then the create http code should be 201

  @api
  Scenario: Get departamento por su nombre
    Given the resource departamentosFoo
    When request departamento by name dep-1
    Then the get http code should be 200

  #@api
  Scenario: Update departamento
    Given the resource departamentosFoo
    When I supply the departamento name dep-1
    Then the update http code should be 200

  #@api
  Scenario: Delete departamento
    Given the resource departamentosFoo
    When I supply the departamento name dep-1
    Then the delete http code should be 200
