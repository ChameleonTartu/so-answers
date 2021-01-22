import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.charset.Charset

internal class ApplicationKtTest {


    @Test
    fun `chinese string should work fine in utf-8 and utf-18`() {
        val chinese = "你扯動細繩，木偶的手腳就會動。用細繩捆紮的包裹用細繩捆紮的包裹你扯動細繩，木偶的手腳就會動。用細繩捆紮的包裹用細繩捆紮的包裹你扯動細繩，木偶的手腳就會動。用細繩捆紮的包裹用細繩捆紮的包裹你扯動細繩，木偶的手腳就會動。用細繩捆紮的包裹用細繩捆紮的包裹你扯動細繩，木偶的手腳就會動。用細繩捆紮的包裹用細繩捆紮的包裹"
        val byteArrayUtf8 = chinese.toByteArray()
        println(byteArrayUtf8.size)
        assertEquals(chinese, getString(byteArrayUtf8, byteArrayUtf8.size, "utf-8"))

        val byteArrayUtf16 = chinese.toByteArray(Charset.forName("utf-16"))
        println(byteArrayUtf16.size)
        assertEquals(chinese, getString(byteArrayUtf16, byteArrayUtf16.size, "utf-16"))
    }

    @Test
    fun `russian string should work fine in utf-8 and utf-16`() {
        var russian = "Очень длинная строка, с множеством разных символов и знаков. Я специально ее пишу, чтобы проверить частный случай в Котлине, потому что верю, что Котлин превосходный язык программирования. Еще хотелось бы сказать, спасибо разработчикам за удобный функционал и разные примочки, которых нет в Джаве."
        val byteArrayUtf8 = russian.toByteArray()

        println(byteArrayUtf8.size)
        assertEquals(russian, getString(byteArrayUtf8, byteArrayUtf8.size, "utf-8"))

        val byteArrayUtf16 = russian.toByteArray(Charset.forName("utf-16"))
        println(byteArrayUtf16.size)
        assertEquals(russian, getString(byteArrayUtf16, byteArrayUtf16.size, "utf-16"))
    }
}