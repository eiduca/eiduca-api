package app.com.eiduca.module.academic.initializer.service

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.service.concrete.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CourseInitializer(
    @Autowired private val institutionService: InstitutionService,
    @Autowired private val academicYearService: AcademicYearService,
    @Autowired private val universityService: UniversityService,
) {
    fun initialize(obj: Course): Course {
        obj.institution.university = universityService.saveOrUpdate(obj.institution.university)
        obj.institution = institutionService.saveOrUpdate(obj.institution)
        obj.academicYear = academicYearService.saveOrUpdate(obj.academicYear)
        return obj
    }
}
