plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.wandroid.traceroute.sample"
        minSdk = 21
        targetSdk = 33
        namespace = "com.wandroid.traceroute.sample"
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":library")) // Assuming your library module is named 'library'
    implementation(kotlin("stdlib"))
    implementation("com.google.android.material:material:1.9.0")  // Or the latest version
    implementation("androidx.appcompat:appcompat:1.6.0")  // Or the latest version
}