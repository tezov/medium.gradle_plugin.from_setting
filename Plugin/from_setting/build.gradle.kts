plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "com.tezov.medium.gradle_plugin"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        create(project.group as String) {
            id = "$name.from_setting"
            implementationClass = "${name}.PluginEntry"
            displayName = "My Custom Plugin"
            description = "super cool plugin which create a shared map"
        }
    }
}