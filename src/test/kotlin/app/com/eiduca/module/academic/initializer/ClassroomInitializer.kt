package app.com.eiduca.module.academic.initializer

import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.service.concrete.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ClassroomInitializer(
    @Autowired private val courseService: CourseService,
    @Autowired private val dayPeriodService: DayPeriodService,
    @Autowired private val universityService: UniversityService,
    @Autowired private val institutionService: InstitutionService,
    @Autowired private val academicYearService: AcademicYearService,
    @Autowired private val curriculumYearService: CurriculumYearService,
    @Autowired private val academicPeriodService: AcademicPeriodService,
) {

    fun initialize(obj: Classroom): Classroom {
        obj.course.institution.university = universityService.saveOrUpdate(obj.course.institution.university)
        obj.course.academicYear = academicYearService.saveOrUpdate(obj.course.academicYear)
        obj.course.institution = institutionService.saveOrUpdate(obj.course.institution)
        obj.course = courseService.saveOrUpdate(obj.course)

        obj.curriculumYear = curriculumYearService.saveOrUpdate(obj.curriculumYear)
        obj.academicPeriod = academicPeriodService.saveOrUpdate(obj.academicPeriod)
        obj.dayPeriod = dayPeriodService.saveOrUpdate(obj.dayPeriod)

        return obj
    }

}
