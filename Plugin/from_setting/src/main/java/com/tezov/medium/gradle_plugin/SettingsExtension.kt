package com.tezov.medium.gradle_plugin

import org.gradle.api.initialization.Settings

abstract class SettingsExtension constructor(
    private val settings: Settings
) {

    companion object {
        internal const val KEY_PLUGINS = "libraries"
    }

    internal fun beforeProjects(alias: String, pluginCoordinates: String, pluginVersion:String) {
        val domainPlugins = settings
            .dependencyResolutionManagement
            .versionCatalogs
            .let {
                it.findByName(KEY_PLUGINS) ?: it.create(KEY_PLUGINS)
            }
        with(domainPlugins) {
            plugin(alias, pluginCoordinates).version(pluginVersion)
        }
        settings.gradle.allprojects {
            if(this != rootProject) {
                project.plugins.apply(pluginCoordinates)
            }
        }
    }

}