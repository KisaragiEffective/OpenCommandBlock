import com.sun.deploy.xml.XMLParser
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.FileReader
import java.io.File
import java.io.FileInputStream
import java.io.PrintWriter
import java.io.IOException
import java.lang.System
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import kotlin.system.exitProcess
import kotlin.io.FileTreeWalk
import java.util.logging.Logger
import kotlin.concurrent.thread

val userProfile = """C:\Users\Obsidian550D"""
val baseDir = """$userProfile\Documents\github\OpenCommandBlock"""
/**
 * The ProGuard path.
 */
val proguard = """${baseDir}\build\proguard6.0.3\lib\proguard.jar"""
val builtWithPom = true
var targetVersion: String = ""
if (builtWithPom) {
    val pomLocation = """${baseDir}\pom.xml"""
    val pom = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(File(pomLocation))
    targetVersion = pom.childNodes.children().filter {
        it.nodeName == "project"
    }[0].childNodes.children().filter {
        it.nodeName == "version"
    }[0].textContent
}
val inTarget = """${baseDir}\target\OpenCommandBlock-${targetVersion}.jar"""
val outTarget = """${baseDir}\target\proguarded\OpenCommandBlock-${targetVersion}.jar"""
val mavenCache = """${userProfile}\.m2\repository"""
val kotlinVersion = KotlinVersion.CURRENT
val jdk: String = """C:\Program Files\Java\jdk1.8.0_144\jre\lib"""
File(outTarget).tryDelete()

var jdkLib: Array<String> = emptyArray()
/*
jdkLib = File(jdk).walkTopDown().filter { it: File ->
    it.extension == "jar"
}.map {
    it.canonicalPath
}.toList().toTypedArray()
*/
jdkLib += arrayOf(
        """
    "${jdk}\charsets.jar"
""".trimIndent(),
        """
    "${jdk}\deploy.jar"
""".trimIndent(),
        """
    "${jdk}\javaws.jar"
""".trimIndent(),
        """
    "${jdk}\jce.jar"
""".trimIndent(),
        """
    "${jdk}\jfr.jar"
""".trimIndent(),
        """
    "${jdk}\jfxswt.jar"
""".trimIndent(),
        """
    "${jdk}\jsse.jar"
""".trimIndent(),
        """
    "${jdk}\management-agent.jar"
""".trimIndent(),
        """
    "${jdk}\plugin.jar"
""".trimIndent(),
        """
    "${jdk}\resources.jar"
""".trimIndent(),
        """
    "${jdk}\rt.jar"
""".trimIndent()
)
val requiredInput = jdkLib + arrayOf(
        """${mavenCache}\org\spigotmc\spigot-api\1.12.2-R0.1-SNAPSHOT\spigot-api-1.12.2-R0.1-20180323.084251-124.jar""",
        """${baseDir}\libraries\"""
).distinct()
val keep: String = """com.kisaragieffective.opencommandblock.OpenCommandBlock"""
/**
 * If false, you can't minimize until fix all warnings.
 */
val ignoreWarn: Boolean = true
/**
 * Hey. It's HIGHLY NOT recommended cause this can trigger VerifyError.
 */
val doPreVerify: Boolean = true
val doObfuscate: Boolean = false
val jdkVersion: Number = 8
var moreOption: Array<String> = emptyArray()

val jre = """
"C:\Program Files\Java\jdk1.8.0_144\bin\java.exe"
""".trimIndent()
var baseCommand = "${jre} -jar ${proguard} -injars ${inTarget} -keep class ${keep} -libraryjars ${requiredInput.joinToString(";")} -outjars ${outTarget} "
val logger: Logger = java.util.logging.Logger.getLogger("RunProguard")
logger.info("The target version is: $targetVersion")
val env: Logger = java.util.logging.Logger.getLogger("RunProguard.Env")
env.info("The Java Runtime: $jre")
if (ignoreWarn) {
    moreOption += "-ignorewarnings"
}

if (!doPreVerify) {
    moreOption += "-dontpreverify"
}

if (!doObfuscate) {
    moreOption += "-dontobfuscate"
}

moreOption += "-forceprocessing"
moreOption += "-target ${jdkVersion}"

val finalCommand: String = "$baseCommand${moreOption.joinToString(" ")}".trim()

val file = File("""${baseDir}\build\runproguard.cmd""")
try {
    file.delete()
    file.createNewFile()
    // CMD must be written in SJIS
    val fw = PrintWriter(file, Charset.forName("windows-31j").name())
    fw.println("@REM AUTO GENERATED")
    fw.println("SET TARGET_VERSION=${targetVersion}")
    fw.println(finalCommand)
    fw.flush()
    fw.close()
} catch (e: IOException) {
    println(e)
}

ProcessBuilder().command("""C:\Windows\System32\cmd.exe""", """/c""", """${baseDir}\build\runproguard.cmd""").redirectErrorStream(true).redirectOutput(ProcessBuilder.Redirect.INHERIT).start()

fun NodeList.children(): List<Node> {
    return (0..(this.length - 1)).map { i ->
        this.item(i)
    }
}

fun check(fullPath: String) {
    val finalFullPath: String
    finalFullPath = if (fullPath.startsWith('"') && fullPath.endsWith('"')) {
        fullPath.subSequence(1, fullPath.length - 1)
    } else {
        fullPath
    }.toString()
    return File(finalFullPath).exists({
        println("Exists ${it.canonicalPath}")
    }, {
        println("Not exists ${it.canonicalPath}!")
    })
}

fun <T : Any> File.exists(yesCallback: (File) -> T, noCallback: (File) -> T): T {
    return if (this.exists()) {
        yesCallback.invoke(this)
    } else {
        noCallback.invoke(this)
    }
}

fun File.tryDelete(): Boolean {
    return if (this.exists()) {
        this.delete()
    } else {
        false
    }
}


/*
// --- EXECUTE'em
println(finalCommand)
val dir = File(baseDir, "build")
val proc = Runtime.getRuntime().exec(finalCommand, emptyArray(), dir)
val watchdog = thread {
    Thread.sleep(500)
    proc.inputStream.bufferedReader().lines().forEach {
        println(it)
    }
}

while (proc.isAlive) {
}

println("EXITED. CODE: ${proc.exitValue()}")
exitProcess(0)


/**
 * This function take O(n).
 */

/*
java -jar C:\Users\Obsidian550D\Documents\intellij\OpenCommandBlock\build\proguard6.0.3\lib\proguard.jar -injars inTarget\OpenCommandBlock-1.0.0.jar -libraryjars "%JAVA_HOME%\jre\lib\";C:\Users\Obsidian550D\.m2\repository\org\spigotmc\spigot-api\1.12.2-
R0.1-SNAPSHOT\spigot-api-1.12.2-R0.1-20180323.084251-124.jar;.\libraries\ -outjars inTarget\OpenCommandBlock-1.0.0-pg.jar
*/
*/