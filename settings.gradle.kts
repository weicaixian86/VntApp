pluginManagement {
    repositories {
        // 官方仓库优先：CI 上 Aliyun 镜像偶发 HTTP 502 会导致依赖解析直接失败。
        // 官方源更稳定，排在前面即可保证命中；Aliyun 仅作国内加速补充，放在最后。
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 官方仓库优先，Aliyun 镜像作为国内加速补充放在最后，
        // 避免单一镜像 502 导致整条构建失败。
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/central")
    }
}

rootProject.name = "VntApp"
include(":app")
