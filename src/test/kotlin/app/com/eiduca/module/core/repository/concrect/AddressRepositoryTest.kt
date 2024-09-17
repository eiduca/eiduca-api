package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
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
    fun findByCode_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        addressRepository.findByCode(model.code).ifPresentOrElse(
            { assert(it.code == model.code) },
            { throw NotFoundException("Not found address by code") }
        )
    }

    @Test
    fun findByStreetName_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByStreetName(model.streetName))
    }

    @Test
    fun findByStreetName_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByStreetName(model.streetName, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByHouseNumber_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByHouseNumber(model.houseNumber))
    }

    @Test
    fun findByHouseNumber_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByHouseNumber(model.houseNumber, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNeighborhood_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByNeighborhood(model.neighborhood))
    }

    @Test
    fun findByNeighborhood_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByNeighborhood(model.neighborhood, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCity_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCity(model.city))
    }

    @Test
    fun findByCity_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCity(model.city, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByProvince_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByProvince(model.province))
    }

    @Test
    fun findByProvince_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByProvince(model.province, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCountry_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCountry(model.country))
    }

    @Test
    fun findByCountry_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByCountry(model.country, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByPostalCode_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByPostalCode(model.postalCode))
    }

    @Test
    fun findByPostalCode_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByPostalCode(model.postalCode, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLatitude_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLatitude(model.latitude))
    }

    @Test
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLongitude_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLongitude(model.longitude))
    }

    @Test
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(addressRepository.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }

    override fun persistModel(){
      model = addressRepository.findByCode(model.code).orElse(addressRepository.save(model))
    }
}