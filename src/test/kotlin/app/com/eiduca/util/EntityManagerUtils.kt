package app.com.eiduca.util

import app.com.eiduca.module.academic.common.company.CompanyModel
import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.common.general.CommonModel
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.model.concrect.Person
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

object EntityManagerUtils {
    fun <T : CommonModel> TestEntityManager.findOrSave(entity: T): T {
        return when (entity) {
            is CodeNamedDescriptionModel -> this.entityManager.find(entity::class.java, entity.code) ?: this.persistAndFlush(entity)
            is CalendarAccessExam -> this.entityManager.find(entity::class.java, entity.numb) ?: this.persistAndFlush(entity)
            is CompanyModel -> this.entityManager.find(entity::class.java, entity.name) ?: this.persistAndFlush(entity)
            is AcademicYear -> this.entityManager.find(entity::class.java, entity.code) ?: this.persistAndFlush(entity)
            is Candidate -> this.entityManager.find(entity::class.java, entity.person)  ?: this.persistAndFlush(entity)
            is Classroom -> this.entityManager.find(entity::class.java, entity.code) ?: this.persistAndFlush(entity)
            is Address -> this.entityManager.find(entity::class.java, entity.code)  ?: this.persistAndFlush(entity)
            is Person -> this.entityManager.find(entity::class.java, entity.username)  ?: this.persistAndFlush(entity)
            else -> this.entityManager.find(entity::class.java, entity.id) ?: this.persistAndFlush(entity)
        }
    }
}