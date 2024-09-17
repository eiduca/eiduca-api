package app.com.eiduca.module.academic.query

class ClassroomJPQL {
    companion object{
       const val FIND_BY_COURSE_AND_DAY_PERIOD_AND_ACADEMIC_PERIOD_AND_CURRICULUM_YEAR = """
           SELECT c FROM Classroom c 
           WHERE course = :course 
           AND dayPeriod = :dayPeriod 
           AND academicPeriod = :academicPeriod 
           AND curriculumYear = :curriculumYear 
           AND deletedBy IS NULL AND deletedAt IS NULL
       """
    }
}