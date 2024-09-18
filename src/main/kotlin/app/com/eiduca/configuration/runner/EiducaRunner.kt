package app.com.eiduca.configuration.runner

import app.com.eiduca.module.core.seed.*
import app.com.eiduca.module.academic.seed.*
import app.com.eiduca.module.core.model.concrect.*
import app.com.eiduca.module.core.service.concrect.*
import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.service.concrete.*
import app.com.eiduca.module.candidacy.model.*
import app.com.eiduca.module.candidacy.seed.CalendarAccessExamSeed
import app.com.eiduca.module.candidacy.service.*
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class EiducaRunner(
    val roleService: RoleService,
    val personService: PersonService,
    val courseService: CourseService,
    val classroomService: ClassroomService,
    val dayPeriodService: DayPeriodService,
    val permissionService: PermissionService,
    val universityService: UniversityService,
    val disciplineService: DisciplineService,
    val institutionService: InstitutionService,
    val academicYearService: AcademicYearService,
    val identityCardService: IdentityCardService,
    val academicPeriodService: AcademicPeriodService,
    val curriculumYearService: CurriculumYearService,
    val regimeDisciplineService: RegimeDisciplineService,
    val profileDisciplineService: ProfileDisciplineService,
    val calendarAccessExamService: CalendarAccessExamService,
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        val roles: MutableList<Role> = mutableListOf()
        val courses: MutableList<Course> = mutableListOf()
        val persons: MutableList<Person> = mutableListOf()
        val classrooms: MutableList<Classroom> = mutableListOf()
        val dayPeriods: MutableList<DayPeriod> = mutableListOf()
        val permissions: MutableList<Permission> = mutableListOf()
        val disciplines: MutableList<Discipline> = mutableListOf()
        val universities: MutableList<University> = mutableListOf()
        val institutions: MutableList<Institution> = mutableListOf()
        val academicYears: MutableList<AcademicYear> = mutableListOf()
        val academicPeriods: MutableList<AcademicPeriod> = mutableListOf()
        val curriculumYears: MutableList<CurriculumYear> = mutableListOf()
        val regimeDisciplines: MutableList<RegimeDiscipline> = mutableListOf()
        val profileDisciplines: MutableList<ProfileDiscipline> = mutableListOf()
        val calendarAccessExams: MutableList<CalendarAccessExam> = mutableListOf()

        /* Module core */

        PermissionSeed.entries.forEach { permissions.addLast(permissionService.saveOrUpdate(it.permission)) }
        PersonSeed.entries.forEach { persons.addLast(personService.saveOrUpdate(it.person)) }
        RoleSeed.entries.forEach { roles.addLast(roleService.saveOrUpdate(it.role))  }

        IdentityCardSeed.entries.forEach {
            it.identityCard.person = persons.first { p -> p.username == it.identityCard.person.username }
            identityCardService.saveOrUpdate(it.identityCard)
        }
        /* Module academic */
        UniversitySeed.entries.forEach { universities.addLast(universityService.saveOrUpdate(it.university)) }

        InstitutionSeed.entries.forEach {
            it.institution.university = universities.first { p -> p.name == it.institution.university.name }
            institutions.addLast(institutionService.saveOrUpdate(it.institution))
        }

        ProfileDisciplineSeed.entries.forEach { profileDisciplines.addLast(profileDisciplineService.saveOrUpdate(it.profileDiscipline)) }
        RegimeDisciplineSeed.entries.forEach { regimeDisciplines.addLast(regimeDisciplineService.saveOrUpdate(it.regimeDiscipline)) }
        AcademicPeriodSeed.entries.forEach { academicPeriods.addLast(academicPeriodService.saveOrUpdate(it.academicPeriod)) }
        CurriculumYearSeed.entries.forEach { curriculumYears.addLast(curriculumYearService.saveOrUpdate(it.curriculumYear)) }
        AcademicYearSeed.entries.forEach { academicYears.addLast(academicYearService.saveOrUpdate(it.academicYear)) }
        DisciplineSeed.entries.forEach { disciplines.addLast(disciplineService.saveOrUpdate(it.discipline)) }
        DayPeriodSeed.entries.forEach { dayPeriods.addLast(dayPeriodService.saveOrUpdate(it.dayPeriod)) }

        CourseSeed.entries.forEach {
            it.course.institution.university = universities.first { u -> u.name == it.course.institution.university.name  }
            it.course.academicYear = academicYears.first { a -> a.code == it.course.academicYear.code }
            it.course.institution = institutions.first { i -> i.name == it.course.institution.name }
            courses.addLast(courseService.saveOrUpdate(it.course))
        }

        ClassroomSeed.entries.forEach {
            it.classroom.curriculumYear = curriculumYears.first { c -> c.code == it.classroom.curriculumYear.code }
            it.classroom.academicPeriod = academicPeriods.first { a -> a.code == it.classroom.academicPeriod.code }
            it.classroom.dayPeriod = dayPeriods.first { d -> d.code == it.classroom.dayPeriod.code }
            it.classroom.course = courses.first { c -> c.code == it.classroom.course.code }
            classrooms.addLast(classroomService.saveOrUpdate(it.classroom))
        }

        CalendarAccessExamSeed.entries.forEach {
            it.calendarAccessExam.academicYear = academicYears.first { a -> a.code == it.calendarAccessExam.academicYear.code }
            calendarAccessExams.addLast(calendarAccessExamService.saveOrUpdate(it.calendarAccessExam))
        }

    }

}