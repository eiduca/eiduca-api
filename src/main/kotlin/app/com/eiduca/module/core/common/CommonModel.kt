package app.com.eiduca.module.core.common

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

    fun concatValuesFields(){
        concatFields = toString()
    }

    override fun toString(): String = "ModelCommon(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, concatFields='$concatFields')"
}

@MappedSuperclass
abstract class ConcreteModel(
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null,
    @Enumerated(EnumType.STRING) var registerType: RegisterType? = RegisterType.APPLICATION
): CommonModel(){

    override fun toString(): String {
        return "ModelConcrete(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields')"
    }

    protected fun setToString(fields: String)= "id='$id', $fields, createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields'"

}

@MappedSuperclass
abstract class PivotModel() : CommonModel()