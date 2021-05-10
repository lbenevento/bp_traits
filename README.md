# Python regius genetics for Android

This is a library you can use if you are developing an app that requires Python regius (ball python) genetic related functions.

# Getting started

In your project level build.gradle:
```
allprojects {
  repositories {
    maven {
      name = "bp_traits"
      url = uri("https://maven.pkg.github.com/beneventolorenzo/bp_trait")
    }
  }
}
```

In your module build.gradle:
```
dependencies {
  implementation "com.scitalys:bp_traits:1.0.3"
}
```
