plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dinesh.jetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dinesh.jetpackcompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            buildConfigField("String", "API_KEY", "\"AIzaSyB5ViqyXdP9h-rHPvPBEg1zJKKa1puRRf4\"")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            buildConfigField("String", "API_KEY", "\"AIzaSyB5ViqyXdP9h-rHPvPBEg1zJKKa1puRRf4\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    val nav_version = "2.7.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.compose.runtime:runtime-livedata:1.6.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

    implementation("com.google.ai.client.generativeai:generativeai:0.9.0")

    implementation("androidx.media3:media3-exoplayer:1.2.1")
    implementation("androidx.media3:media3-ui:1.2.1")
    implementation("androidx.media3:media3-exoplayer-hls:1.2.1")

    //    Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    implementation("androidx.biometric:biometric:1.1.0")
}