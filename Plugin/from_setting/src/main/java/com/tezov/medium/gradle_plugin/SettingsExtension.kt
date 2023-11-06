package com.tezov.medium.gradle_plugin

import org.gradle.api.initialization.Settings

abstract class SettingsExtension constructor(
    private val settings: Settings
) {

    internal fun beforeProjects(classpath:String, id: String) {
        settings.gradle.rootProject {
            buildscript.dependencies.add("classpath", classpath)
        }
        settings.gradle.allprojects p@ {
            if(this != rootProject) {
                plugins.whenPluginAdded {
                    this@p.extensions.findByName("android")?.let {
                        this@p.plugins.apply(id)
                    }
                }
            }
        }
    }

}