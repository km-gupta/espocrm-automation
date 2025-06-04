# EspoCRM Automation

This project provides an automated testing framework for [EspoCRM](https://github.com/espocrm/espocrm), aiming to streamline the testing process and ensure the reliability of CRM functionalities.

## Features

* **Automated Test Execution**: Leverages Selenium WebDriver for automating browser interactions with EspoCRM.
* **TestNG Integration**: Utilizes TestNG for structured test case management and execution.
* **Modular Design**: Organized codebase with clear separation between test scripts, configurations, and outputs.
* **Comprehensive Reporting**: Generates detailed test reports for analysis and debugging.

## Project Structure

```
espocrm-automation/
├── .settings/             # IDE-specific settings
├── src/                   # Source code for test cases
├── target/                # Compiled classes and build artifacts
├── test-output/           # TestNG reports and outputs
├── .classpath             # Classpath configuration file
├── .project               # Project configuration file
├── pom.xml                # Maven project descriptor
├── smoke-test.xml         # TestNG suite configuration
└── README.md              # Project documentation
```

## Getting Started

### Prerequisites

* **Java Development Kit (JDK)**: Version 8 or higher
* **Apache Maven**: For project build and dependency management
* **EspoCRM Instance**: Accessible URL for testing
* **WebDriver**: Compatible with your preferred browser (e.g., ChromeDriver for Google Chrome)([github.com][1])

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/km-gupta/espocrm-automation.git
   cd espocrm-automation
   ```

2. **Configure WebDriver**:

   * Download the appropriate WebDriver for your browser.
   * Ensure the WebDriver executable is in your system's PATH or specify its location in the test configuration.

3. **Set Up EspoCRM URL**:

   * Update the test configuration files to point to your EspoCRM instance.([github.com][2])

### Running Tests

Execute the test suite using Maven:

```bash
mvn clean test
```

This command will compile the test cases and run them as defined in the `smoke-test.xml` TestNG suite.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.


---


[1]: https://github.com/espocrm/espocrm?utm_source=chatgpt.com "EspoCRM – Open Source CRM Application - GitHub"
[2]: https://github.com/espocrm/documentation/blob/master/docs/administration/server-configuration.md?utm_source=chatgpt.com "Server Configuration for EspoCRM - GitHub"
