object AndroidSdk {
  const val apiLevel = 30
  const val minSdk = 21
  const val target = apiLevel
}

object Versions {
  const val kotlin = "1.4.32"
  const val compose = "1.0.0-beta03"
  const val jbCompose = "0.4.0-build179"
  const val accompanist = "0.7.0"

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
    const val activity = "androidx.activity:activity-compose:1.3.0-alpha05"
    const val navigation = "androidx.navigation:navigation-compose:1.0.0-alpha09"
  }

  object AndroidX {
    const val core = "androidx.core:core-ktx:1.3.2"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val material = "com.google.android.material:material:1.3.0"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:2.2.0"
  }

  object Accompanist {
    const val coil = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
    const val uiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
  }
}
