package jbhembise.testauto.spock

import jbhembise.testauto.interaction.Order
import jbhembise.testauto.interaction.Warehouse
import spock.lang.Specification

class OrderInteractionsSpecification extends Specification {

  String TALISKER = "Talisker"

  def "test filling removes inventory if in stock"() {
    given:
    def order = new Order(TALISKER, 50)
    def warehouseMock = Mock(Warehouse) {
      1 * hasInventory(TALISKER, 50) >> true
      1 * remove(TALISKER, 50)
    }

    when:
    order.fill(warehouseMock)

    then:
    order.isFilled()
  }

  def "test filling does not remove if not enough in stock"() {
    given:
    def order = new Order(TALISKER, 50)
    def warehouseMock = Mock(Warehouse) {
      1 * hasInventory(TALISKER, 50) >> false
      0 * remove(TALISKER, 50)
    }

    when:
    order.fill(warehouseMock)

    then:
    !order.isFilled()
  }
}
