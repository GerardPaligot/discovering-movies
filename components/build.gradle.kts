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
        api(project(":theming"))
        api(project(":extensions"))

        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material)
      }
    }
    named("androidMain") {
      dependencies {
        implementation(Dependencies.Compose.uiTooling)
        implementation(Dependencies.Accompanist.coil)
      }
    }
  }
}
