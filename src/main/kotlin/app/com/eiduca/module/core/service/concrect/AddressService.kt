package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AddressService(
    val addressRepository: AddressRepository
): ConcreteService<Address>(addressRepository) {

    fun findByCode(code: String): Address = addressRepository.findByCode(code).orElseThrow { NotFoundException("Not found address by code ($code)") }

    fun findByStreetName(streetName: String): List<Address> = addressRepository.findByStreetName(streetName)
    fun findByStreetName(streetName: String, pageable: Pageable): Page<Address> = addressRepository.findByStreetName(streetName, pageable)

    fun findByHouseNumber(houseNumber: String): List<Address> = addressRepository.findByHouseNumber(houseNumber)
    fun findByHouseNumber(houseNumber: String, pageable: Pageable): Page<Address> = addressRepository.findByHouseNumber(houseNumber, pageable)

    fun findByNeighborhood(neighborhood: String): List<Address> = addressRepository.findByNeighborhood(neighborhood)
    fun findByNeighborhood(neighborhood: String, pageable: Pageable): Page<Address> = addressRepository.findByNeighborhood(neighborhood, pageable)

    fun findByCity(city: String): List<Address> = addressRepository.findByCity(city)
    fun findByCity(city: String, pageable: Pageable): Page<Address> = addressRepository.findByCity(city, pageable)

    fun findByProvince(province: String): List<Address> = addressRepository.findByProvince(province)
    fun findByProvince(province: String, pageable: Pageable): Page<Address> = addressRepository.findByProvince(province, pageable)

    fun findByCountry(country: String): List<Address> = addressRepository.findByCountry(country)
    fun findByCountry(country: String, pageable: Pageable): Page<Address> = addressRepository.findByCountry(country, pageable)

    fun findByPostalCode(postalCode: String?): List<Address> = addressRepository.findByPostalCode(postalCode)
    fun findByPostalCode(postalCode: String?, pageable: Pageable): Page<Address> = addressRepository.findByPostalCode(postalCode, pageable)

    fun findByLatitude(latitude: Double?): List<Address> = addressRepository.findByLatitude(latitude)
    fun findByLatitude(latitude: Double?, pageable: Pageable): Page<Address> = addressRepository.findByLatitude(latitude, pageable)

    fun findByLongitude(longitude: Double?): List<Address> = addressRepository.findByLongitude(longitude)
    fun findByLongitude(longitude: Double?, pageable: Pageable): Page<Address> = addressRepository.findByLongitude(longitude, pageable)

    override fun deleteIfExist(obj: Address) = addressRepository.findByCode(obj.code).ifPresent { hidden(it) }

    override fun saveOrUpdate(obj: Address): Address {
        addressRepository.findByCode(obj.code).ifPresent { obj.id = it.id }
        return  addressRepository.save(obj)
    }
}