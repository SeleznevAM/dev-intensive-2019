package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.humanizeDiff
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
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
    fun test_instance(){
        val user = User("1")
        val user2 = User("2")
        val user3 = User("3")

        println("$user $user2 $user3")
    }

    @Test
    fun factory_test(){
//        Utils.parseFullName(null) //null null
//        Utils.parseFullName("") //null null
//        Utils.parseFullName(" ") //null null
//        Utils.parseFullName("John") //John null
        val user = User.makeUser(null)
        val user1 = User.makeUser("")
        val user2 = User.makeUser(" ")
        val user3 = User.makeUser("John")
    }

    @Test
    fun test_abstract_fdactory(){
        val user = User.makeUser("Александр Селезнев")

        val textMessage = BaseMessage.makeMessage(user, Chat("0"), type = "text", payload = "any text message")
        val imageMessage = BaseMessage.makeMessage(user, Chat("0"), type = "image", payload = "any image message")

        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())
    }

    @Test
    fun humanizeDiff_test(){
        val date = Date().add(-400, TimeUnits.DAY)
        println(date.humanizeDiff())
    }

    @Test
    fun initials_test(){
        println(Utils.toInitials("john" ,"doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
    }
}
