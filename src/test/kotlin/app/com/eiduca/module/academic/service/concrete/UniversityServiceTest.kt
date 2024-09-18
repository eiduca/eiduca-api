package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyServiceTest
import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.concrete.University
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

@ExtendWith(SpringExtension::class)
@DisplayName("Test of university service")
class UniversityServiceTest: CompanyServiceTest<University>(){
    @InjectMocks
    lateinit var universityService: UniversityService
    @Mock
    lateinit var universityRepository: UniversityRepository

    @BeforeEach
    fun setUp() {
        setUpCompany(universityService, universityRepository, UniversityCreate.UNIVERSITY_SAVE)
        val list = mutableListOf(model)
        val page = PageImpl(list)
        BDDMockito.`when`(universityRepository.findByType(model.type )).thenReturn(list)
        BDDMockito.`when`(universityRepository.findByType(model.type, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByType_ReturnList_WhenSuccessful() {
        universityService.save(model)
        AssertUtil.assert(universityService.findByType(model.type))
    }

    @Test
    fun findByType_ReturnPage_WhenSuccessful() {
        universityService.save(model)
        AssertUtil.assert(universityService.findByType(model.type, AssertUtil.PAGEABLE))
    }
}