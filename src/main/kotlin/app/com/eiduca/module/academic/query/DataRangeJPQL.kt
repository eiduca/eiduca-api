package app.com.eiduca.module.academic.query

class DataRangeJPQL {
    companion object{
        const val FIND_ALL_START_DATE = "SELECT e FROM #{#entityName} e WHERE startDate = :startDate AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_START_DATE = "SELECT count(*) FROM #{#entityName} e WHERE startDate = :startDate AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_END_DATE = "SELECT e FROM #{#entityName} e WHERE endDate = :endDate AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_END_DATE = "SELECT count(*) FROM #{#entityName} e WHERE endDate = :endDate AND deletedBy IS NULL AND deletedAt IS NULL"
    }
}