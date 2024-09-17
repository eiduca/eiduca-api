package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileBuilder
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline

class ClassroomDisciplineBuilder: DisciplineRegimeProfileBuilder<ClassroomDiscipline>() {

    private var classroom: Classroom = Classroom()

    fun classroom(classroom: Classroom) = apply { this.classroom = classroom }

    override fun build(): ClassroomDiscipline {
        return withDefaultValues(ClassroomDiscipline(classroom, discipline, regimeDiscipline, profileDiscipline))
    }
}