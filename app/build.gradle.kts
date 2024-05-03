plugins {
    id("com.android.application" )
    id("org.jetbrains.kotlin.android" )
    // Annotation Processor NEW
    id("com.google.devtools.ksp" )
}

android {
    namespace = "com.navi9519.labb_3_cocktail_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.navi9519.labb_3_cocktail_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0" )
// GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0" )
// ViewModel Scope
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0" )
// coil - Image Loader
    implementation ("io.coil-kt:coil-compose:2.6.0" )

    // https://mvnrepository.com/artifact/io.github.raamcosta.compose-destinations/core
    // Destinations - Navigation dependencies
   /* implementation ("io.github.raamcosta.compose-destinations:core:1.10.2" )
    ksp("io.github.raamcosta.compose-destinations:ksp:1.10.2" )

    */

    // Room DB
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    androidTestImplementation("androidx.room:room-testing:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1" )
    // To use Kotlin annotation processing tool (kapt)
    // ksp("androidx.room:room-compiler:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}