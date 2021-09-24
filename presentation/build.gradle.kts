import org.jetbrains.compose.compose

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.paligot.movies"
version = "1.0.0"

repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation(project(":components"))
    implementation(project(":theming"))
    implementation(compose.desktop.currentOs)
    implementation("com.paligot.kighlighter:kighlighter-compose-desktop:1.0.0-SNAPSHOT")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

compose.desktop {
    application {
        mainClass = "com.paligot.movies.presentation.MainKt"
    }
}
