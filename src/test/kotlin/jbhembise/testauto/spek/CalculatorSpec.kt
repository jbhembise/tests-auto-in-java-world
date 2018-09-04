package jbhembise.testauto.spek

import jbhembise.testauto.Calculator
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.*

object CalculatorSpec: Spek({
    given("a calculator") {
        val calculator = Calculator()
        on("add two numbers") {
            val result = calculator.add(1, 2)
            it("should return 3") {
                assertEquals(3, result)
            }
        }
        on("substract two numbers") {
            val result = calculator.substract(5, 3)
            it("should return 2") {
                assertEquals(2, result)
            }
        }
        on("multiply two numbers") {
            val result = calculator.multiply(4, 3)
            it("should return 12") {
                assertEquals(12, result)
            }
        }
        on("divide two numbers") {
            val result = calculator.divide(9, 3)
            it("should return 3") {
                assertEquals(3, result)
            }
            it("should throw an exception while dividing by zero") {
                try {
                    calculator.divide(10, 0)
                    fail("Exception should occur while dividing by zero")
                } catch (e: Exception) {
                    assertTrue(e is ArithmeticException)
                }
            }
        }
        on("calculate fibonacci suite element") {
            val result = calculator.fibonacci(4)
            it("should return 3") {
                assertEquals(3, result)
            }
        }
    }
})