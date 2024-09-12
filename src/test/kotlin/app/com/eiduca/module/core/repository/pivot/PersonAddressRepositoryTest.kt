package app.com.eiduca.module.core.repository.pivot

import app.com.eiduca.module.core.common.general.CommonRepositoryTest
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test of address of person repository")
class PersonAddressRepositoryTest(
    @Autowired val personAddressRepository: PersonAddressRepository,
    @Autowired var testEntityManager: TestEntityManager
): CommonRepositoryTest<PersonAddress>(
    personAddressRepository,
    PersonAddressCreate.PERSON_ADDRESS_SAVE
){

    @Test
    @DisplayName("Find address of person by person and address when successful")
    fun findByPersonAndAddress_WhenSuccessful(){
        runner()
        persistModel()
        personAddressRepository.findByPersonAndAddress(model.person, model.address).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found address of person by by person and address") }
        )
    }

    override fun runner() {
        model.address = testEntityManager.findOrSave(model.address)
        model.person = testEntityManager.findOrSave(model.person)
    }

    override fun persistModel() {
        model = testEntityManager.persistFlushFind(model)
    }
}