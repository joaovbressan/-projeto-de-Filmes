plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.projetodefilmes"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.projetodefilmes"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version") // ADICIONE ESTA LINHA
    implementation("androidx.room:room-ktx:$room_version") // ADICIONE ESTA LINHA
    kapt("androidx.room:room-compiler:$room_version") // ADICIONE ESTA LINHA

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3") // ADICIONE ESTA LINHA
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3") // ADICIONE ESTA LINHA

    // Coletar Flow no Compose
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8") // ADICIONE ESTA LINHA
    implementation("androidx.compose.runtime:runtime-rxjava2:1.6.8") // ADICIONE ESTA LINHA
}