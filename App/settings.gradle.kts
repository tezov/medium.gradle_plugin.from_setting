//need to be added to be able to use the Settings extension of the plugin
import com.tezov.medium.gradle_plugin.applyPluginToAllProjects

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
    id("com.tezov.medium.gradle_plugin.from_setting") version "1.0.0" apply true // Here apply the plugin
}

// here use the plugin to apply this plugin to all project

//** The goal here is not really to apply plugin to all projects, you don't need a custom plugin
//** to do that. The goal is to show that it is possible to apply plugin from within another plugin with a specified version
//** with a parameter coming from outside the plugin.
//** the important part here is "WITH A SPECIFIED VERSION". Without the classpath, you can't !
//** why ??? because now you can do a custom catalog plugin and embedded the plugin version inside your catalog plugin source

applyPluginToAllProjects(
    "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0",
    "org.jetbrains.kotlin.android"
)

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}