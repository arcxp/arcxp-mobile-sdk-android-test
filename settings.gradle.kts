import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}



val localProperties = Properties().apply {
    file("local.properties").inputStream().use {
        load(it)
    }
}

val githubUserId: String? = localProperties.getProperty("GITHUB_USER_ID")
val githubToken: String? = localProperties.getProperty("GITHUB_PERSONAL_ACCESS_TOKEN")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            credentials {
                username = githubUserId ?: ""
                password = githubToken ?: ""
            }
            url = uri("https://maven.pkg.github.com/arcxp/arcxp-sdk-android")
        }
    }
}

rootProject.name = "My Application"
include(":app")
 