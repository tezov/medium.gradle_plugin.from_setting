import com.tezov.medium.gradle_plugin.myCustomPluginSource

rootProject.name = "App"
include(":app")

pluginManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

buildscript {

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    }

    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

plugins {
    id("com.tezov.medium.gradle_plugin.from_setting") version "1.0.0" apply true
    id("com.tezov.plugin_project.config") version "1.0.8-1" apply false
}

//myCustomPluginSource("tezov", "com.tezov.plugin_project.config", "1.0.8-1")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

}