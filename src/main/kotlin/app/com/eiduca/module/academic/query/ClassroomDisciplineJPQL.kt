package app.com.eiduca.module.academic.query

class ClassroomDisciplineJPQL {
    companion object{
        const val FIND_BY_CLASSROOM_AND_DISCIPLINE_AND_REGIME_DISCIPLINE_AND_PROFILE_DISCIPLINE ="""
            SELECT cd FROM ClassroomDiscipline cd 
            WHERE classroom = :classroom 
            AND discipline = :discipline
            AND regimeDiscipline = :regimeDiscipline
            AND profileDiscipline = :profileDiscipline
            AND deletedBy IS NULL AND deletedAt IS NULL
        """
    }
}