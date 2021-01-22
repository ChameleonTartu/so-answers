import java.nio.charset.Charset

class Application {
}


fun getString(content:ByteArray, length: Int, encoding: String): String ?{
    var str: String? = null

    try {
        str = String(content, 0, length, Charset.forName(encoding))
        println("Test::getString str : $str")
    } catch (e: java.lang.Exception) {
        println("Test::getString ERR ")
        throw e
    }
    return str
}


fun main(array: Array<String>) {

}