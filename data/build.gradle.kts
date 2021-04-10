plugins {
  kotlin("jvm")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation(Dependencies.retrofit)
  implementation(Dependencies.moshi)
  implementation(Dependencies.okhttp)
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
}
