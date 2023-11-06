package com.tezov.medium.gradle_plugin

import org.gradle.api.initialization.Settings

abstract class SettingsExtension constructor(
    private val settings: Settings
) {

    internal fun beforeProjects(classpath:String, id: String) {
        settings.gradle.rootProject {
            buildscript.dependencies.add("classpath", classpath)
        }
        settings.gradle.allprojects  {
            if(this != rootProject) {
                plugins.whenPluginAdded {
                    extensions.findByName("android")?.let {
                        plugins.apply(id)
                    }
                }
            }
        }
    }

}