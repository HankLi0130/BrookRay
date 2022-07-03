# BrookRay

This project has been deprecated.

## Description

Basic Kotlin constants, functions and classes to help building Android Apps efficiently.

## How to install?

1. Using Gradle 7 or above, add it in your root `settings.gradle` at the end of repositories:

``` gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Otherwise, add it in your root `build.gradle` at the end of repositories:

``` gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
	}
}
```

2. Add the dependency in your app `build.gradle`

``` gradle
dependencies {
    implementation 'com.github.hankli0130:BrookRay:1.0.4'
}
```

That's it !