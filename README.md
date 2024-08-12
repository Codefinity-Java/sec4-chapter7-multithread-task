<h1>CompletableFuture Challenge</h1>

  <h2>Task</h2>
  <p>Your task is to create a system that processes orders and performs additional calculations such as tax and shipping calculations. You need to process several orders asynchronously, perform calculations, and output the total amount for each order after all calculations are completed.</p>

  <h2>Details</h2>
  <ul>
      <li>Each order has a unique identifier and a price associated with it. (See <strong>InitMap</strong> class).</li>
      <li>Order IDs and their sums are stored in a Map within the <strong>InitMap</strong> class. These Map keys (order IDs) are looped through in the <strong>processOrders()</strong> method.</li>
  </ul>

  <h2>Order Processing</h2>
  <p>Fetching order data is performed asynchronously and returns the order amount. See the <strong>OrderService</strong> class and its <code>fetchOrderAmount(String orderId)</code> method.</p>

  <h2>Calculations</h2>
  <p>The following calculations are required:</p>
  <ul>
      <li>Tax is calculated as 15% of the order amount. See <strong>CalculationService</strong> method <code>calculateTax()</code>.</li>
      <li>Shipping cost is calculated as 10% of the order amount. See <strong>CalculationService</strong> method <code>calculateShipping()</code>.</li>
  </ul>

  <div class="code-block">
      <strong>Note:</strong><br>
      Your main task is to implement the logic step-by-step in the <strong>OrderProcessingExample</strong> class within the <strong>task</strong> package, specifically in the <code>processOrders()</code> method.
  </div>
