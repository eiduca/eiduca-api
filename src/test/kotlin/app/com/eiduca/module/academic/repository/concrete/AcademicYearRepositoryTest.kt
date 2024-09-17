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
    fun findByName_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        academicYearRepository.findByName(model.name).ifPresentOrElse({
            assert(it.name == model.name)
        }, {throw NotFoundException("Not found academicYear by name") })
    }

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        academicYearRepository.findByCode(model.code).ifPresentOrElse({
            assert(it.code == model.code)
        }, {throw NotFoundException("Not found academicYear by code") })
    }

    override fun persistModel() {
        model = academicYearRepository.findByName(model.name).orElse(academicYearRepository.save(model))
    }

    override fun runner() = academicYearRepository.deleteAll()
}