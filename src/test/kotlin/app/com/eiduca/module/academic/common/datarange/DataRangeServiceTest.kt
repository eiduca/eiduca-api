package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl

@DisplayName("Test data range service")
abstract class DataRangeServiceTest <T: DataRangeModel>: ConcreteServiceTest<T>(){

    private lateinit var dataRangeService: DataRangeService<T>
    private lateinit var dataRangeRepository: DataRangeRepository<T>

    fun setUpDateRange(dataRangeService: DataRangeService<T>, dataRangeRepository: DataRangeRepository<T>, model: T) {
        setUpConcrete(dataRangeService, dataRangeRepository, model)
        this.dataRangeRepository = dataRangeRepository
        this.dataRangeService = dataRangeService
        this.model = model

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(dataRangeRepository.findByStartDate(model.startDate)).thenReturn(list)
        BDDMockito.`when`(dataRangeRepository.findByStartDate(model.startDate, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(dataRangeRepository.findByEndDate(model.endDate)).thenReturn(list)
        BDDMockito.`when`(dataRangeRepository.findByEndDate(model.endDate, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByStartDate_ReturnList_WhenSuccessful() {
        dataRangeService.save(model)
        AssertUtil.assert(dataRangeService.findByStartDate(model.startDate))
    }

    @Test
    fun findByStartDate_ReturnPage_WhenSuccessful() {
        dataRangeService.save(model)
        AssertUtil.assert(dataRangeService.findByStartDate(model.startDate, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByEndDate_ReturnList_WhenSuccessful() {
        dataRangeService.save(model)
        AssertUtil.assert(dataRangeService.findByEndDate(model.endDate))
    }

    @Test
    fun findByEndDate_ReturnPage_WhenSuccessful() {
        dataRangeService.save(model)
        AssertUtil.assert(dataRangeService.findByEndDate(model.endDate, AssertUtil.PAGEABLE))
    }
}