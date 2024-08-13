package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PersonConcreteRepository: ConcreteRepository<Person>, RevisionRepository<Person, String, Long>{
    @Query(name = "SELECT p FROM Person p WHERE username = :username WHERE deletedBy IS NULL AND deletedAt IS NULL")
    fun findByUsername(username: String): Optional<Person>
}