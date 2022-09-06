package model

import java.time.LocalDate
import java.util.*

class Fare {
    var id: UUID? = null
    var operatorId: UUID? = null
    var status: Int? = null
    var value: Double? = null
    var creationDate: LocalDate? = null

    override fun toString(): String {
        return "Fare{" +
                "id=" + id +
                ", operatorId=" + operatorId +
                ", status=" + status +
                ", value=" + value +
                ", creationDate=" + creationDate +
                '}'
    }
}