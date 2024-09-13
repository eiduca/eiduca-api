package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.create.concrete.CourseCreate
import app.com.eiduca.module.academic.request.concrete.CourseRequest
import app.com.eiduca.module.academic.service.concrete.AcademicYearService
import app.com.eiduca.module.academic.service.concrete.CourseService
import app.com.eiduca.module.academic.service.concrete.InstitutionService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of course")
class CourseControllerIT (
    @Autowired var courseService: CourseService,
    @Autowired var institutionService: InstitutionService,
    @Autowired var academicYearService: AcademicYearService,
): ConcreteControllerItTest<Course>(
    courseService,
    CourseCreate.COURSE_SAVE,
    "courses"
) {
    override fun requestModel(): CourseRequest = model.toRequest()

    override fun runner() {
        model.academicYear = academicYearService.saveOrUpdate(model.academicYear)
        model.institution = institutionService.saveOrUpdate(model.institution)
    }
}