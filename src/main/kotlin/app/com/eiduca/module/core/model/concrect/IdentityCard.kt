package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.interfaces.IConvertRequest
import app.com.eiduca.module.core.request.IdentityCardRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.envers.Audited
import java.time.LocalDate

@Entity
@Audited
@Table(name="tb_identity_cards")
class IdentityCard(
    @Column(unique = true) var code: String,
    var residential: String,
    var naturalFrom: String,
    var emittedFrom: String,
    var emittedAt: LocalDate,
    var validAt: LocalDate,
    @Enumerated(EnumType.STRING) var maritalStatus: MaritalStatus = MaritalStatus.SINGLE,
    @ManyToOne var person: Person,
): ConcreteModel(), IConvertRequest<IdentityCard> {

    constructor(): this("","","","",LocalDate.now(),LocalDate.now(), MaritalStatus.SINGLE, Person())

    override fun toString(): String {
        return "IdentityCard(${setToString("code='$code', person=$person, maritalStatus=$maritalStatus, residential='$residential', naturalFrom='$naturalFrom', emittedFrom='$emittedFrom', emittedAt=$emittedAt, validAt=$validAt")})"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is IdentityCard) return false
        if(other.person != person) return false
        return other.emittedAt == emittedAt && other.validAt == validAt
    }

    override fun hashCode(): Int = person.hashCode() + emittedAt.hashCode() + validAt.hashCode()

    override fun toRequest(): IdentityCardRequest = IdentityCardRequest(person.id, maritalStatus, residential, naturalFrom, emittedFrom, emittedAt, validAt)
}