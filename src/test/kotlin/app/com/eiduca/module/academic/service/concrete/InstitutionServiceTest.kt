package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyServiceTest
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.repository.concrete.InstitutionRepository
import app.com.eiduca.module.academic.repository.concrete.UniversityRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional

@ExtendWith(SpringExtension::class)
@DisplayName("Test of institution service")
class InstitutionServiceTest: CompanyServiceTest<Institution>() {

    @InjectMocks
    lateinit var institutionService: InstitutionService

    @Mock
    lateinit var institutionRepository: InstitutionRepository

    @Mock
    lateinit var universityRepository: UniversityRepository

    @BeforeEach
    fun setUpInstitution() {
        setUpCompany(institutionService, institutionRepository, InstitutionCreate.INSTITUTION_SAVE)
        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(institutionRepository.findByType(model.type)).thenReturn(list)
        BDDMockito.`when`(institutionRepository.findByType(model.type, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(institutionRepository.findByUniversity(model.university)).thenReturn(list)
        BDDMockito.`when`(institutionRepository.findByUniversity(model.university, AssertUtil.PAGEABLE )).thenReturn(page)
        BDDMockito.`when`(universityRepository.save(model.university)).thenReturn(model.university)
        model.university = universityRepository.findByName(model.university.name).orElse(universityRepository.save(model.university))
        BDDMockito.`when`(institutionRepository.findByNameAndUniversity(model.name, model.university)).thenReturn(Optional.of(model))
    }

    @Test
    @DisplayName("Find institution by type when successful, return list")
    fun findByType_ReturnList_WhenSuccessful() {
        AssertUtil.assert(institutionService.findByType(model.type))
    }

    @Test
    @DisplayName("Find institution by type when successful, return list pageable")
    fun findByType_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(institutionService.findByType(model.type, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find institution by university when successful, return list")
    fun findByUniversity_ReturnList_WhenSuccessful() {
        AssertUtil.assert( institutionService.findByUniversity(model.university))
    }

    @Test
    @DisplayName("Find institution by university when successful, return list pageable")
    fun findByUniversity_ReturnPage_WhenSuccessful() {
        AssertUtil.assert( institutionService.findByUniversity(model.university, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find institution by name and university when successful")
    fun findByNameAndUniversity_WhenSuccessful(){
        AssertUtil.assert(institutionService.findByNameAndUniversity(model.name, model.university))
    }
}