package app.com.eiduca.module.candidacy.service

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeService
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.repository.AccessExamRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AccessExamService(
    val accessExamRepository: AccessExamRepository
): DateTimeRangeService<AccessExam>(accessExamRepository){

    fun findByCourse(course: Course) = accessExamRepository.findByCourse(course)

    fun findByCourse(course: Course, pageable: Pageable) = accessExamRepository.findByCourse(course, pageable)

    fun findByDiscipline(discipline: Discipline) = accessExamRepository.findByDiscipline(discipline)

    fun findByDiscipline(discipline: Discipline, pageable: Pageable) = accessExamRepository.findByDiscipline(discipline, pageable)

    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam) = accessExamRepository.findByCalendarAccessExam(calendarAccessExam)

    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam, pageable: Pageable) = accessExamRepository.findByCalendarAccessExam(calendarAccessExam, pageable)

    override fun findOrSave(obj: AccessExam): AccessExam {
        return accessExamRepository.findByCourseAndDisciplineAndCalendarAccessExam(obj.course, obj.discipline, obj.calendarAccessExam)
            .orElse(accessExamRepository.save(obj))
    }

    override fun saveOrUpdate(obj: AccessExam): AccessExam {
        accessExamRepository.findByCourseAndDisciplineAndCalendarAccessExam(obj.course, obj.discipline, obj.calendarAccessExam).ifPresent { obj.id = it.id }
        return accessExamRepository.save(obj)
    }

    override fun deleteIfExist(obj: AccessExam) {
        accessExamRepository.findByCourseAndDisciplineAndCalendarAccessExam(obj.course, obj.discipline, obj.calendarAccessExam).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: AccessExam) {
        accessExamRepository.findByCourseAndDisciplineAndCalendarAccessExam(obj.course, obj.discipline, obj.calendarAccessExam).ifPresent { destroy(it) }
    }
}