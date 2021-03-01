package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extansion.TimeUtils
import ru.skillbranch.devintensive.extansion.add
import ru.skillbranch.devintensive.extansion.format
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user1 = User("1")
        val user2 = User("2", "123", "3333")
        val user3 = User("2", "123", "3333", null, lastVisit = Date(), isOnline = true)

//        user1.printMe()
//        user2.printMe()
//        user3.printMe()
    }

    @Test
    fun test_factory() {
        val user1 = User.makeUser("Iha man3")
        val user2 = User.makeUser("Iha")
        val user3 = User.makeUser(null)
        val user4 = User.makeUser("")
        val user5 = User.makeUser(" ")
        println("$user1 \n $user2 \n $user3 \n $user4 \n $user5 ")
    }

    @Test
    fun test_safe_calls() {
        val a = "Kotlin"
        val b: String? = null
        println(b?.length)
        println(a?.length) // Unnecessary safe call
    }

    @Test
    fun test_copy() {
        val user1 = User.makeUser("Ivan Petrov")
        val user2 = User.makeUser("Vasily Petkevich")
        println("$user1 \n$user2")

        val user3 = user2.copy(lastName = "Smit", lastVisit = Date())
        println(user3)
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Ivan Susanin")
        fun getUserInfo() = user
        val (id, f, l) = getUserInfo()
        println("$id, $f, $l")
        println("${user.component4()}")
    }

    @Test
    fun test_copy2() {
        val user = User.makeUser("Demon Petrov")
        val user2 = user

        println(user == user2)
        println(user === user2)
    }

    @Test
    fun test_dateFormate() {
        val user1 = User.makeUser("Alen Delon")
        val user2 = user1.copy(lastVisit = Date().add(3, TimeUtils.SECOND))
        val user3 = user2.copy(lastVisit = Date().add(-1, TimeUtils.DAY))

        println(
            """
            ${user1.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()} 
        """.trimIndent()
        )
    }

    @Test
    fun test_datas_maping() {
        val user = User.makeUser("Iha man")
        println(user)
//        val userView = user.toUserView()
//        println(userView)
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Ivan Susanin")
        val txtMessage =
            BaseMessage.makeMassage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage =
            BaseMessage.makeMassage(user, Chat("0"), payload = "any image url", type = "image")

        when (imgMessage) {
            is TextMessage -> println("this text message")
            is ImageMessage -> println("this image message")
        }

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_utils() {
        val (name, surname) = Utils.parseFullName("Timoty Petrov")
        println("$name $surname")
    }

    @Test
    fun test_date() {
        println(Date())
        println(Date().add(3, TimeUtils.MINUTE))
        println(Date().format())
        println(Date().format("HH:mm"))
    }

    @Test
    fun test_initial_utils() {
        println(Utils.toInitials("Don", "JACK"))
        println(Utils.toInitials("ina", ""))
        println(Utils.toInitials("", ""))
        println(Utils.toInitials("", "Jackson"))
        println(Utils.toInitials(null, ""))
        println(Utils.toInitials("KKK", null))
    }

}
