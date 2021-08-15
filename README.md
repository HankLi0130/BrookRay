# BrookRay

[![](https://jitpack.io/v/HankLi0130/BrookRay.svg)](https://jitpack.io/#HankLi0130/BrookRay)

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
    implementation 'com.github.HankLi0130.BrookRay:core:Tag'
    implementation 'com.github.HankLi0130.BrookRay:recyclerview:Tag'
    implementation 'com.github.HankLi0130.BrookRay:ui:Tag'
}
```

**Note**: You must add core module while using recyclerview or ui module !

That's it !