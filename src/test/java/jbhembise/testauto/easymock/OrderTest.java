package jbhembise.testauto.easymock;

import jbhembise.testauto.interaction.Order;
import jbhembise.testauto.interaction.Warehouse;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(EasyMockRunner.class)
public class OrderTest {

    private static final String TALISKER = "Talisker";

    @Mock
    private Warehouse warehouseMock;

    @TestSubject
    private final Order order = new Order(TALISKER, 50);

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        // GIVEN
        EasyMock.expect(warehouseMock.hasInventory(TALISKER, 50)).andReturn(true);
        warehouseMock.remove(TALISKER, 50);
        EasyMock.expectLastCall();
        EasyMock.replay(warehouseMock);

        // WHEN
        order.fill(warehouseMock);

        // THEN
        EasyMock.verify(warehouseMock);
        assertTrue(order.isFilled());
    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        // GIVEN
        EasyMock.expect(warehouseMock.hasInventory(TALISKER, 50)).andReturn(false);
        EasyMock.replay(warehouseMock);

        // WHEN
        order.fill(warehouseMock);

        // THEN
        EasyMock.verify(warehouseMock);
        assertFalse(order.isFilled());
    }
}
