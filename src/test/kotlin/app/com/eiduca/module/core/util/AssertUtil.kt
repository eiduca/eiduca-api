package app.com.eiduca.module.core.util

import app.com.eiduca.module.core.common.general.CommonModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional
import kotlin.test.assertFalse
import kotlin.test.assertNotNull

class AssertUtil<T: CommonModel> {

    companion object{

        val PAGEABLE: Pageable = Pageable.ofSize(5)

        fun <T> assert(optional: Optional<T>){
            assertFalse(optional.isEmpty)
        }

        fun <T> assert(list: List<T>){
            assertFalse(list.isEmpty())
        }

        fun <T> assert(page: Page<T>){
            assertFalse(page.isEmpty)
        }

        fun <T> assert(model: T){
            assertNotNull(model)
        }

    }

}