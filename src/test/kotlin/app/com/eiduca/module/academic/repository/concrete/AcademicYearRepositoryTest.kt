package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.datarange.DataRangeRepositoryTest
import app.com.eiduca.module.academic.create.concrete.AcademicYearCreate
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of academicYear repository")
class AcademicYearRepositoryTest(
    @Autowired var academicYearRepository: AcademicYearRepository
): DataRangeRepositoryTest<AcademicYear>(academicYearRepository, AcademicYearCreate.ACADEMIC_YEAR_SAVE) {

    @Test
    @DisplayName("Find academicYear by name when successful")
    fun findByName_WhenSuccessful(){
        val academicYear = AcademicYearCreate.ACADEMIC_YEAR_SAVE
        academicYearRepository.save(academicYear)
        academicYearRepository.findByName(academicYear.name).ifPresentOrElse({
            assert(it.name == academicYear.name)
        }, {throw NotFoundException("Not found academicYear by name") })
    }

    @Test
    @DisplayName("Find academicYear by code when successful")
    fun findByCode_WhenSuccessful() {
        val academicYear = AcademicYearCreate.ACADEMIC_YEAR_SAVE
        academicYearRepository.save(academicYear)
        academicYearRepository.findByCode(academicYear.code).ifPresentOrElse({
            assert(it.code == academicYear.code)
        }, {throw NotFoundException("Not found academicYear by code") })
    }

    @Test
    @DisplayName("Find academicYear by startDate when successful")
    fun findByStartDate_WhenSuccessful() = findByStartDate()

    @Test
    @DisplayName("Find academicYear by endDate when successful")
    fun findByEndDate_WhenSuccessful() = findByEndDate()
}