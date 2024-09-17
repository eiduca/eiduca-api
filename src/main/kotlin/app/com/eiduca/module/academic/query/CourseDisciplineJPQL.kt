package app.com.eiduca.module.academic.query

class CourseDisciplineJPQL {
    companion object{
        const val FIND_BY_COURSE_AND_DISCIPLINE_AND_REGIME_DISCIPLINE_AND_PROFILE_DISCIPLINE ="""
            SELECT cd FROM CourseDiscipline cd 
            WHERE course = :course 
            AND discipline = :discipline
            AND regimeDiscipline = :regimeDiscipline
            AND profileDiscipline = :profileDiscipline
            AND deletedBy IS NULL AND deletedAt IS NULL
        """
    }
}