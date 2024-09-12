package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.create.pivot.InstitutionAddressCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.core.common.general.CommonRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.Test

@DataJpaTest
@DisplayName("Test of address of institution repository")
class InstitutionAddressRepositoryTest(
    @Autowired var institutionAddressRepository: InstitutionAddressRepository,
    @Autowired var testEntityManager: TestEntityManager
): CommonRepositoryTest<InstitutionAddress>(
    institutionAddressRepository,
    InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE
){

    @Test
    @DisplayName("Find address of institution by institution and address when successful")
    fun findByInstitutionAndAddress_WhenSuccessful(){
        runner()
        persistModel()
        institutionAddressRepository.findByInstitutionAndAddress(model.institution, model.address).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found address of institution by institution and address") }
        )
    }

    override fun runner() {
        model.institution.university = testEntityManager.findOrSave(model.institution.university)
        model.institution = testEntityManager.findOrSave(model.institution)
        model.address = testEntityManager.findOrSave(model.address)
    }

    override fun persistModel() {
        model = testEntityManager.persistFlushFind(model)
    }
}