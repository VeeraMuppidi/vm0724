**Tool Rental Application**

This is a simple tool rental application that allows users to rent tools and generate rental agreements.

 **How to Clone and Run the Application**

 **Prerequisites**

- Java Development Kit (JDK) installed
- An IDE (Integrated Development Environment) like Eclipse or IntelliJ IDEA
- Git installed

 **Steps to Clone the Project**

1. **Clone the Repository**:
   
    git clone https://github.com/VeeraMuppidi/vm0724.git
    

3. **Open the Project in Your IDE**:
    - Open your IDE.
    - Select the option to open a project from the file system.
    - Navigate to the directory where you cloned the project and select it.

4. **Run the Main Application**:
    - In your IDE, navigate to the `src/com/tools` package.
    - Open the `RentalToolApplication.java` file.
    - Run the `RentalToolApplication.java` file as a Java application.
    - In the console, enter the inputs when prompted: tool code, rental days, discount, and check-out date.
    - The output will be printed on the console.

 **Running JUnit Test Cases**

1. **Navigate to the Test Package**:
    - In your IDE, go to the `Test` package.

2. **Run the Test Cases**:
    - Open the `CheckoutTest.java` file.
    - Run the `CheckoutTest.java` file as a JUnit test.
    - The results of the test cases will be displayed in the JUnit test runner.

## Example Input

When prompted in the console, enter the following inputs:

 - Tool code: `LADW`
 - Rental days: `5`
 - Discount percent: `10`
 - Check-out date: `2024-07-02`

The application will generate a rental agreement and print it on the console as follows

 - Tool code: LADW
 - Tool type: Ladder
 - Tool brand: Werner
 - Rental days: 3
 - Check out date: 07/02/20
 - Due date: 07/05/20
 - Daily rental charge: $1.99
 - Charge days: 2
 - Pre-discount charge: $3.98
 - Discount percent: 10%
 - Discount amount: $0.40
 - Final charge: $3.58

## Application Execution - Successful Run Screenshot
<img width="1425" alt="Console_Output_Success" src="https://github.com/VeeraMuppidi/vm0724/assets/175083846/6c8f92d0-c94b-46b8-ae7a-2ae0b9a7ccdf">

## JUnit Test Cases - Successful Execution
<img width="1425" alt="Junits Tests Success" src="https://github.com/VeeraMuppidi/vm0724/assets/175083846/3e0018d9-579f-495d-b555-61a05ea57915">



