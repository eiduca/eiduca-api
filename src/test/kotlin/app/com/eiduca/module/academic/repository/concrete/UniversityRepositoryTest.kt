package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.junit.jupiter.api.Assertions.*

@DataJpaTest
@DisplayName("Test of university repository")
class UniversityRepositoryTest(
   @Autowired var universityRepository: UniversityRepository
): CompanyRepositoryTest<University>(universityRepository, UniversityCreate.UNIVERSITY_SAVE){

   @Test
   @DisplayName("Find university by type when successful, return list")
   fun findByType_ReturnList_WhenSuccessful() {
      runner()
      persistModel()
      AssertUtil.assert(universityRepository.findByType(model.type))
   }

   @Test
   @DisplayName("Find university by type when successful, return list pageable")
   fun findByType_ReturnPage_WhenSuccessful() {
      runner()
      persistModel()
      AssertUtil.assert(universityRepository.findByType(model.type, AssertUtil.PAGEABLE))
   }

   override fun runner() = universityRepository.deleteAll()

   override fun persistModel(){
      universityRepository.findByName(model.name).orElse(universityRepository.save(model))
   }
}