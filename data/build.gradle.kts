plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp").version("1.6.0-1.0.1")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.faz.data"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("com.google.android.material:material:1.6.1")
    implementation(":domain.main")
    implementation(project(mapOf("path" to ":domain")))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    /*------------------------Coroutines----------------------------------*/
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    /*------------------------Network----------------------------------*/
    implementation ("com.github.skydoves:sandwich:1.2.7")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    /*------------------------Json parsing----------------------------------*/
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")

    /*------------------------Dagger Hilt----------------------------------*/
    val hiltVersion = "2.42"
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    implementation ("com.google.dagger:hilt-android-compiler:$hiltVersion")

    /*-------------------------------Room----------------------------------*/
    implementation ("androidx.room:room-ktx:2.4.3")

    /*----------------------------DataStore-------------------------------*/
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
}