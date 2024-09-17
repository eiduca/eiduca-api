package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Test data range repository")
abstract class DataRangeRepositoryTest<T: DataRangeModel>(
    private val dataRangeRepository: DataRangeRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(dataRangeRepository, model) {

    @Test
    fun findByStartDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByStartDate(model.startDate))
    }

    @Test
    fun findByStartDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByStartDate(model.startDate, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByEndDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByEndDate(model.endDate))
    }

    @Test
    fun findByEndDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByEndDate(model.endDate, AssertUtil.PAGEABLE))
    }

    override fun persistModel(){
        model = dataRangeRepository.save(model)
    }

}