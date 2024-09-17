package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.util.GeneratorUUID
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import kotlin.jvm.Transient

@MappedSuperclass
abstract class CommonModel(
    @Id var id: String = "",
    var createdAt: LocalDateTime? = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
    var createdBy: String? = "",
    var updatedBy: String? = "",
    @JvmField @Column(columnDefinition="TEXT", unique= true) var concatFields: String = ""
): Serializable {

    @Transient
    protected val SEPARATOR = ";"

    @PrePersist
    protected fun prePersist() {
        id = GeneratorUUID.v7toString()
        concatValuesFields()
    }

    @PreUpdate
    protected fun preUpdate(){ concatValuesFields() }

    private fun concatValuesFields(){
        concatFields = toString()
    }

    override fun toString(): String = "ModelCommon(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, concatFields='$concatFields')"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other is CommonModel &&  id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
}

@MappedSuperclass
abstract class PivotModel() : CommonModel()

@MappedSuperclass
abstract class ConcreteModel(
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null,
    @Enumerated(EnumType.STRING) var registerType: RegisterType? = RegisterType.APPLICATION
): CommonModel(){

    override fun toString(): String {
        return "ModelConcrete(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields')"
    }

    open fun setToString(fields: String): String = "id='$id', $fields, createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields'"
}

@MappedSuperclass
abstract class ConcretePivotModel(
    deletedAt: LocalDateTime? = null,
    deletedBy: String? = null,
    registerType: RegisterType? = RegisterType.APPLICATION
): ConcreteModel(deletedAt, deletedBy, registerType)
