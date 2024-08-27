package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.exception.NotFoundException

abstract class DataRangeRepositoryTest<T: DataRangeModel>(
    val repository: DataRangeRepository<T>,
    val model: T
) {

    fun findByStartDate() {
        repository.save(model)
        repository.findByStartDate(model.startDate).ifPresentOrElse({
            assert(it.startDate == model.startDate)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by startDate") })
    }

    fun findByEndDate() {
        repository.save(model)
        repository.findByEndDate(model.endDate).ifPresentOrElse({
            assert(it.endDate == model.endDate)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by endDate") })
    }
}