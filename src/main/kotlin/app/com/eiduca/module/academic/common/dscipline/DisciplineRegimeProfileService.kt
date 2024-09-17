package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.core.common.general.ConcreteService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

abstract class DisciplineRegimeProfileService<T: DisciplineRegimeProfileModel>(
    private val disciplineRegimeProfileRepository: DisciplineRegimeProfileRepository<T>
): ConcreteService<T>(disciplineRegimeProfileRepository) {

    fun findByDiscipline(discipline: Discipline): List<T> = disciplineRegimeProfileRepository.findByDiscipline(discipline)

    fun findByDiscipline(discipline: Discipline, pageable: Pageable): Page<T> = disciplineRegimeProfileRepository.findByDiscipline(discipline, pageable)

    fun findByRegimeDiscipline(regimeDiscipline: RegimeDiscipline): List<T> = disciplineRegimeProfileRepository.findByRegimeDiscipline(regimeDiscipline)

    fun findByRegimeDiscipline(regimeDiscipline: RegimeDiscipline, pageable: Pageable): Page<T> = disciplineRegimeProfileRepository.findByRegimeDiscipline(regimeDiscipline, pageable)

    fun findByProfileDiscipline(profileDiscipline: ProfileDiscipline): List<T> = disciplineRegimeProfileRepository.findByProfileDiscipline(profileDiscipline)

    fun findByProfileDiscipline(profileDiscipline: ProfileDiscipline, pageable: Pageable): Page<T> = disciplineRegimeProfileRepository.findByProfileDiscipline(profileDiscipline, pageable)
}