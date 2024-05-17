import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
//    alias(libs.plugins.room)
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    jvmToolchain(17)

    androidTarget()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.bundles.koin.android)
            api(compose.preview)
            api(compose.uiTooling)
            api(compose.components.uiToolingPreview)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.materialIconsExtended)

            implementation(libs.kolor.core)
            implementation(libs.kermit.core)
            implementation(libs.windowSizeClass)

//            implementation(libs.bundles.room)
            implementation(libs.bundles.koin.main)
            implementation(libs.bundles.kotlinx)
            implementation(libs.bundles.ktorfit)
            implementation(libs.bundles.precompose)
            implementation(libs.bundles.multiplatformSettings)
        }
    }
}

android {
    namespace = "net.yuuzu.econotracker"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "net.yuuzu.econotracker"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildToolsVersion = "34.0.0"
    buildFeatures {
        compose = true
    }
    composeOptions {
        val fullVersion = extensions.getByType(ComposeExtension::class.java)
            .dependencies.compiler.auto.substringAfterLast(":")
        val mainVersion = fullVersion.split(".").take(3).joinToString(".")
        kotlinCompilerExtensionVersion = mainVersion

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

//room {
//    schemaDirectory("$projectDir/schemas")
//}

dependencies {
//    ksp(libs.room.compiler)
    with(libs.ktorfit.ksp) {
        add("kspCommonMainMetadata", this)
        add("kspAndroid", this)
        add("kspAndroidTest", this)
        add("kspIosX64", this)
        add("kspIosX64Test", this)
        add("kspIosArm64", this)
        add("kspIosArm64Test", this)
        add("kspIosSimulatorArm64", this)
        add("kspIosSimulatorArm64Test", this)
    }
}
