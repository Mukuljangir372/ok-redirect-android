plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.gradle)
    compileOnly(gradleApi())
}