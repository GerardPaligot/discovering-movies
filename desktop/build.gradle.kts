import org.jetbrains.compose.compose

plugins {
  kotlin("jvm")
  id("org.jetbrains.compose")
}

group = "com.paligot.movies"
version = "1.0.0"

dependencies {
  implementation(project(":components"))
  implementation(project(":data"))
  implementation(compose.desktop.currentOs)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
  kotlinOptions.jvmTarget = "1.8"
}

compose.desktop {
  application {
    mainClass = "com.paligot.movies.desktop.MainKt"
    this.args.add(project.properties["THE_MOVIE_DB_API_KEY"] as String)
  }
}
