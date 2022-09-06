package model
import java.util.*

class Operator {
    var id: UUID? = null
    var code: String? = null

    constructor(id: UUID?, code: String?) {
        this.id = id
        this.code = code
    }

    override fun toString(): String {
        return "Operator{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}'
    }
}

