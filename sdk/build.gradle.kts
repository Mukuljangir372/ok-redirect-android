@file:Suppress("DEPRECATION", "UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = "com.ok.redirect.sdk"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.androidx.nav)
    implementation(libs.bundles.androidx.ktx)
}