package app.com.eiduca.module.core.query

class PersonJPQL {
    companion object{
        const val FIND_BY_USERNAME = "SELECT p FROM Person p WHERE username = :username AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_BY_IDENTITY_CARD_NUMBER = "SELECT p FROM Person p WHERE identityCardNumber = :identityCardNumber WHERE deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_BY_BIRTHDAY = "SELECT p FROM Person p WHERE birthday = :birthday AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_BIRTHDAY = "SELECT count(*) FROM Person p WHERE birthday = :birthday AND deletedBy IS NULL AND deletedAt IS NULL"

        const val FIND_BY_GENDER = "SELECT p FROM Person p WHERE gender = :gender AND deletedBy IS NULL AND deletedAt IS NULL"
        const val FIND_COUNT_GENDER = "SELECT count(*) FROM Person p WHERE gender = :gender AND deletedBy IS NULL AND deletedAt IS NULL"
    }
}