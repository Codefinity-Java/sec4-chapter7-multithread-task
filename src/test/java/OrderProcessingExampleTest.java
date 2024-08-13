import com.codefinity.service.CalculationService;
import com.codefinity.service.OrderService;
import com.codefinity.task.OrderProcessingExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class OrderProcessingExampleTest {

    private OrderService orderService;
    private CalculationService calculationService;
    private OrderProcessingExample orderProcessingExample;

    @BeforeEach
    public void setUp() {
        orderService = Mockito.mock(OrderService.class);
        calculationService = Mockito.mock(CalculationService.class);
        orderProcessingExample = new OrderProcessingExample(orderService, calculationService);
    }

    @Test
    public void testProcessOrders() {
        // Arrange
        Map<String, Double> orders = Map.of("order1", 300.00, "order2", 120.00, "order3", 180.00);

        when(orderService.fetchOrderAmount(anyString()))
                .thenAnswer(invocation -> CompletableFuture.completedFuture(orders.get(invocation.getArgument(0))));

        when(calculationService.calculateTax(anyDouble()))
                .thenAnswer(invocation -> CompletableFuture.completedFuture((double)invocation.getArgument(0) * 0.15));

        when(calculationService.calculateShipping(anyDouble()))
                .thenAnswer(invocation -> CompletableFuture.completedFuture((double)invocation.getArgument(0) * 0.1));

        // Act
        orderProcessingExample.processOrders();

        // Assert
        verify(orderService, times(1)).fetchOrderAmount(eq("order1"));
        verify(orderService, times(1)).fetchOrderAmount(eq("order2"));
        verify(orderService, times(1)).fetchOrderAmount(eq("order3"));

        verify(calculationService, times(1)).calculateTax(eq(300.00));
        verify(calculationService, times(1)).calculateShipping(eq(300.00));

        verify(calculationService, times(1)).calculateTax(eq(120.00));
        verify(calculationService, times(1)).calculateShipping(eq(120.00));

        verify(calculationService, times(1)).calculateTax(eq(180.00));
        verify(calculationService, times(1)).calculateShipping(eq(180.00));
    }
}