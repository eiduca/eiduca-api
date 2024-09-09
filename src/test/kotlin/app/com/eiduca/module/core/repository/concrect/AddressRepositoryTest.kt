package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepositoryTest
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of address repository")
class AddressRepositoryTest(
    @Autowired val addressRepository: AddressRepository,
): ConcreteRepositoryTest<Address>(
    addressRepository, AddressCreate.ADDRESS_SAVE
){

    @Test
    @DisplayName("Find address by code when successful")
    fun findByCode_WhenSuccessful() {
        runner()
        persistModel()
        addressRepository.findByCode(model.code).ifPresentOrElse(
            { assert(it.code == model.code) },
            { throw NotFoundException("Not found address by code") }
        )
    }

    @Test
    @DisplayName("Find address by streetName when successful, return list")
    fun findByStreetName_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByStreetName(model.streetName))
    }

    @Test
    @DisplayName("Find address by streetName when successful, return list pageable")
    fun findByStreetName_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByStreetName(model.streetName, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by houseNumber when successful, return list")
    fun findByHouseNumber_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByHouseNumber(model.houseNumber))
    }

    @Test
    @DisplayName("Find address by houseNumber when successful, return list pageable")
    fun findByHouseNumber_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByHouseNumber(model.houseNumber, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by neighborhood when successful, return list")
    fun findByNeighborhood_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByNeighborhood(model.neighborhood))
    }

    @Test
    @DisplayName("Find address by neighborhood when successful, return list pageable")
    fun findByNeighborhood_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByNeighborhood(model.neighborhood, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by city when successful, return list")
    fun findByCity_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCity(model.city))
    }

    @Test
    @DisplayName("Find address by city when successful, return list pageable")
    fun findByCity_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCity(model.city, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by city when successful, return list")
    fun findByProvince_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByProvince(model.province))
    }

    @Test
    @DisplayName("Find address by city when successful, return list pageable")
    fun findByProvince_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByProvince(model.province, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by country when successful, return list")
    fun findByCountry_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCountry(model.country))
    }

    @Test
    @DisplayName("Find address by country when successful, return list pageable")
    fun findByCountry_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCountry(model.country, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by postalCode when successful, return list")
    fun findByPostalCode_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByPostalCode(model.postalCode))
    }

    @Test
    @DisplayName("Find address by postalCode when successful, return list pageable")
    fun findByPostalCode_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByPostalCode(model.postalCode, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by latitude when successful, return list")
    fun findByLatitude_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLatitude(model.latitude))
    }

    @Test
    @DisplayName("Find address by latitude when successful, return list pageable")
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find address by longitude when successful, return list")
    fun findByLongitude_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLongitude(model.longitude))
    }

    @Test
    @DisplayName("Find address by longitude when successful, return list pageable")
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }

    override fun persistModel(){
      model = addressRepository.findByCode(model.code).orElse(addressRepository.save(model))
    }
}