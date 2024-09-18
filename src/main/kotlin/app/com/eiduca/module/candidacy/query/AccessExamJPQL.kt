package app.com.eiduca.module.candidacy.query

class AccessExamJPQL {
    companion object{
        const val FIND_BY_COURSE_DISCIPLINE_CALENDAR_ACCESS_EXAM = """
            SELECT ae FROM AccessExam ae 
            WHERE course = :course 
            AND discipline = :discipline
            AND calendarAccessExam = :calendarAccessExam
            AND deletedBy IS NULL AND deletedAt IS NULL        
        """
    }
}