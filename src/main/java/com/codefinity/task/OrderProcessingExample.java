package com.codefinity.task;

import com.codefinity.init.InitMap;
import com.codefinity.service.CalculationService;
import com.codefinity.service.OrderService;

import java.util.concurrent.CompletableFuture;

public class OrderProcessingExample {
    private final OrderService orderService = new OrderService();
    private final CalculationService calculationService = new CalculationService();

    public void processOrders() {
        // Process each order asynchronously
        for (String orderId : InitMap.getMapOrders().keySet()) {
            //TODO: 1) Fetch the order amount asynchronously using the order service.

            //TODO: 2) Once the order amount is fetched, calculate the tax asynchronously using the calculation service.

            //TODO: 3) Once the order amount is fetched, calculate the shipping cost asynchronously using the calculation service.

            //TODO: 4) Combine the tax and shipping cost futures to get the total additional cost (tax + shipping).

            //TODO: 5) Combine the order amount future with the total additional cost future to get the final total amount for the order.

            //TODO: 6) Once the final total is calculated, print it to the console.
        }
    }
}
