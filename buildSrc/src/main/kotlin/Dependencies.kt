object AndroidSdk {
  const val apiLevel = 30
  const val minSdk = 24
  const val target = apiLevel
  const val buildTools = "30.0.3"
}

object Versions {
  const val kotlin = "1.5.10"
  const val compose = "1.0.0-beta09"
  const val jbCompose = "0.5.0-build225"
  const val accompanist = "0.12.0"

  const val datetime = "0.1.1"

  const val retrofit = "2.9.0"
  const val moshi = "2.4.0"
  const val okhttp = "4.9.1"
}

object Dependencies {
  const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}"
  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
  const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
  const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

  const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

  object Compose {
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:1.3.0-beta2"
    const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha03"
  }

  object AndroidX {
    const val core = "androidx.core:core-ktx:1.3.2"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val material = "com.google.android.material:material:1.3.0"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
  }

  object Accompanist {
    const val coil = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
    const val uiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
  }
}
