package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import app.com.eiduca.module.core.util.AssertUtil

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address service")
class AddressServiceTest: ConcreteServiceTest<Address>() {

    @InjectMocks
    lateinit var addressService: AddressService

    @Mock
    lateinit var addressRepository: AddressRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(addressService, addressRepository, AddressCreate.ADDRESS_SAVE)
        val list = mutableListOf(model)
        val entities = PageImpl(list)
        BDDMockito.`when`(addressRepository.findByCode(model.code)).thenReturn(Optional.of(model))
        BDDMockito.`when`(addressRepository.findByStreetName(model.streetName)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByStreetName(model.streetName, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByHouseNumber(model.houseNumber)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByHouseNumber(model.houseNumber, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByNeighborhood(model.neighborhood)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByNeighborhood(model.neighborhood, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByCity(model.city)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByCity(model.city, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByProvince(model.province)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByProvince(model.province, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByCountry(model.country)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByCountry(model.country, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByPostalCode(model.postalCode)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByPostalCode(model.postalCode, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByLatitude(model.latitude)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByLatitude(model.latitude, AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(addressRepository.findByLongitude(model.longitude)).thenReturn(list)
        BDDMockito.`when`(addressRepository.findByLongitude(model.longitude, AssertUtil.PAGEABLE)).thenReturn(entities)

        model = addressRepository.findByCode(model.code).orElse(addressRepository.save(model))
    }

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val response = addressService.findByCode(model.code)
            assertEquals(response.code, model.code)
        }
    }

    @Test
    fun findByStreetName_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByStreetName(model.streetName))
    }

    @Test
    fun findByStreetName_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByStreetName(model.streetName, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByHouseNumber_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByHouseNumber(model.houseNumber))
    }

    @Test
    fun findByHouseNumber_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByHouseNumber(model.houseNumber, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNeighborhood_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByNeighborhood(model.neighborhood))
    }

    @Test
    fun findByNeighborhood_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByNeighborhood(model.neighborhood, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCity_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByCity(model.city))
    }

    @Test
    fun findByCity_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByCity(model.city, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByProvince_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByProvince(model.province))
    }

    @Test
    fun findByProvince_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByProvince(model.province, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCountry_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByCountry(model.country))
    }

    @Test
    fun findByCountry_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByCountry(model.country, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByPostalCode_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByPostalCode(model.postalCode))
    }

    @Test
    fun findByPostalCode_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByPostalCode(model.postalCode, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLatitude_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByLatitude(model.latitude))
    }

    @Test
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLongitude_ReturnList_WhenSuccessful() {
        AssertUtil.assert(addressService.findByLongitude(model.longitude))
    }

    @Test
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(addressService.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }
}