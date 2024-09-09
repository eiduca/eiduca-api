package app.com.eiduca.module.academic.query

class CompanyJPQL {
    companion object{

        const val FIND_ALL_ACRONYM = "SELECT e FROM #{#entityName} e WHERE acronym = :acronym AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_CONTACT = "SELECT e FROM #{#entityName} e WHERE contact = :contact AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_CONTACT = "SELECT count(*) FROM #{#entityName} e WHERE contact = :contact AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_WEBSITE = "SELECT e FROM #{#entityName} e WHERE website = :website AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_WEBSITE = "SELECT count(*) FROM #{#entityName} e WHERE website = :website AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_FOUNDING_DATE = "SELECT e FROM #{#entityName} e WHERE foundingDate = :foundingDate AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_FOUNDING_DATE = "SELECT count(*) FROM #{#entityName} e WHERE foundingDate = :foundingDate AND deletedBy IS NULL AND deletedAt IS NULL"

    }
}