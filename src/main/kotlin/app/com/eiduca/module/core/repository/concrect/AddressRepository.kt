package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.query.AddressJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AddressRepository: ConcreteRepository<Address> {

    @Query(name = "ModelConcrete.findByCode")
    fun findByCode(code: String): Optional<Address>

    @Query(name = AddressJPQL.FIND_ALL_STREET_NAME)
    fun findByStreetName(streetName: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_STREET_NAME, countName = AddressJPQL.FIND_COUNT_STREET_NAME)
    fun findByStreetName(streetName: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_HOUSE_NUMBER)
    fun findByHouseNumber(houseNumber: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_HOUSE_NUMBER, countName = AddressJPQL.FIND_COUNT_HOUSE_NUMBER)
    fun findByHouseNumber(houseNumber: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_NEIGHBORHOOD)
    fun findByNeighborhood(neighborhood: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_NEIGHBORHOOD, countName = AddressJPQL.FIND_COUNT_NEIGHBORHOOD)
    fun findByNeighborhood(neighborhood: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_CITY)
    fun findByCity(city: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_CITY, countName = AddressJPQL.FIND_COUNT_CITY)
    fun findByCity(city: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_PROVINCE)
    fun findByProvince(province: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_PROVINCE, countName = AddressJPQL.FIND_COUNT_PROVINCE)
    fun findByProvince(province: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_COUNTRY)
    fun findByCountry(country: String): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_COUNTRY, countName = AddressJPQL.FIND_COUNT_COUNTRY)
    fun findByCountry(country: String, pageable: Pageable): Page<Address>

    @Query(name = AddressJPQL.FIND_ALL_POST_CODE)
    fun findByPostalCode(postalCode: String?): List<Address>

    @Query(name = AddressJPQL.FIND_ALL_POST_CODE, countName = AddressJPQL.FIND_COUNT_POST_CODE)
    fun findByPostalCode(postalCode: String?, pageable: Pageable): Page<Address>

    @Query(name = "ModelConcrete.findByLatitude")
    fun findByLatitude(latitude: Double?): List<Address>

    @Query(name = "ModelConcrete.findByLatitude", countName = "ModelConcrete.findByLatitudeCount")
    fun findByLatitude(latitude: Double?, pageable: Pageable): Page<Address>

    @Query(name = "ModelConcrete.findByLongitude")
    fun findByLongitude(longitude: Double?): List<Address>

    @Query(name = "ModelConcrete.findByLongitude", countName = "ModelConcrete.findByLongitudeCount")
    fun findByLongitude(longitude: Double?, pageable: Pageable): Page<Address>
}