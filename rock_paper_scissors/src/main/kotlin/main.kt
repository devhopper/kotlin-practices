fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice: String = getGameChoice(options)
    val userChoice: String = getUserChoice(options)

    printResult(userChoice, gameChoice)

}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {

    var validChoice = ""
    var isValidChoice = false

    while (!isValidChoice) {

        print("Choose one:")
        for (item in optionsParam) print(" $item")
        println(".")

        var userChoiceInput = readLine()
        userChoiceInput = userChoiceInput!!.capitalize()

        if (userChoiceInput in optionsParam) {
            validChoice = userChoiceInput
            isValidChoice = true
        } else {
            println("Please enter valid choice.")
        }
    }

    return validChoice
}

fun printResult(userChoice: String, gameChoice: String) {

    var result = ""

    result = if ((userChoice == "Rock" && gameChoice == "Scissors")
        || (userChoice == "Paper" && gameChoice == "Rock")
        || (userChoice == "Scissors" && gameChoice == "Paper")
    ) {
        "You Won!"
    } else if (userChoice == gameChoice) {
        "Tie!"
    } else {
        "You Lose!"
    }

    println("Your choice is $userChoice and game choice is $gameChoice.")
    println(result)
}