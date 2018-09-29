package jbhembise.testauto.jmock;

import jbhembise.testauto.interaction.Order;
import jbhembise.testauto.interaction.Warehouse;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    private static final String TALISKER = "Talisker";

    private final Order order = new Order(TALISKER, 50);

    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        // Given
        Warehouse warehouseMock = context.mock(Warehouse.class);

        context.checking(new Expectations() {{
            oneOf(warehouseMock).hasInventory(with(equal(TALISKER)), with(equal(50)));
            will(returnValue(true));

            oneOf(warehouseMock).remove(with(equal(TALISKER)), with(equal(50)));
        }});

        // When
        order.fill(warehouseMock);

        // Then
        context.assertIsSatisfied();

        assertTrue(order.isFilled());
    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        // Given
        Warehouse warehouseMock = context.mock(Warehouse.class);

        context.checking(new Expectations() {{
            oneOf(warehouseMock).hasInventory(with(equal(TALISKER)), with(equal(50)));
            will(returnValue(false));

            never(warehouseMock).remove(with(equal(TALISKER)), with(equal(50)));
        }});

        // When
        order.fill(warehouseMock);

        // Then
        context.assertIsSatisfied();

        assertFalse(order.isFilled());
    }
}
