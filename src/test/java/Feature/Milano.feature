Feature: Sistema Milano

  @TestMilano
  Scenario: Carga de alumnos nuevos
    Given El usuario esta en la pagina de Milano "https://sistemamilanomodels.cl/login"
    Then ingresa usuario "jorge.fierro@dreamslab.cl" y password "@milano_jorge2023"
    And El usuario accede a la seccion de agregar nuevo alumno
    When El usuario ingresa informacion para un nuevo alumno
