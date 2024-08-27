package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of institution repository")
class InstitutionRepositoryTest(
    @Autowired val institutionRepository: InstitutionRepository,
    @Autowired val universityRepository: UniversityRepository
): CompanyRepositoryTest<Institution>(institutionRepository,InstitutionCreate.INSTITUTION_SAVE) {

    @Test
    @DisplayName("Find institution by type when successful")
    fun findByType_WhenSuccessful() {
        assertDoesNotThrow {
            val institution = createInstitution(InstitutionCreate.INSTITUTION_SAVE)
            institutionRepository.findByType(institution.type).ifPresentOrElse({
                assertEquals(it.id, institution.id)
            },{throw NotFoundException("Not found institution by type") })
        }
    }

    @Test
    @DisplayName("Find institution by name when successful")
    fun findByName_WhenSuccessful() {
        model.university = createUniversity(model)
        findByName()
    }

    @Test
    @DisplayName("Find institution by email when successful")
    fun findByEmail_WhenSuccessful(){
        model.university = createUniversity(model)
        findByEmail()
    }

    @Test
    @DisplayName("Find institution by acronym when successful")
    fun findByAcronym_WhenSuccessful(){
        model.university = createUniversity(model)
        findByAcronym()
    }

    @Test
    @DisplayName("Find institution by contact when successful")
    fun findByContact_WhenSuccessful(){
        model.university = createUniversity(model)
        findByContact()
    }

    @Test
    @DisplayName("Find institution by website when successful")
    fun findByWebsite_WhenSuccessful(){
        model.university = createUniversity(model)
        findByWebsite()
    }

    @Test
    @DisplayName("Find institution by foundingDate when successful")
    fun findByFoundingDate_WhenSuccessful(){
        model.university = createUniversity(model)
        findByFoundingDate()
    }

    private fun createUniversity(institution: Institution): University {
        return universityRepository.save(institution.university)
    }

    private fun createInstitution(institution: Institution): Institution{
        institution.university = createUniversity(institution)
        return institutionRepository.save(institution)
    }
}