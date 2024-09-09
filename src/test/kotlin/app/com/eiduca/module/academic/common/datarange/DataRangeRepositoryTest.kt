package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.ConcreteRepositoryTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

abstract class DataRangeRepositoryTest<T: DataRangeModel>(
    private val dataRangeRepository: DataRangeRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(dataRangeRepository, model) {

    @Test
    @DisplayName("Find dataRangeModel by startDate when successful, return list")
    fun findByStartDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByStartDate(model.startDate))
    }

    @Test
    @DisplayName("Find dataRangeModel by startDate when successful, return list pageable")
    fun findByStartDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByStartDate(model.startDate, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find dataRangeModel by endDate when successful, return list")
    fun findByEndDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByEndDate(model.endDate))
    }

    @Test
    @DisplayName("Find dataRangeModel by endDate when successful, return list pageable")
    fun findByEndDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(dataRangeRepository.findByEndDate(model.endDate, AssertUtil.PAGEABLE))
    }

    override fun persistModel(){
        model = dataRangeRepository.save(model)
    }

}