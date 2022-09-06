package controller

import model.Operator
import service.OperatorService
import java.util.*


class OperatorController {
    private val operatorService: OperatorService = OperatorService()
    fun createOperator(operator: Operator?): Operator {
        return operatorService.createOperator(operator!!)
    }

    val allOperators: List<Operator>
        get() = operatorService.allOperators

    fun getOperatorByCode(code: String?): Operator {
        return operatorService.getOperatorByCode(code)
    }

    fun getOperatorById(id: UUID?): Operator {
        return operatorService.getOperatorById(id)
    }

    fun updateOperator(id: UUID?, operator: Operator?) {
        operatorService.updateOperator(id, operator)
    }

    fun deleteOperator(id: UUID?) {
        operatorService.deleteOperator(id)
    }

}