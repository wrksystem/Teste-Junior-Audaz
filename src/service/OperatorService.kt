package service

import model.Operator
import repository.Repository
import java.util.*


class OperatorService {
    private val repository: Repository<Operator> = Repository()
    fun createOperator(operator: Operator): Operator {
        repository.insert(operator)
        return operator
    }

    val allOperators: List<Operator>
        get() = repository.getAll

    fun getOperatorById(id: UUID?): Operator {
        return repository.getById(id!!)
            .orElseThrow { NoSuchElementException("Operator not found in system!") }
    }

    fun getOperatorByCode(code: String?): Operator {
        val operators: List<Operator> = repository.getAll
        return operators.stream()
            .filter { x: Operator -> x.code.equals(code) }
            .findFirst()
            .orElseThrow { NoSuchElementException("Operator not found in system!") }
    }

    fun updateOperator(id: UUID?, operator: Operator?) {
        repository.update(id!!, operator!!)
    }

    fun deleteOperator(id: UUID?) {
        repository.deleteById(id!!)
    }

}