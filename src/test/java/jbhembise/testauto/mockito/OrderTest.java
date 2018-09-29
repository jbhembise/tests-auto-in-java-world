package jbhembise.testauto.mockito;

import jbhembise.testauto.interaction.Order;
import jbhembise.testauto.interaction.Warehouse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    private static final String TALISKER = "Talisker";

    @Mock
    private Warehouse warehouseMock;

    @InjectMocks
    private final Order order = new Order(TALISKER, 50);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFillingRemovesInventoryIfInStock() {
        // Given
        Mockito.when(warehouseMock.hasInventory(Mockito.eq(TALISKER), Mockito.eq(50)))
                .thenReturn(true);

        // When
        order.fill(warehouseMock);

        // Then
        Mockito.verify(warehouseMock, Mockito.times(1)).hasInventory(Mockito.eq(TALISKER), Mockito.eq(50));
        Mockito.verify(warehouseMock, Mockito.times(1)).remove(Mockito.eq(TALISKER), Mockito.eq(50));

        assertTrue(order.isFilled());
    }

    @Test
    public void testFillingDoesNotRemoveIfNotEnoughInStock() {
        // Given
        Mockito.when(warehouseMock.hasInventory(Mockito.eq(TALISKER), Mockito.eq(50)))
                .thenReturn(false);

        // When
        order.fill(warehouseMock);

        // Then
        Mockito.verify(warehouseMock, Mockito.times(1)).hasInventory(Mockito.eq(TALISKER), Mockito.eq(50));
        Mockito.verify(warehouseMock, Mockito.never()).remove(Mockito.eq(TALISKER), Mockito.eq(50));

        assertFalse(order.isFilled());
    }
}
