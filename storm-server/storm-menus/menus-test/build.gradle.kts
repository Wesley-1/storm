setupShadowJar()

dependencies {
    compileOnly(Dependencies.SPIGOT)
    compileOnly(Dependencies.LOMBOK)
    annotationProcessor(Dependencies.LOMBOK)

    implementation(project(":menus-api"))

}