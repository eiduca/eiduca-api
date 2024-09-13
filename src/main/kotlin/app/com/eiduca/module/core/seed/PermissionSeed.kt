package app.com.eiduca.module.core.seed

import app.com.eiduca.module.core.enums.EntityEnum
import app.com.eiduca.module.core.factory.PermissionFactory
import app.com.eiduca.module.core.model.concrect.Permission

 enum class PermissionSeed(val permission: Permission) {

    PERMISSION_SUPER(PermissionFactory.build("SUPER", "Has full permission on the system", EntityEnum.APPLICATION)),

    PERMISSION_VIEW(PermissionFactory.build("VIEW_PERMISSION", "View permissions", EntityEnum.PERMISSION)),
    PERMISSION_SAVE(PermissionFactory.build("SAVE_PERMISSION", "Save permission", EntityEnum.PERMISSION)),
    PERMISSION_UPDATE(PermissionFactory.build("UPDATE_PERMISSION", "Edit permission", EntityEnum.PERMISSION)),
    PERMISSION_DELETE(PermissionFactory.build("DELETE_PERMISSION", "Delete permission", EntityEnum.PERMISSION)),

    ROLE_VIEW(PermissionFactory.build("VIEW_ROLE", "View job titles", EntityEnum.ROLE)),
    ROLE_SAVE(PermissionFactory.build("SAVE_ROLE", "Save position", EntityEnum.ROLE)),
    ROLE_UPDATE(PermissionFactory.build("UPDATE_ROLE", "Edit job title", EntityEnum.ROLE)),
    ROLE_DELETE(PermissionFactory.build("DELETE_ROLE", "Delete position", EntityEnum.ROLE)),

    PERSON_VIEW(PermissionFactory.build("VIEW_PERSON", "View users", EntityEnum.PERSON)),
    PERSON_SAVE(PermissionFactory.build("SAVE_PERSON", "Save user", EntityEnum.PERSON)),
    PERSON_UPDATE(PermissionFactory.build("UPDATE_PERSON", "Edit user", EntityEnum.PERSON)),
    PERSON_DELETE(PermissionFactory.build("DELETE_PERSON", "Delete user", EntityEnum.PERSON)),

    IDENTITY_CARD_VIEW(PermissionFactory.build("VIEW_IDENTITY_CARD", "View identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_SAVE(PermissionFactory.build("SAVE_IDENTITY_CARD", "Save identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_UPDATE(PermissionFactory.build("UPDATE_IDENTITY_CARD", "Edit identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_DELETE(PermissionFactory.build("DELETE_IDENTITY_CARD", "Delete identity card", EntityEnum.IDENTITY_CARD)),

    ADDRESS_VIEW(PermissionFactory.build("VIEW_ADDRESS", "View address", EntityEnum.ADDRESS)),
    ADDRESS_SAVE(PermissionFactory.build("SAVE_ADDRESS", "Save address", EntityEnum.ADDRESS)),
    ADDRESS_UPDATE(PermissionFactory.build("UPDATE_ADDRESS", "Edit address", EntityEnum.ADDRESS)),
    ADDRESS_DELETE(PermissionFactory.build("DELETE_ADDRESS", "Delete address", EntityEnum.ADDRESS)),

     PERSON_ADDRESS_VIEW(PermissionFactory.build("VIEW_PERSON_ADDRESS", "View address of user", EntityEnum.PERSON_ADDRESS)),
     PERSON_ADDRESS_SAVE(PermissionFactory.build("SAVE_PERSON_ADDRESS", "Save address of user", EntityEnum.PERSON_ADDRESS)),
     PERSON_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_PERSON_ADDRESS", "Edit address of user", EntityEnum.PERSON_ADDRESS)),
     PERSON_ADDRESS_DELETE(PermissionFactory.build("DELETE_PERSON_ADDRESS", "Delete address of user", EntityEnum.PERSON_ADDRESS)),

     /*-- Module academic --*/

     ACADEMIC_YEAR_VIEW(PermissionFactory.build("VIEW_ACADEMIC_YEAR", "View academic year", EntityEnum.ACADEMIC_YEAR)),
     ACADEMIC_YEAR_SAVE(PermissionFactory.build("SAVE_ACADEMIC_YEAR", "Save academic year", EntityEnum.ACADEMIC_YEAR)),
     ACADEMIC_YEAR_UPDATE(PermissionFactory.build("UPDATE_ACADEMIC_YEAR", "Edit academic year", EntityEnum.ACADEMIC_YEAR)),
     ACADEMIC_YEAR_DELETE(PermissionFactory.build("DELETE_ACADEMIC_YEAR", "Delete academic year", EntityEnum.ACADEMIC_YEAR)),

     UNIVERSITY_VIEW(PermissionFactory.build("VIEW_UNIVERSITY", "View university", EntityEnum.UNIVERSITY)),
     UNIVERSITY_SAVE(PermissionFactory.build("SAVE_UNIVERSITY", "Save university", EntityEnum.UNIVERSITY)),
     UNIVERSITY_UPDATE(PermissionFactory.build("UPDATE_UNIVERSITY", "Edit university", EntityEnum.UNIVERSITY)),
     UNIVERSITY_DELETE(PermissionFactory.build("DELETE_UNIVERSITY", "Delete university", EntityEnum.UNIVERSITY)),
     
     INSTITUTION_VIEW(PermissionFactory.build("VIEW_INSTITUTION", "View institution", EntityEnum.INSTITUTION)),
     INSTITUTION_SAVE(PermissionFactory.build("SAVE_INSTITUTION", "Save institution", EntityEnum.INSTITUTION)),
     INSTITUTION_UPDATE(PermissionFactory.build("UPDATE_INSTITUTION", "Edit institution", EntityEnum.INSTITUTION)),
     INSTITUTION_DELETE(PermissionFactory.build("DELETE_INSTITUTION", "Delete institution", EntityEnum.INSTITUTION)),

     COURSE_VIEW(PermissionFactory.build("VIEW_COURSE", "View course", EntityEnum.COURSE)),
     COURSE_SAVE(PermissionFactory.build("SAVE_COURSE", "Save course", EntityEnum.COURSE)),
     COURSE_UPDATE(PermissionFactory.build("UPDATE_COURSE", "Edit course", EntityEnum.COURSE)),
     COURSE_DELETE(PermissionFactory.build("DELETE_COURSE", "Delete course", EntityEnum.COURSE)),

     DISCIPLINE_VIEW(PermissionFactory.build("VIEW_DISCIPLINE", "View discipline", EntityEnum.DISCIPLINE)),
     DISCIPLINE_SAVE(PermissionFactory.build("SAVE_DISCIPLINE", "Save discipline", EntityEnum.DISCIPLINE)),
     DISCIPLINE_UPDATE(PermissionFactory.build("UPDATE_DISCIPLINE", "Edit discipline", EntityEnum.DISCIPLINE)),
     DISCIPLINE_DELETE(PermissionFactory.build("DELETE_DISCIPLINE", "Delete discipline", EntityEnum.DISCIPLINE)),

     DAY_PERIOD_VIEW(PermissionFactory.build("VIEW_DAY_PERIOD", "View day period", EntityEnum.DAY_PERIOD)),
     DAY_PERIOD_SAVE(PermissionFactory.build("SAVE_DAY_PERIOD", "Save day period", EntityEnum.DAY_PERIOD)),
     DAY_PERIOD_UPDATE(PermissionFactory.build("UPDATE_DAY_PERIOD", "Edit day period", EntityEnum.DAY_PERIOD)),
     DAY_PERIOD_DELETE(PermissionFactory.build("DELETE_DAY_PERIOD", "Delete day period", EntityEnum.DAY_PERIOD)),

     UNIVERSITY_ADDRESS_VIEW(PermissionFactory.build("VIEW_UNIVERSITY_ADDRESS", "View address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_SAVE(PermissionFactory.build("SAVE_UNIVERSITY_ADDRESS", "Save address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_UNIVERSITY_ADDRESS", "Edit address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_DELETE(PermissionFactory.build("DELETE_UNIVERSITY_ADDRESS", "Delete address of university", EntityEnum.UNIVERSITY_ADDRESS)),

     INSTITUTION_ADDRESS_VIEW(PermissionFactory.build("VIEW_INSTITUTION_ADDRESS", "View address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_SAVE(PermissionFactory.build("SAVE_INSTITUTION_ADDRESS", "Save address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_INSTITUTION_ADDRESS", "Edit address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_DELETE(PermissionFactory.build("DELETE_INSTITUTION_ADDRESS", "Delete address of institution", EntityEnum.INSTITUTION_ADDRESS)),
 }