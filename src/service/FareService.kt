package service

import controller.OperatorController
import model.Fare
import repository.Repository
import java.time.Period
import java.util.*


class FareService {

    private val repository: Repository<Fare> = Repository()
    private var operatorController: OperatorController? = null

    fun createFare(fare: Fare, code: String?, operatorController: OperatorController): Optional<Fare> {
        this.operatorController = operatorController
        fare.operatorId = operatorController.getOperatorByCode(code).id
        return if (verifyIfIsValid(fare)) {
            repository.insert(fare)
            Optional.of(fare)
        } else {
            Optional.empty()
        }
    }

    val allFares: List<Fare>
        get() = repository.getAll

    fun getFareById(id: UUID?): Fare {
        return repository.getById(id!!)
            .orElseThrow { NoSuchElementException("Fare not found in system!") }
    }

    fun updateFare(id: UUID?, fare: Fare?) {
        id?.let { fare?.let { it1 -> repository.update(it, it1) } }
    }

    fun deleteFare(id: UUID?) {
        if (id != null) {
            repository.deleteById(id)
        }
    }

    private fun verifyIfIsValid(fare: Fare): Boolean {
        val faresArray = allFares
        val fareToFind = faresArray.stream()
            .filter { x: Fare ->
                (x.operatorId!!.equals(fare.operatorId) && x.value!!.equals(fare.value)
                        && Period.between(x.creationDate, fare.creationDate).months < 6
                        && x.status!!.equals(1))
            }
            .findFirst()
        return !fareToFind.isPresent
    }

}