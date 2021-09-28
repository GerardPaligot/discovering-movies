import org.jetbrains.compose.compose

plugins {
  id("com.android.library")
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

android {
  compileSdk = AndroidSdk.apiLevel

  defaultConfig {
    minSdk = AndroidSdk.minSdk
    targetSdk = AndroidSdk.target
    buildToolsVersion = AndroidSdk.buildTools
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
        implementation(project(":components"))
        implementation(project(":theming"))
        implementation(project(":data"))

        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material)
      }
    }
    named("androidMain") {
      dependencies {
        implementation(compose.preview)
      }
    }
    named("desktopMain") {
      dependencies {
        implementation(compose.preview)
      }
    }
  }
}
