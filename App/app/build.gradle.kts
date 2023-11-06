plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.tezov.plugin_project.config")
}

tezovConfig {

    configuration {
        domain = "com.tezov.medium.gradle_plugin.from_setting.app"
    }

    version {
        major = 1
        minor = 0
        patch = 0
        //alpha = 1
        //beta = null
        //rc = null
    }

    debug {
        keepProguard = true
        keepSourceFile = true
        repackage = false
        obfuscate = false
        minify = false
        hasJUnitRunner = true
    }

    release {
        enableDebug = true
    }

    configureAndroidPlugin()
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.5.0-rc01")
    implementation("androidx.compose.ui:ui-graphics:1.5.0-rc01")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.1")
}