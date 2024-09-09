package app.com.eiduca.module.core.query

class AddressJPQL {
    companion object{

        const val FIND_ALL_STREET_NAME= "SELECT a FROM Address a WHERE streetName = :streetName WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_STREET_NAME= "SELECT count(*) FROM Address a WHERE streetName = :streetName WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_HOUSE_NUMBER="SELECT a FROM Address a WHERE houseNumber = :houseNumber WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_HOUSE_NUMBER="SELECT count(*) FROM Address a WHERE houseNumber = :houseNumber WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_NEIGHBORHOOD = "SELECT a FROM Address a WHERE neighborhood = :neighborhood WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_NEIGHBORHOOD = "SELECT count(*) FROM Address a WHERE neighborhood = :neighborhood WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_CITY = "SELECT a FROM Address a WHERE city = :city WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_CITY = "SELECT count(*) FROM Address a WHERE city = :city WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_PROVINCE = "SELECT a FROM Address a WHERE province = :province WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_PROVINCE = "SELECT count(*) FROM Address a WHERE province = :province WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_COUNTRY = "SELECT a FROM Address a WHERE country = :country WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_COUNTRY = "SELECT count(*) FROM Address a WHERE country = :country WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_ALL_POST_CODE = "SELECT a FROM Address a WHERE postalCode = :postalCode WHERE deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_POST_CODE = "SELECT count(*) FROM Address a WHERE postalCode = :postalCode WHERE deletedBy IS NULL AND deletedAt IS NULL"
    }
}