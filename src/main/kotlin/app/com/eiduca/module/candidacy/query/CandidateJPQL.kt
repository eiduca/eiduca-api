package app.com.eiduca.module.candidacy.query

class CandidateJPQL {
    companion object{
        const val FIND_BY_PERSON_AND_COURSE_CALENDAR_ACCESS_EXAM = """
            SELECT c FROM Candidate c 
            WHERE person = :person 
            AND course = :course
            AND calendarAccessExam = :calendarAccessExam
            AND deletedBy IS NULL AND deletedAt IS NULL            
        """
    }
}