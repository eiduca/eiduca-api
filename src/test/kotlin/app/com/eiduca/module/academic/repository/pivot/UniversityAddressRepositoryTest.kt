package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.create.pivot.UniversityAddressCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.core.common.general.CommonRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test of address of university repository")
class UniversityAddressRepositoryTest(
    @Autowired var universityAddressRepository: UniversityAddressRepository,
    @Autowired var testEntityManager: TestEntityManager
): CommonRepositoryTest<UniversityAddress>(
    universityAddressRepository,
    UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE
){
    @Test
    @DisplayName("Find address of university by university and address when successful")
    fun findByInstitutionAndAddress_WhenSuccessful(){
        runner()
        persistModel()
        universityAddressRepository.findByUniversityAndAddress(model.university, model.address).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found address of university by university and address") }
        )
    }

    override fun runner() {
        model.university = testEntityManager.findOrSave(model.university)
        model.address = testEntityManager.findOrSave(model.address)
    }

    override fun persistModel() {
        model = testEntityManager.persistFlushFind(model)
    }
}