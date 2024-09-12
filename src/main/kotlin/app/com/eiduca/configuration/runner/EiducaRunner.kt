package app.com.eiduca.configuration.runner

import app.com.eiduca.module.core.seed.*
import app.com.eiduca.module.academic.seed.*
import app.com.eiduca.module.core.model.concrect.*
import app.com.eiduca.module.core.service.concrect.*
import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.service.concrete.*
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class EiducaRunner(
    val roleService: RoleService,
    val personService: PersonService,
    val permissionService: PermissionService,
    val identityCardService: IdentityCardService,
    val universityService: UniversityService,
    val institutionService: InstitutionService,
    val academicYearService: AcademicYearService,
    val disciplineService: DisciplineService,
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        val roles: MutableList<Role> = mutableListOf()
        val persons: MutableList<Person> = mutableListOf()
        val permissions: MutableList<Permission> = mutableListOf()
        val disciplines: MutableList<Discipline> = mutableListOf()
        val universities: MutableList<University> = mutableListOf()
        val institutions: MutableList<Institution> = mutableListOf()
        val academicYears: MutableList<AcademicYear> = mutableListOf()
        /* Module core */
        RoleSeed.entries.forEach { roles.addLast(roleService.saveOrUpdate(it.role))  }
        PersonSeed.entries.forEach { persons.addLast(personService.saveOrUpdate(it.person)) }
        PermissionSeed.entries.forEach { permissions.addLast(permissionService.saveOrUpdate(it.permission)) }
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
        AcademicYearSeed.entries.forEach { academicYears.addLast(academicYearService.saveOrUpdate(it.academicYear)) }
        DisciplineSeed.entries.forEach { disciplines.addLast(disciplineService.saveOrUpdate(it.discipline)) }
    }

}