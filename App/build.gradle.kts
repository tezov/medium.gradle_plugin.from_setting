buildscript {

    // theses are the repositories needed by the plugin to resolve the classpath
    // could be added by the plugin itself. But I prefer to keep them outside

    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

}
