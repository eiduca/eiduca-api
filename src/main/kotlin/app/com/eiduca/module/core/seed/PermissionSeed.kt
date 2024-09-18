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

     CLASSROOM_VIEW(PermissionFactory.build("VIEW_CLASSROOM", "View classroom", EntityEnum.CLASSROOM)),
     CLASSROOM_SAVE(PermissionFactory.build("SAVE_CLASSROOM", "Save classroom", EntityEnum.CLASSROOM)),
     CLASSROOM_UPDATE(PermissionFactory.build("UPDATE_CLASSROOM", "Edit classroom", EntityEnum.CLASSROOM)),
     CLASSROOM_DELETE(PermissionFactory.build("DELETE_CLASSROOM", "Delete classroom", EntityEnum.CLASSROOM)),

     ACADEMIC_PERIOD_VIEW(PermissionFactory.build("VIEW_ACADEMIC_PERIOD", "View academic period", EntityEnum.ACADEMIC_PERIOD)),
     ACADEMIC_PERIOD_SAVE(PermissionFactory.build("SAVE_ACADEMIC_PERIOD", "Save academic period", EntityEnum.ACADEMIC_PERIOD)),
     ACADEMIC_PERIOD_UPDATE(PermissionFactory.build("UPDATE_ACADEMIC_PERIOD", "Edit academic period", EntityEnum.ACADEMIC_PERIOD)),
     ACADEMIC_PERIOD_DELETE(PermissionFactory.build("DELETE_ACADEMIC_PERIOD", "Delete academic period", EntityEnum.ACADEMIC_PERIOD)),

     REGIME_DISCIPLINE_VIEW(PermissionFactory.build("VIEW_REGIME_DISCIPLINE", "View regime of discipline", EntityEnum.REGIME_DISCIPLINE)),
     REGIME_DISCIPLINE_SAVE(PermissionFactory.build("SAVE_REGIME_DISCIPLINE", "Save regime of discipline", EntityEnum.REGIME_DISCIPLINE)),
     REGIME_DISCIPLINE_UPDATE(PermissionFactory.build("UPDATE_REGIME_DISCIPLINE", "Edit regime of discipline", EntityEnum.REGIME_DISCIPLINE)),
     REGIME_DISCIPLINE_DELETE(PermissionFactory.build("DELETE_REGIME_DISCIPLINE", "Delete regime of discipline", EntityEnum.REGIME_DISCIPLINE)),

     PROFILE_DISCIPLINE_VIEW(PermissionFactory.build("VIEW_PROFILE_DISCIPLINE", "View profile of discipline", EntityEnum.PROFILE_DISCIPLINE)),
     PROFILE_DISCIPLINE_SAVE(PermissionFactory.build("SAVE_PROFILE_DISCIPLINE", "Save profile of discipline", EntityEnum.PROFILE_DISCIPLINE)),
     PROFILE_DISCIPLINE_UPDATE(PermissionFactory.build("UPDATE_PROFILE_DISCIPLINE", "Edit profile of discipline", EntityEnum.PROFILE_DISCIPLINE)),
     PROFILE_DISCIPLINE_DELETE(PermissionFactory.build("DELETE_PROFILE_DISCIPLINE", "Delete profile of discipline", EntityEnum.PROFILE_DISCIPLINE)),

     CURRICULUM_YEAR_VIEW(PermissionFactory.build("VIEW_CURRICULUM_YEAR", "View curriculum year", EntityEnum.CURRICULUM_YEAR)),
     CURRICULUM_YEAR_SAVE(PermissionFactory.build("SAVE_CURRICULUM_YEAR", "Save curriculum year", EntityEnum.CURRICULUM_YEAR)),
     CURRICULUM_YEAR_UPDATE(PermissionFactory.build("UPDATE_CURRICULUM_YEAR", "Edit curriculum year", EntityEnum.CURRICULUM_YEAR)),
     CURRICULUM_YEAR_DELETE(PermissionFactory.build("DELETE_CURRICULUM_YEAR", "Delete curriculum year", EntityEnum.CURRICULUM_YEAR)),

     COURSE_DISCIPLINE_VIEW(PermissionFactory.build("VIEW_COURSE_DISCIPLINE", "View course discipline", EntityEnum.COURSE_DISCIPLINE)),
     COURSE_DISCIPLINE_SAVE(PermissionFactory.build("SAVE_COURSE_DISCIPLINE", "Save course discipline", EntityEnum.COURSE_DISCIPLINE)),
     COURSE_DISCIPLINE_UPDATE(PermissionFactory.build("UPDATE_COURSE_DISCIPLINE", "Edit course discipline", EntityEnum.COURSE_DISCIPLINE)),
     COURSE_DISCIPLINE_DELETE(PermissionFactory.build("DELETE_COURSE_DISCIPLINE", "Delete course discipline", EntityEnum.COURSE_DISCIPLINE)),

     CLASSROOM_DISCIPLINE_VIEW(PermissionFactory.build("VIEW_CLASSROOM_DISCIPLINE", "View classroom discipline", EntityEnum.CLASSROOM_DISCIPLINE)),
     CLASSROOM_DISCIPLINE_SAVE(PermissionFactory.build("SAVE_CLASSROOM_DISCIPLINE", "Save classroom discipline", EntityEnum.CLASSROOM_DISCIPLINE)),
     CLASSROOM_DISCIPLINE_UPDATE(PermissionFactory.build("UPDATE_CLASSROOM_DISCIPLINE", "Edit classroom discipline", EntityEnum.CLASSROOM_DISCIPLINE)),
     CLASSROOM_DISCIPLINE_DELETE(PermissionFactory.build("DELETE_CLASSROOM_DISCIPLINE", "Delete classroom discipline", EntityEnum.CLASSROOM_DISCIPLINE)),

     UNIVERSITY_ADDRESS_VIEW(PermissionFactory.build("VIEW_UNIVERSITY_ADDRESS", "View address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_SAVE(PermissionFactory.build("SAVE_UNIVERSITY_ADDRESS", "Save address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_UNIVERSITY_ADDRESS", "Edit address of university", EntityEnum.UNIVERSITY_ADDRESS)),
     UNIVERSITY_ADDRESS_DELETE(PermissionFactory.build("DELETE_UNIVERSITY_ADDRESS", "Delete address of university", EntityEnum.UNIVERSITY_ADDRESS)),

     INSTITUTION_ADDRESS_VIEW(PermissionFactory.build("VIEW_INSTITUTION_ADDRESS", "View address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_SAVE(PermissionFactory.build("SAVE_INSTITUTION_ADDRESS", "Save address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_INSTITUTION_ADDRESS", "Edit address of institution", EntityEnum.INSTITUTION_ADDRESS)),
     INSTITUTION_ADDRESS_DELETE(PermissionFactory.build("DELETE_INSTITUTION_ADDRESS", "Delete address of institution", EntityEnum.INSTITUTION_ADDRESS)),

     /*Candidate module*/

     ACCESS_EXAM_VIEW(PermissionFactory.build("VIEW_ACCESS_EXAM", "View access exam", EntityEnum.ACCESS_EXAM)),
     ACCESS_EXAM_SAVE(PermissionFactory.build("SAVE_ACCESS_EXAM", "Save access exam", EntityEnum.ACCESS_EXAM)),
     ACCESS_EXAM_UPDATE(PermissionFactory.build("UPDATE_ACCESS_EXAM", "Edit access exam", EntityEnum.ACCESS_EXAM)),
     ACCESS_EXAM_DELETE(PermissionFactory.build("DELETE_ACCESS_EXAM", "Delete access exam", EntityEnum.ACCESS_EXAM)),

     CANDIDATE_VIEW(PermissionFactory.build("VIEW_CANDIDATE", "View candidate", EntityEnum.CANDIDATE)),
     CANDIDATE_SAVE(PermissionFactory.build("SAVE_CANDIDATE", "Save candidate", EntityEnum.CANDIDATE)),
     CANDIDATE_UPDATE(PermissionFactory.build("UPDATE_CANDIDATE", "Edit candidate", EntityEnum.CANDIDATE)),
     CANDIDATE_DELETE(PermissionFactory.build("DELETE_CANDIDATE", "Delete candidate", EntityEnum.CANDIDATE)),

     CALENDAR_ACCESS_EXAM_VIEW(PermissionFactory.build("VIEW_CALENDAR_ACCESS_EXAM", "View calendar access exam", EntityEnum.CALENDAR_ACCESS_EXAM)),
     CALENDAR_ACCESS_EXAM_SAVE(PermissionFactory.build("SAVE_CALENDAR_ACCESS_EXAM", "Save calendar access exam", EntityEnum.CALENDAR_ACCESS_EXAM)),
     CALENDAR_ACCESS_EXAM_UPDATE(PermissionFactory.build("UPDATE_CALENDAR_ACCESS_EXAM", "Edit calendar access exam", EntityEnum.CALENDAR_ACCESS_EXAM)),
     CALENDAR_ACCESS_EXAM_DELETE(PermissionFactory.build("DELETE_CALENDAR_ACCESS_EXAM", "Delete calendar access exam", EntityEnum.CALENDAR_ACCESS_EXAM)),
 }