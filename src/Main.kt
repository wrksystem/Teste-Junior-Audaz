import controller.FareController
import controller.OperatorController
import model.Fare
import model.Operator
import java.time.LocalDate
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        //Inicialização das variáveis

        val scanner = Scanner(System.`in`)
        val fareController = FareController()
        val operatorController = OperatorController()
        val operator1 = Operator(UUID.randomUUID(), "OP01")
        val operator2 = Operator(UUID.randomUUID(), "OP02")
        val operator3 = Operator(UUID.randomUUID(), "OP03")

        //Inserção de operadoras no fakedatabase
        operatorController.createOperator(operator1)
        operatorController.createOperator(operator2)
        operatorController.createOperator(operator3)
        operatorController.allOperators

        //inserção de tarifas no fakedatabase
        val fare1 = Fare()
        val fare2 = Fare()
        val fare3 = Fare()

        fare1.id= UUID.randomUUID()
        fare1.value = 2.45
        fare1.creationDate= LocalDate.of(2022, 2, 9)
        fare1.status = 1

        fareController.createFare(fare1, "OP01", operatorController)
        fare2.id = UUID.randomUUID()
        fare2.value = 2.59
        fare2.creationDate = LocalDate.of(2022, 4, 15)
        fare2.status = 1

        fareController.createFare(fare2, "OP02", operatorController)
        fare3.id = UUID.randomUUID()
        fare3.value = 2.21
        fare3.creationDate = LocalDate.of(2022, 8, 1)
        fare3.status = 1
        fareController.createFare(fare3, "OP03", operatorController)

        //Input de uma nova tarifa

        val newFare = Fare()

        newFare.id = UUID.randomUUID()
        newFare.status = 1
        newFare.creationDate = LocalDate.now()
        println("Informe o valor da tarifa a ser cadastrada: ")

        val fareValueInput = scanner.next()

        newFare.value = fareValueInput.toDouble()
        println("Informe o código da operador para a tarifa: ")

        val operatorCodeInput = scanner.next()

        //caso a inserção cumpra todos os requisitos retorna mensagem de sucesso, caso contrário mensagem de falha

        System.out.println(fareController.createFare(newFare, operatorCodeInput, operatorController))
    }
}