plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlinx.kover") version "0.7.0-Beta"
}

android {
    namespace = "com.example.walmart"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.wallmartexample"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    
}

tasks.withType<Test> {
    useJUnitPlatform() // For unit tests
    extensions.configure(org.jetbrains.kotlinx.kover.api.KoverTestTaskExtension::class) {
        isEnabled.set(true)
    }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    kover {
    coverageEngine.set(org.jetbrains.kotlinx.kover.api.CoverageEngine.INTELLIJ)
    htmlReport { onCheck.set(true) }
    xmlReport { onCheck.set(true) }
}
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    // For Robolectric (JVM-based unit tests)
    testImplementation 'org.robolectric:robolectric:4.9'

    // For Espresso (UI testing)
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation 'androidx.test:runner:1.4.0'
    androidTestImplementation 'androidx.test:rules:1.4.0'

    // For Navigation testing
    androidTestImplementation 'androidx.navigation:navigation-testing:2.5.0'
    androidTestImplementation 'androidx.fragment:fragment-testing:1.5.0'

    // For Kover (Test coverage)
    testImplementation 'org.jetbrains.kotlinx:kover-api:0.7.0-Beta'
    testImplementation 'org.jetbrains.kotlinx:kover-agent:0.7.0-Beta'
}
