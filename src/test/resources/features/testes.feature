Feature: Busca

  @Test
  Scenario Outline: Adicionar novo veiculo
    Given estou na pagina principal
    When preciso preencher formulario Enter Vehicle Data
    And selecionar informacao <Make>
    And selecionar informacao <Model>
    And adicionar informacao <Cylinder Capacity>
    And adicionar informacao <Engine Performance>
    And adicionar informacao <Date of Manufacture>
    And selecionar informacao <Number of Seats 1>
    And selecionar campo <Right Hand Drive>
    And selecionar informacao <Number of Seats 2>
    And selecionar informacao <Fuel Type>
    And adicionar informacao <Payload>
    And adicionar informacao <Total Weight>
    And adicionar informacao <Payload>
    And adicionar informacao <List Price>
    And adicionar informacao <License Plate Number>
    And adicionar informacao <Annual Mileage>
    Then pressionar botao Next
    Examples:
      | Make | Model | Cylinder Capacity | Engine Performance | Date of Manufacture | Number of Seats 1 | Right Hand Drive | Number of Seats 2 | Fuel Type | Payload | Total Weight | List Price | License Plate Number | Annual Mileage |
      | Ford | Moped | 125               | 256                | 10/24/2021          | 5                 | Yes              | 3                 | Gas       | 45      | 888          | 1150       | A1254                | 101            |
