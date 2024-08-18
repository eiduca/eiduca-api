package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IdentityCardRepository: ConcreteRepository<IdentityCard>, RevisionRepository<IdentityCard, String, Long> {

    @Query(name = "SELECT i FROM IdentityCard i WHERE person = :person AND deletedBy IS NULL AND deletedAt is NULL")
    fun findByPerson(person: Person): Optional<IdentityCard>

}