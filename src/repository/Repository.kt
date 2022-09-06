package repository

import model.Fare
import model.Operator
import java.util.*

class Repository<T> {
    private var fakeDatabase: MutableList<T> = ArrayList()
    fun insert(model: T) {
        fakeDatabase.add(model)
    }

    val getAll: List<T>
        get() = fakeDatabase

    fun getById(id: UUID): Optional<T> {
        return fakeDatabase.stream()
            .filter { x: T ->
                if (x is Fare) {
                    return@filter (x as Fare).id === id
                } else {
                    return@filter (x as Operator).id === id
                }
            }
            .findFirst()
    }

    fun update(id: UUID, model: T) {
        val modelUpdate = getById(id)
        if (modelUpdate.isPresent) {
            fakeDatabase.remove(modelUpdate.get())
            fakeDatabase.add(model)
        } else {
            throw NoSuchElementException()
        }
    }

    fun deleteById(id: UUID) {
        val modelDeleted = getById(id)
        if (modelDeleted.isPresent) {
            fakeDatabase.remove(modelDeleted.get())
        } else {
            throw NoSuchElementException()
        }
    }
}