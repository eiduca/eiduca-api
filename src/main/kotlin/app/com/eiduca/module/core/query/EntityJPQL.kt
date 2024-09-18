package app.com.eiduca.module.core.query

class EntityJPQL {
    companion object{
        const val FIND_ALL_PERSON = "SELECT e FROM #{#entityName} e WHERE person = :person AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_PERSON = "SELECT e FROM #{#entityName} e WHERE person = :person AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_UNIVERSITY = "SELECT e FROM #{#entityName} e WHERE university = :university AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_UNIVERSITY = "SELECT e FROM #{#entityName} e WHERE university = :university AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_COURSE = "SELECT e FROM #{#entityName} e WHERE course = :course AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_COURSE = "SELECT count(*) FROM #{#entityName} e WHERE course = :course AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_DAY_PERIOD = "SELECT e FROM #{#entityName} e WHERE dayPeriod = :dayPeriod AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_DAY_PERIOD = "SELECT count(*) FROM #{#entityName} e WHERE dayPeriod = :dayPeriod AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_ACADEMIC_PERIOD = "SELECT e FROM #{#entityName} e WHERE academicPeriod = :academicPeriod AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_ACADEMIC_PERIOD = "SELECT count(*) FROM #{#entityName} e WHERE academicPeriod = :academicPeriod AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_ACADEMIC_YEAR = "SELECT e FROM #{#entityName} e WHERE academicYear = :academicYear AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_ACADEMIC_YEAR = "SELECT count(*) FROM #{#entityName} e WHERE academicYear = :academicYear AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_CURRICULUM_YEAR = "SELECT e FROM #{#entityName} e WHERE curriculumYear = :curriculumYear AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_CURRICULUM_YEAR = "SELECT count(*) FROM #{#entityName} e WHERE curriculumYear = :curriculumYear AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_DISCIPLINE = "SELECT d FROM #{#entityName} d WHERE discipline = :discipline AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_DISCIPLINE = "SELECT count(*) FROM #{#entityName} d WHERE discipline = :discipline AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_REGIME_DISCIPLINE = "SELECT rd FROM #{#entityName} rd WHERE regimeDiscipline = :regimeDiscipline AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_REGIME_DISCIPLINE = "SELECT count(*) FROM #{#entityName} rd WHERE regimeDiscipline = :regimeDiscipline AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_PROFILE_DISCIPLINE = "SELECT pd FROM #{#entityName} pd WHERE profileDiscipline = :profileDiscipline AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_PROFILE_DISCIPLINE = "SELECT count(*) FROM #{#entityName} pd WHERE profileDiscipline = :profileDiscipline AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_CLASSROOM = "SELECT e FROM #{#entityName} e WHERE classroom = :classroom AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_CLASSROOM = "SELECT count(*) FROM #{#entityName} e WHERE classroom = :classroom AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_CALENDAR_ACCESS_EXAM = "SELECT e FROM #{#entityName} e WHERE calendarAccessExam = :calendarAccessExam AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_CALENDAR_ACCESS_EXAM = "SELECT count(*) FROM #{#entityName} e WHERE calendarAccessExam = :calendarAccessExam AND deletedBy IS NULL AND deletedAt IS NULL"
    }
}