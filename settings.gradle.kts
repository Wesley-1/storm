rootProject.name = "storm"
setupStormModule(
    "storm-core",
    listOf(
        Pair("storm-modules", listOf("modules-api", "modules-test")),
        Pair("storm-files", listOf("files-test", "files-api")),
        Pair("storm-utils", listOf("utils-test", "utils-api"))))

setupStormModule(
    "storm-server",
    listOf(
        Pair("storm-menus", listOf("menus-api", "menus-test")))
)

fun setupStormModule(base: String, setup: List<Pair<String, List<String>>>) =
    setup.forEach { pair
        -> pair.second.forEach { name
            -> setupSubproject(name, file("$base/${pair.first}/$name"))
        }
    }


fun setupSubproject(name: String, projectDirectory: File) = setupSubproject(name) {
    projectDir = projectDirectory
}

inline fun setupSubproject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}