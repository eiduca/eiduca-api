package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.exception.NotFoundException
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
   @DisplayName("Find university by type when successful")
   fun findByType_WhenSuccessful() {
      assertDoesNotThrow {
         val university = universityRepository.save(UniversityCreate.UNIVERSITY_SAVE)
         universityRepository.findByType(university.type).ifPresentOrElse({
            assertEquals(it.id, university.id)
         },{throw NotFoundException("Not found university by type") })
      }
   }

   @Test
   @DisplayName("Find university by name when successful")
   fun findByName_WhenSuccessful() = findByName()

   @Test
   @DisplayName("Find university by email when successful")
   fun findByEmail_WhenSuccessful() = findByEmail()

   @Test
   @DisplayName("Find university by acronym when successful")
   fun findByAcronym_WhenSuccessful() = findByAcronym()

   @Test
   @DisplayName("Find university by contact when successful")
   fun findByContact_WhenSuccessful() = findByContact()

   @Test
   @DisplayName("Find university by website when successful")
   fun findByWebsite_WhenSuccessful() = findByWebsite()

   @Test
   @DisplayName("Find university by foundingDate when successful")
   fun findByFoundingDate_WhenSuccessful() = findByFoundingDate()
}