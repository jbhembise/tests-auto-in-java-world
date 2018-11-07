package jbhembise.testauto.spock

import jbhembise.testauto.calculator.Calculator
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CalculatorSpecification extends Specification {

  def "addition of two numbers"() {
    given: "a calculator"
    def calculator = new Calculator()

    when: "i add 1 and 9"
    def result = calculator.add(1, 9)

    then: "it should return 10"
    result == 10
  }

  def "#n1 + #n2 = #expected"(int n1, int n2, int expected) {
    given:
    def calculator = new Calculator()

    expect:
    calculator.add(n1, n2) == expected

    where:
      n1 | n2 || expected
      1  | 2  || 3
      2  | 2  || 4
      3  | 2  || 5
  }

  def "#n1 - #n2 = #expected"(int n1, int n2, int expected) {
    given:
    def calculator = new Calculator()

    expect:
    calculator.substract(n1, n2) == expected

    where:
    n1 | n2 || expected
    3  | 2  || 1
    4  | 2  || 2
  }

  def "#n1 * #n2 = #expected"(int n1, int n2, int expected) {
    given:
    def calculator = new Calculator()

    expect:
    calculator.multiply(n1, n2) == expected

    where:
    n1 | n2 || expected
    3  | 3  || 9
    6  | 5  || 30
  }

  def "#n1 / #n2 = #expected"(int n1, int n2, int expected) {
    given:
    def calculator = new Calculator()

    expect:
    calculator.divide(n1, n2) == expected

    where:
    n1 | n2 || expected
    9  | 3  || 3
    30 | 5  || 6
  }

  def "divide by 0 should throw an exception"() {
    given:
    def calculator = new Calculator()

    when:
    calculator.divide(10, 0)

    then:
    thrown ArithmeticException
  }

  def "fibonacci(#n) = #expected"(int n, int expected) {
    given:
    def calculator = new Calculator()

    expect:
    calculator.fibonacci(n) == expected

    where:
    n || expected
    4 || 3
    6 || 8
  }
}
