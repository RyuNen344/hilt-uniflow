package dependencies

object Dep {

    object GradlePlugin {

        object Android {
            const val android = "com.android.tools.build:gradle:4.0.0"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-rc01"
        }

        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
    }

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha01"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta7"
        const val emoji = "androidx.emoji:emoji-appcompat:1.0.0"
        const val design = "com.google.android.material:material:1.3.0-alpha01"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.0-alpha06"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.0-alpha04"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0-rc01"

        object LiveData {
            const val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.3.0-alpha04"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha04"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:2.3.0-alpha04"
        }

        object Navigation {
            const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:2.3.0-rc01"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.0-rc01"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:2.3.0-rc01"
        }
    }

    object Kotlin {
        const val version = "1.3.72"

        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        const val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"

        object Coroutines {
            const val version = "1.3.7"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        object Serialization {
            private const val version = "0.20.0"

            const val serializationAndroid = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$version"
        }
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:2.28-alpha"
        const val compiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"

        object Android {
            const val hilt = "androidx.hilt:hilt-common:1.0.0-alpha01"
            const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
            const val compiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
        }
    }

    object Ktor {
        private const val version = "1.3.2"
        const val clientCore = "io.ktor:ktor-client-core:$version"
        const val clientOkhttp = "io.ktor:ktor-client-okhttp:$version"
        const val json = "io.ktor:ktor-client-json-jvm:$version"
        const val serialization = "io.ktor:ktor-client-serialization-jvm:$version"
    }

    object OkHttp {
        private const val version = "4.7.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Groupie {
        const val groupie = "com.xwray:groupie:2.8.0"
        const val viewbinding = "com.xwray:groupie-viewbinding:2.8.0"
    }

    object Klock {
        const val common = "com.soywiz.korlibs.klock:klock:1.11.9"
    }

    object Timber {
        const val android = "com.jakewharton.timber:timber-android:5.0.0-SNAPSHOT"
    }
}
