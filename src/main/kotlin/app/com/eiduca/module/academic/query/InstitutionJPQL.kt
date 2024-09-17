package app.com.eiduca.module.academic.query

class InstitutionJPQL {

    companion object{
        const val FIND_ONE_NAME_UNIVERSITY = "SELECT i FROM Institution i WHERE name = :name AND university = :university AND deletedBy IS NULL AND deletedAt IS NULL"
    }

}