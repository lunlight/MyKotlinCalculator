fun main() {
    println("Welcome to MyKotlinCalculator!")

    // Loop for multiple calculations
    while (true) {
        try {
            // Get first number
            print("\nEnter first number: ")
            val num1 = readLine()?.toDouble() ?: throw IllegalArgumentException("Invalid input")

            // Get second number
            print("Enter second number: ")
            val num2 = readLine()?.toDouble() ?: throw IllegalArgumentException("Invalid input")

            // Display operation choices
            println("\nChoose an operation:")
            println("1. Addition (+)")
            println("2. Subtraction (-)")
            println("3. Multiplication (*)")
            println("4. Division (/)")
            println("5. Exit")

            // Get operation choice
            print("\nEnter your choice (1-5): ")
            val choice = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid choice")

            if (choice == 5) {
                println("Thank you for using MyKotlinCalculator!")
                break
            }

            if (choice !in 1..4) {
                println("Error: Please select a valid operation (1-4)")
                continue
            }

            // Perform calculation based on choice
            val result = when (choice) {
                1 -> num1 + num2
                2 -> num1 - num2
                3 -> num1 * num2
                4 -> {
                    if (num2 == 0.0) {
                        throw ArithmeticException("Division by zero is not allowed")
                    }
                    num1 / num2
                }
                else -> throw IllegalArgumentException("Invalid operation")
            }

            // Format and display result
            val operation = when (choice) {
                1 -> "+"
                2 -> "-"
                3 -> "*"
                4 -> "/"
                else -> ""
            }

            println("\nResult: $num1 $operation $num2 = ${String.format("%.2f", result)}")

        } catch (e: NumberFormatException) {
            println("Error: Please enter valid numbers")
        } catch (e: ArithmeticException) {
            println("Error: ${e.message}")
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }

        // Ask if user wants to continue
        print("\nWould you like to perform another calculation? (y/n): ")
        val shouldContinue = readLine()?.lowercase()
        if (shouldContinue != "y") {
            println("Thank you for using MyKotlinCalculator!")
            break
        }
    }
}