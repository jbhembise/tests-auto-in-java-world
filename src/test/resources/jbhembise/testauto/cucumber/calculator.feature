Feature: Features of calculator

#################################
Scenario Outline: Addition of two numbers
  Given a calculator exists
  When i add <n1> and <n2>
  Then it should return <expected>

  Examples:
    | n1 | n2 | expected |
    | 1  | 2  | 3        |
    | 2  | 2  | 4        |
    | 5  | 6  | 11       |

#################################
Scenario Outline: Substraction of two numbers
  Given a calculator exists
  When i substract <n1> and <n2>
  Then it should return <expected>

  Examples:
    | n1 | n2 | expected |
    | 5  | 2  | 3        |
    | 6  | 2  | 4        |
    | 15 | 2  | 13       |

#################################
Scenario Outline: Multiplication of two numbers
  Given a calculator exists
  When i multiply <n1> and <n2>
  Then it should return <expected>

  Examples:
    | n1 | n2 | expected |
    | 3  | 3  | 9        |
    | 6  | 5  | 30       |

#################################
Scenario Outline: Division of two numbers
  Given a calculator exists
  When i divide <n1> by <n2>
  Then it should return <expected>

  Examples:
    | n1 | n2 | expected |
    | 9  | 3  | 3        |
    | 30 | 5  | 6        |

Scenario: Division by zero
  Given a calculator exists
  When i divide 10 by 0
  Then it should throw an exception

#################################
Scenario Outline: Fibonacci suite
    Given a calculator exists
    When i calculate the element <n> of the fibonacci suite
    Then it should return <expected>

    Examples:
      | n  | expected |
      | 4  | 3        |
      | 6  | 8        |