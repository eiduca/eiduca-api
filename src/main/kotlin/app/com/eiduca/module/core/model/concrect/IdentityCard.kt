package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.ConcreteModel
import app.com.eiduca.module.core.enums.MaritalStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.envers.Audited
import java.time.LocalDate

@Entity
@Audited
@Table(name="tb_identity_card")
class IdentityCard(
    @ManyToOne  var person: Person,
    @Enumerated(EnumType.STRING) var maritalStatus: MaritalStatus = MaritalStatus.SINGLE,
    var residential: String,
    var naturalFrom: String,
    var emittedIn: String,
    var emittedAt: LocalDate,
    var validAt: LocalDate,
): ConcreteModel() {

    constructor(): this(Person(),MaritalStatus.SINGLE,"","","",LocalDate.now(),LocalDate.now())

    override fun toString(): String {
        return "IdentityCard(${setToString("person=$person, maritalStatus=$maritalStatus, residential='$residential', naturalFrom='$naturalFrom', emittedIn='$emittedIn', emittedAt=$emittedAt, validAt=$validAt")})"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is IdentityCard) return false
        if(other.person != person) return false
        return other.emittedAt == emittedAt && other.validAt == validAt
    }

    override fun hashCode(): Int = person.hashCode() + emittedAt.hashCode() + validAt.hashCode()
}