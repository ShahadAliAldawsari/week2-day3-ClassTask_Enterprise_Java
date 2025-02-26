# Inventory Management System
An advanced Inventory Management System implemented in Java that tracks product inventory, predicts restocking needs, and processes orders using multi-threading for high-volume order management.


## Features
### Product Inventory Management
- Add, display, and manage products with stock levels and reorder thresholds.
- Predict when restocking is needed using average daily sales data.

### Multi-Threaded Order Processing
- Place multiple orders simultaneously.
- Each order is processed in a separate thread using Java's ExecutorService.
- Ensures proper synchronization for accurate order status updates.

### Data Persistence
- Orders are saved to a file (orders.txt) for data persistence.
- Automatically reloads orders when the application restarts.



## Classes Overview
### Main
- Entry point of the application.
- Demonstrates product addition, order placement, and order status display.

### Product
- Represents a product with unique ID, name, price, stock level, and reorder threshold.

### Order
- Represents a customer order with unique ID, product ID, quantity, and status (PENDING, SHIPPED, DELIVERED).

### OrderManager
- Manages products and orders.
- Implements multi-threaded order processing.
- Handles data persistence by saving and loading orders from orders.txt.

### StockPredictor
- Predicts when stock will run out based on average daily sales.
- Suggests restocking strategies based on calculated days until stock-out.



## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or later
- A text editor or an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or VSCode

### Installation
- Clone the repository:
  - git clone https://github.com/your-username/inventory-management-system.git
-Navigate to the project directory:
  - cd inventory-management-system

### Compilation and Execution
- Compile the Java files:
  - javac Main.java OrderManager.java Product.java Order.java StockPredictor.java
- Run the application:
  - java Main

### Usage
- Upon running, the application:
  - Displays available products.
  - Collects average daily sales data to predict restocking needs.
  - Simulates placing multiple orders from different customers.
  - Processes each order in a separate thread.
  - Displays order details and status (PENDING, SHIPPED, or DELIVERED).

### Key Functionalities
1. Inventory Management
  - Add Products: Using addProduct() method in OrderManager.
  - Display Products: Using displayProducts() method.
  - Stock Prediction:
    - Collects average daily sales from the user.
    - Predicts days until stock runs out.
    - Suggests restocking strategies.
2. Multi-Threaded Order Processing
  - Place Orders: Using placeOrder() method.
  - Order Processing:
    - Each order is processed in a separate thread.
    - Simulates order shipment with a delay.
    - Ensures thread safety with synchronized methods.
3. Data Persistence
  - Save Orders:
    - Orders are saved to orders.txt after placement and status updates.
  - Load Orders:
    - Orders are reloaded from the file at startup, preserving state across sessions.

### File Structure
inventory-management-system/
- │
- ├── Main.java               // Entry point of the application
- ├── OrderManager.java       // Manages products, orders, and processing logic
- ├── Product.java            // Represents a product
- ├── Order.java              // Represents a customer order
- ├── StockPredictor.java     // Predicts stock needs and suggests restocking
- └── orders.txt              // Stores order data for persistence

### Future Enhancements
- Add Order Cancellation functionality.
- Implement Order History and Reports.
- Integrate Graphical User Interface (GUI) for better user experience.
- Add Unit Tests for key functionalities.

### Contributing
Contributions are welcome! If you have ideas for improvements or new features:
1. Fork the repository.
2. Create a new branch (feature/YourFeatureName).
3. Commit your changes.
4. Push to the branch.
5. Open a pull request.

### Contact
For questions, suggestions, or collaboration:
- Name: Shahad Ali Aldawsari
- Email: shahodah.ali.email@example.com
- LinkedIn: https://www.linkedin.com/in/shahad-ali-aldawsari-711792221/

