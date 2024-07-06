 # AlkeWallet

AlkeWallet is a robust Spring Boot application that simulates a digital wallet system with advanced financial management capabilities. This project showcases the implementation of a secure, scalable, and feature-rich banking solution using modern Java technologies. It provides functionality for managing clients, accounts, and transactions in a secure environment.


## 🌟 Features

- **User Authentication & Authorization**: Secure login system with role-based access control (ADMIN and USER roles).
    - User authentication and authorization
    - Role-based access control
- **Account Management**: Create, view, and manage multiple account types (CHECKING, SAVING).
    - Create new accounts
    - View all accounts
    - Delete accounts
    - Show account details and operations
- **Transaction Processing**: Support for deposits, withdrawals, and inter-account transfers.
    - Deposit funds
    - Withdraw funds
    - Transfer funds between accounts
- **Client Management**: CRUD operations for client information.
    - Create new clients
    - View all clients
    - Delete clients
- **Admin Dashboard**: Centralized management interface for system administrators.
- **Transaction History**: Detailed logs of all financial transactions.
    - View all transactions
    - Display transactions by client
- **Security**: Implements Spring Security with custom UserDetailsService and BCrypt password encoding.

## 🛠 Technology Stack

- **Backend**: Java 11+, Spring Boot 3.x
- **Security**: Spring Security
- **Database**: MySQL
- **ORM**: Hibernate (Spring Data JPA)
- **Frontend**: Thymeleaf (implied from controller return statements)
- **Build Tool**: Maven (inferred from project structure)

## 🏗 Architecture

The project follows a layered architecture:

1. **Presentation Layer**: Controllers handle HTTP requests and responses.
2. **Service Layer**: Business logic and transaction management.
3. **Repository Layer**: Data access and persistence.
4. **Security Layer**: Authentication, authorization, and access control.

## 📁 Project Structure

```
com.alkewallet
├── config
│   └── SecurityConfig.java           # Security configuration
├── controller                        # Request handling
├── dto                               # Data Transfer Objects
├── entity                            # JPA entities
├── repository                        # Data access interfaces
└── service                           # Business logic implementation
```

## `🔑` Key Components

1. **SecurityConfig**: Configures Spring Security, defining access rules and authentication mechanisms.
2. **CustomUserDetailsService**: Implements UserDetailsService for database-backed user authentication.
3. **AccountService**: Manages account-related operations including balance updates and transfers.
4. **TransactionService**: Handles and logs all financial transactions.
5. **DataInitializer**: Bootstraps the application with initial roles and users.

## `🔑` Key Components HTML

1. **Admin Dashboard** (`adminWallet.html`):
   - Central hub for all administrative operations

2. **Client Management**:
   - Create new clients (`newClient.html`)
   - View all clients (`allClients.html`)
   - Delete clients (`deleteClient.html`)

3. **Account Management**:
   - Create new accounts (`newAccount.html`)
   - View all accounts (`allAccounts.html`)
   - Delete accounts (`deleteAccount.html`)
   - Show account details (`showAccount.html`)

4. **Transaction Operations**:
   - Deposit (`deposit.html`)
   - Withdrawal (`withdrawal.html`)
   - Transfer (`transfer.html`)

5. **Transaction Tracking**:
   - View all transactions (`allTransactions.html`)
   - Select client for transaction view (`selectClient.html`)
   - View transactions by client (`transactionsByClient.html`)


## 🚀 Getting Started

1. Clone the repository:

- git clone https://github.com/georaiser/AlkeWallet.git

2. Configure MySQL database in `src/main/resources/application.properties`:

- spring.datasource.url=jdbc:mysql://localhost:3306/AlkeWallet
- spring.datasource.username=root
- spring.datasource.password=****

3. Build and run the application:

- ./mvnw spring-boot:run

4. Access the application at `http://localhost:8080`

## 👥 Default Users

- Admin: `username: admin, password: admin`
- User: `username: user, password: user`

## 🔒 Security Implementation

- BCrypt password encoding
- Role-based access control (RBAC)
- Custom access denied handler
- Secure session management

## 🗄 Database Schema

The application uses MySQL with Hibernate's `ddl-auto=update` for schema generation. Key entities include:

- User
- Role
- Account
- Client
- Transaction

## 🌐 API Endpoints

- `/login`: Authentication
- `/accounts/*`: Account management
- `/clients/*`: Client operations
- `/transactions/*`: Transaction processing and history
- `/adminWallet`: Admin dashboard

## 🧪 Testing

[Add information about your testing strategy, including unit tests, integration tests, and how to run them]

## 📈 Performance Considerations

- Uses Spring Data JPA for efficient database operations
- Implements proper transaction management for data integrity

## 🛡 Security Best Practices

- Implements HTTPS (to be configured in production)
- Uses prepared statements to prevent SQL injection
- Implements CSRF protection
- Secure password storage using BCrypt

## 🚧 Future Enhancements

1. Implement multi-factor authentication
2. Add support for international transactions
3. Integrate with external payment gateways
4. Develop a mobile application for the wallet system

## 🤝 Contributing

Contributions to AlkeWallet are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch: `git checkout -b feature-branch-name`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature-branch-name`
5. Submit a pull request

## 📄 License

[license information]

## 📞 Contact

### Jorge Rodriguez
[jrodriguez.geoai@gmail.com] [jrodriguez.geoai@gmail.com]
[https://www.linkedin.com/in/jrodrigueze/] [https://www.linkedin.com/in/jrodrigueze/]

Project Link: [https://github.com/georaiser/AlkeWallet](https://github.com/georaiser/AlkeWallet)

This comprehensive README provides a detailed overview of the AlkeWallet project, including its features, architecture, setup instructions, technical stack, key components, and various other aspects that would be valuable for users and contributors. It's formatted for clear readability on GitHub and includes emojis for visual appeal.

