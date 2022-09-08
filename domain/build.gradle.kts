plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
//    id("kotlin-kapt")
}

dependencies {
    /*------------------------Coroutines----------------------------------*/
    val coroutinesVersion = "1.6.4"
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

    /*------------------------Dagger Hilt----------------------------------*/
    val hiltVersion = "2.42"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
//    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}