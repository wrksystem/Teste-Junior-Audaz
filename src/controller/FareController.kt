package controller

import model.Fare
import service.FareService
import java.util.*


class FareController {

    private val fareService: FareService = FareService()
    fun createFare(fare: Fare?, code: String?, operatorController: OperatorController?): String {
        val fareCreated: Optional<Fare> = fareService.createFare(fare!!, code, operatorController!!)

        return if (fareCreated.isPresent) {
            "Tarifa cadastrada com sucesso!"
        } else {
            "Falha no cadastro da tarifa!"
        }
    }

    val all: List<Fare>
        get() = fareService.allFares

    fun getFareById(id: UUID?): Fare {
        return fareService.getFareById(id)
    }

    fun updateFare(id: UUID?, fare: Fare?) {
        fareService.updateFare(id, fare)
    }

    fun deleteFare(id: UUID?) {
        fareService.deleteFare(id)
    }

}