package app.com.eiduca.module.candidacy.common.datatimerange

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@DisplayName("Test datetime range repository")
abstract class DateTimeRangeRepositoryTest<T: DateTimeRangeModel>(
    private val dateTimeRangeRepository: DateTimeRangeRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(dateTimeRangeRepository, model){

    @Test
    fun findByStartDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dateTimeRangeRepository.findByStartDateTime(model.startDateTime))
    }

    @Test
    fun findByStartDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dateTimeRangeRepository.findByStartDateTime(model.startDateTime, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByEndDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dateTimeRangeRepository.findByEndDateTime(model.endDateTime))
    }

    @Test
    fun findByEndDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dateTimeRangeRepository.findByEndDateTime(model.endDateTime, AssertUtil.PAGEABLE))
    }

    override fun persistModel(){
        model = dateTimeRangeRepository.save(model)
    }
}