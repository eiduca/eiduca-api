package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.datarange.DataRangeServiceTest
import app.com.eiduca.module.academic.create.concrete.AcademicYearCreate
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.repository.concrete.AcademicYearRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@DisplayName("Test of academicYear service")
class AcademicYearServiceTest: DataRangeServiceTest<AcademicYear >() {

    @InjectMocks
    lateinit var academicYearService: AcademicYearService

    @Mock
    lateinit var academicYearRepository: AcademicYearRepository

    @BeforeEach
    fun setUpAcademicYear() {
        setUpDateRange(academicYearService, academicYearRepository, AcademicYearCreate.ACADEMIC_YEAR_SAVE)
        BDDMockito.`when`(academicYearRepository.findByName(model.name)).thenReturn(Optional.of(model))
        BDDMockito.`when`(academicYearRepository.findByCode(model.code )).thenReturn(Optional.of(model))
    }

    @Test
    @DisplayName("Find academicYear by name when successful")
    fun findByName_WhenSuccessful() {
        assertDoesNotThrow {
            val dataRangeSave = academicYearService.save(model)
            val dataRangeFound = academicYearService.findByName(model.name)
            assertEquals(dataRangeSave,dataRangeFound)
        }
    }

    @Test
    @DisplayName("Find academicYear by code when successful")
    fun findByCode_WhenSuccessful() {
        assertDoesNotThrow {
            val dataRangeSave = academicYearService.save(model)
            val dataRangeFound = academicYearService.findByCode(model.code)
            assertEquals(dataRangeSave,dataRangeFound)
        }
    }

/*
    @Test
    @DisplayName("Find academicYear by startDate when successful")
    fun findByStartDate_WhenSuccessful() = findByStartDate()

    @Test
    @DisplayName("Find academicYear by endDate when successful")
    fun findByEndDate_WhenSuccessful() = findByEndDate()
 */
}