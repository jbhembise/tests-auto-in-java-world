package jbhembise.testauto.jmockit;

import jbhembise.testauto.interaction.Order;
import jbhembise.testauto.interaction.Warehouse;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.VerificationsInOrder;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    private static final String TALISKER = "Talisker";

    @Tested
    private final Order order = new Order(TALISKER, 50);

    @Mocked
    private Warehouse warehouseMock;

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        // Given
        new Expectations() {{
            warehouseMock.hasInventory(TALISKER, 50); result = true;
        }};

        // When
        order.fill(warehouseMock);

        // Then
        new VerificationsInOrder() {{
            warehouseMock.hasInventory(TALISKER, 50); times = 1;
            warehouseMock.remove(TALISKER, 50); times = 1;
        }};

        assertTrue(order.isFilled());
    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        // Given
        new Expectations() {{
            warehouseMock.hasInventory(TALISKER, 50); result = false;
        }};

        // When
        order.fill(warehouseMock);

        // Then
        new VerificationsInOrder() {{
            warehouseMock.hasInventory(TALISKER, 50); times = 1;
            warehouseMock.remove(TALISKER, 50); times = 0;
        }};

        assertFalse(order.isFilled());
    }
}
