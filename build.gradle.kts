plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
    id("maven-publish")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 25
        targetSdk = 31
        version = getVersionName()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles.add(File("consumer-rules.pro"))
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
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.core)
    implementation(Deps.appCompat)

    testImplementation(TestingDeps.junit)
    androidTestImplementation(TestingDeps.androidJunit)
    androidTestImplementation(TestingDeps.espresso)

}

// Publishing

val env: MutableMap<String, String> = System.getenv()
val githubUsr = env["GITHUB_USR"]
val githubKey = env["GITHUB_PACKAGES_KEY"]

fun getVersionName(): String {
    return "1.2.0-alpha03"
}

fun getArtifactId(): String {
    return "bp_traits"
}

publishing {
    publications {
        create<MavenPublication>("gpr") {

            groupId = "com.scitalys"
            artifactId = getArtifactId()
            version = getVersionName()
            artifact("$buildDir/outputs/aar/${getArtifactId()}-release.aar")

            pom.withXml {
                val dependenciesNode = asNode().appendNode("dependencies")

                configurations.api.get().allDependencies.forEach {
                    val dependencyNode = dependenciesNode.appendNode("dependency")
                    dependencyNode.appendNode("groupId", it.group)
                    dependencyNode.appendNode("artifactId", it.name)
                    dependencyNode.appendNode("version", it.version)
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/beneventolorenzo/bp_traits")
            credentials {
                username = githubUsr
                password = githubKey
            }
        }
    }

}


tasks.register("deleteArtifact", Delete::class.java) {
    delete("$buildDir/outputs/aar/${getArtifactId()}-release.aar")
}

tasks.withType(PublishToMavenRepository::class.java) {
    dependsOn("test")
    dependsOn("build")
    mustRunAfter("deleteArtifact")
}