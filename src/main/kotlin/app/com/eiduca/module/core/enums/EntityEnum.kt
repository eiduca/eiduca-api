package app.com.eiduca.module.core.enums

import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.core.model.concrect.*
import app.com.eiduca.module.core.model.pivot.PersonAddress

enum class EntityEnum(
    val cls: Any
) {
    NONE(Any::class),
    APPLICATION(Any::class),

    ROLE(Role::class),
    PERSON(Person::class),
    ADDRESS(Address::class),
    PERMISSION(Permission::class),
    IDENTITY_CARD(IdentityCard::class),
    PERSON_ADDRESS(PersonAddress::class),

    COURSE(Course::class),
    CLASSROOM(Classroom::class),
    DAY_PERIOD(DayPeriod::class),
    DISCIPLINE(Discipline::class),
    UNIVERSITY(University::class),
    INSTITUTION(Institution::class),
    ACADEMIC_YEAR(AcademicYear::class),
    ACADEMIC_PERIOD(AcademicPeriod::class),
    CURRICULUM_YEAR(CurriculumYear::class),
    COURSE_DISCIPLINE(CourseDiscipline::class),
    REGIME_DISCIPLINE(RegimeDiscipline::class),
    PROFILE_DISCIPLINE(ProfileDiscipline::class),
    UNIVERSITY_ADDRESS(UniversityAddress::class),
    INSTITUTION_ADDRESS(InstitutionAddress::class),
    CLASSROOM_DISCIPLINE(ClassroomDiscipline::class),
}