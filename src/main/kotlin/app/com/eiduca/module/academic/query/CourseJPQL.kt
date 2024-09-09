package app.com.eiduca.module.academic.query

class CourseJPQL {
    companion object{

        const val FIND_ALL_INSTITUTION = "SELECT c FROM Course c WHERE institution = :institution AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_INSTITUTION = "SELECT count(*) FROM Course c WHERE institution = :institution AND deletedBy IS NULL AND deletedAt is NULL"

        const val FIND_ALL_ACADEMIC_YEAR = "SELECT c FROM Course c WHERE academicYear = :academicYear AND deletedBy IS NULL AND deletedAt is NULL"
        const val FIND_COUNT_ACADEMIC_YEAR = "SELECT count(*) FROM Course c WHERE academicYear = :academicYear AND deletedBy IS NULL AND deletedAt is NULL"
    }
}