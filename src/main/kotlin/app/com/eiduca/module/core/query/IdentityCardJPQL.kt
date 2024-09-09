package app.com.eiduca.module.core.query

class IdentityCardJPQL {
    companion object{

        const val FIND_ALL_PERSON = "SELECT i FROM IdentityCard i WHERE person = :person AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_PERSON = "SELECT count(*) FROM IdentityCard i WHERE person = :person AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_RESIDENTIAL = "SELECT i FROM IdentityCard i WHERE residential = :residential AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_RESIDENTIAL = "SELECT count(*) FROM IdentityCard i WHERE residential = :residential AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_NATURAL_FROM = "SELECT i FROM IdentityCard i WHERE naturalFrom = :naturalFrom AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_NATURAL_FROM = "SELECT count(*) FROM IdentityCard i WHERE naturalFrom = :naturalFrom AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_EMITTED_FROM = "SELECT i FROM IdentityCard i WHERE emittedFrom = :emittedFrom AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_EMITTED_FROM = "SELECT count(*) FROM IdentityCard i WHERE emittedFrom = :emittedFrom AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_EMITTED_AT = "SELECT i FROM IdentityCard i WHERE i.emittedAt = :emittedAt AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_EMITTED_AT = "SELECT count(*) FROM IdentityCard i WHERE i.emittedAt = :emittedAt AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_VALID_AT = "SELECT i FROM IdentityCard i WHERE validAt = :validAt AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_VALID_AT = "SELECT count(*) FROM IdentityCard i WHERE validAt = :validAt AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_MARITAL_STATUS = "SELECT i FROM IdentityCard i WHERE maritalStatus = :maritalStatus AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_MARITAL_STATUS = "SELECT count(*) FROM IdentityCard i WHERE maritalStatus = :maritalStatus AND deletedBy IS NULL AND deletedAt is NULL"
    }
}