import org.jetbrains.compose.compose

plugins {
  id("com.android.library")
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

android {
  compileSdkVersion(AndroidSdk.apiLevel)

  defaultConfig {
    minSdkVersion(AndroidSdk.minSdk)
    targetSdkVersion(AndroidSdk.target)
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  sourceSets {
    named("main") {
      manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
  }

  configurations {
    create("androidTestApi")
    create("androidTestDebugApi")
    create("androidTestReleaseApi")
    create("testApi")
    create("testDebugApi")
    create("testReleaseApi")
  }
}

kotlin {
  android()
  jvm("desktop")

  sourceSets {
    named("commonMain") {
      dependencies {
        implementation(compose.foundation)
        implementation(Dependencies.datetime)
      }
    }
  }
}