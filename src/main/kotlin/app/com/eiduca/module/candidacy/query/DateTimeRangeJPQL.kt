package app.com.eiduca.module.candidacy.query

class DateTimeRangeJPQL {
    companion object{
        const val FIND_ALL_START_DATETIME = "SELECT e FROM #{#entityName} e WHERE startDateTime = :startDateTime AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_START_DATETIME = "SELECT count(*) FROM #{#entityName} e WHERE startDate = :startDate AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_END_DATETIME = "SELECT e FROM #{#entityName} e WHERE endDateTime = :endDateTime AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_END_DATETIME = "SELECT count(*) FROM #{#entityName} e WHERE endDateTime = :endDateTime AND deletedBy IS NULL AND deletedAt IS NULL"
    }
}