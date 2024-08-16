plugins {
    id("com.android.library")
    kotlin("android") // Applies Kotlin plugin for Android
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        namespace = "com.wandroid.traceroute"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(kotlin("stdlib"))
}