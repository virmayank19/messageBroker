# **Topic-Based Message Broker**

A simple message broker implementation in Java with support for topics, enabling efficient parallel publishing and message delivery.

## **Features**
- Topic-based queue system for organized message distribution.
- Parallelism in publishing and consuming messages using **Executor Service**.
- Dependency injection with **Google Guice** for clean and modular design.

## **Technologies Used**
- Java 17  
- Maven 3.8.1  

## **Getting Started**

### **Prerequisites**
Ensure you have the following installed:
- Java 17  
- Maven 3.8.1  

### **Installation**
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd message-broker
2. Build the project using Maven
   ```bash
   mvn clean install
## Usage

Publish and consume messages through the provided API or via integrated tests.
Example
Create a topic.
Publish messages to the topic.
Subscribe to the topic to receive messages.

Run the application:
  ```bash
  java -jar target/message-broker-1.0.jar
