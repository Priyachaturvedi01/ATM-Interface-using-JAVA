# ATM-Interface-using-JAVA
# ATM Interface
This project simulates an Automated Teller Machine (ATM) interface implemented in Java. It allows
users to interact with a bank account through a command-line interface (CLI), offering functionalities
such as checking balance, depositing money, withdrawing money, transferring funds to another
account, and viewing transaction history.
## Features
- **Check Balance**: Display the current balance of the bank account.
- **Deposit**: Add money to the account.
- **Withdraw**: Deduct money from the account, provided sufficient funds are available.
- **Transfer**: Send money from one account to another, with validation for sufficient funds.
- **Transaction History**: View a list of all transactions performed on the account.
- **Quit**: Exit the ATM interface.
## Implementation Details
### Classes and Their Responsibilities
1. **Transaction**: Represents a single transaction with attributes such as amount, type
(withdrawal, deposit, transfer), and timestamp.
2. **TransactionHistory**: Manages a list of transactions associated with an account. It provides
methods to add transactions and retrieve transaction history.
3. **Account**: Models a bank account with methods to perform transactions (deposit, withdraw,
transfer), check balance, and print transaction history. It utilizes `TransactionHistory` to record and
manage transactions.
4. **ATMInterface**: Implements a command-line interface for users to interact with the `Account`
class. It handles user input/output, validates inputs, and orchestrates operations such as deposit,
withdrawal, transfer, and history display.
### How to Use
1. **Clone the Repository**: Clone this repository to your local machine.
```bash
git clone https://github.com/your-username/atm-interface-java.git
```
2. **Compile and Run**: Navigate to the project directory and compile the Java files.
```bash
javac *.java
```
Run the ATM interface application.
```bash
java ATMInterface
```
3. **Follow the Menu**: Once the program is running, follow the on-screen menu to perform
desired operations:
- Enter the number corresponding to your choice and follow the prompts.
- For example, to deposit money, select option 2, enter the deposit amount when prompted, and
press Enter.
- Similarly, for other operations like withdrawal, transfer, or viewing transaction history, follow the
corresponding menu options.
### Example Usage
- **Checking Balance**:
```plaintext
Enter your choice: 1
Balance: $500.0
```
- **Depositing Money**:
```plaintext
Enter your choice: 2
Enter deposit amount: 100
```
- **Withdrawing Money**:
```plaintext
Enter your choice: 3
Enter withdrawal amount: 50
```
- **Transferring Money**:
```plaintext
Enter your choice: 4
Enter recipient account number: 54321
Enter transfer amount: 200
```
- **Viewing Transaction History**:
```plaintext
Enter your choice: 5
Transaction history for account: 12345
Timestamp Type Amount
Thu Jun 28 12:00:00 UTC 2024 deposit $100.0
Thu Jun 28 12:15:00 UTC 2024 withdraw $50.0
Thu Jun 28 12:30:00 UTC 2024 transfer $200.0
```
- **Quitting**:
```plaintext
Enter your choice: 6
Thank you for using ATM. Goodbye!
```
