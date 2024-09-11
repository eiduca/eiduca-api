package app.com.eiduca.module.core.query

class PermissionJPQL {
    companion object{
        const val FIND_ALL_ENTITY= "SELECT p FROM Permission p WHERE entity = :entity WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_ENTITY= "SELECT count(*) FROM Permission p WHERE entity = :entity WHERE deletedBy IS NULL AND deletedAt IS NULL"
    }
}