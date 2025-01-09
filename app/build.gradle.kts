plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.elite"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.elite"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //cardView
    implementation("androidx.cardview:cardview:1.0.0")

    //all screen dependancy
    implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation("com.android.volley:volley:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("com.google.android.material:material:1.3.0-alpha02")

    //cercular image view
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    implementation ("com.squareup.picasso:picasso:2.71828")
}