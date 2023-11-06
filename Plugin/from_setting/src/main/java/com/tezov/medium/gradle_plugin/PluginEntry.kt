package com.tezov.medium.gradle_plugin

import com.tezov.medium.gradle_plugin.PluginEntry.Companion.PLUGIN_ID
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

private val Settings.extension get()  = extensions.findByName(PluginEntry.EXTENSION_NAME) as? SettingsExtension

fun Settings.applyPluginToAllProjects(classpath:String, id: String) {
    extension?.beforeProjects(classpath, id)
        ?: throw GradleException("you need to apply the plugin $PLUGIN_ID before to use this extension")
}

class PluginEntry : Plugin<Settings> {

    companion object {
        internal const val PLUGIN_ID = "com.tezov.medium.gradle_plugin.from_setting"
        internal const val EXTENSION_NAME = "myCustomSetting"
    }

    override fun apply(settings: Settings) {
        settings.extensions.create(EXTENSION_NAME, SettingsExtension::class.java, settings)
    }

}
