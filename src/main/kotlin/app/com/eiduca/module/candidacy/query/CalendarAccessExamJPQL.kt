package app.com.eiduca.module.candidacy.query

class CalendarAccessExamJPQL {
    companion object{
        const val FIND_BY_CALENDAR_ACCESS_EXAM = """
            SELECT cae FROM CalendarAccessExam cae 
            WHERE numb = :numb 
            AND academicYear = :academicYear
            AND deletedBy IS NULL AND deletedAt IS NULL            
        """
    }
}