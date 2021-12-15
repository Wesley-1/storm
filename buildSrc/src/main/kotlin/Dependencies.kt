// Contains all version information for out dependencies.
object Versions {
    const val SPIGOT_VERSION = "1.17.1-R0.1-SNAPSHOT"
    const val LOMBOK_VERSION = "1.18.20"
    const val REFLECTIONS_VERSION = "0.10.2"
}

object Dependencies {
    const val SPIGOT = "org.spigotmc:spigot-api:${Versions.SPIGOT_VERSION}"
    const val LOMBOK = "org.projectlombok:lombok:${Versions.LOMBOK_VERSION}"
    const val REFLECTIONS = "org.reflections:reflections:${Versions.REFLECTIONS_VERSION}"
}