plugins {
  id("java-library")
  id("kotlin")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation(Dependencies.retrofit)
  implementation(Dependencies.moshi)
  implementation(Dependencies.okhttp)
}
