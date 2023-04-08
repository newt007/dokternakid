# SumbanginAja

## <a name="introduction"></a> Introduction :
SumbanginAja is food sharing app that connecting people who have surplus food and people who wish or needs the food. SumbanginAja App Powered by Kotlin, Android Jetpack, and Koin, also implementing [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Libraries](#libraries)
- [Project Structure](#project-structures)

## <a name="features"></a> Features :
A few features SumbanginAja's has on this app :

* Login and Register
* Get nearest surplus food around you
* See food detail
* Add new surplus food
* Generating barcode
* Transaction food between gifter and receiver


## <a name="libraries"></a> Libraries :
  - [Android Jetpack](https://developer.android.com/jetpack)
  - [Lifecycle & Livedata](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  - [Kotlin Flow](https://developer.android.com/kotlin/flow)
  - [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation)
  - [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)    
  - [Retrofit](https://square.github.io/retrofit/)
  - [Koin as Dependency Injection](https://insert-koin.io/)   
  - [Ok Http 3](https://square.github.io/okhttp/) 
  - [Lottie Animation](https://github.com/airbnb/lottie-android)

## <a name="project-structures"></a> Project Structure :
* `base`
* `data`
  - `auth`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `food`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `lib`
  - `region`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
* `di`
* `domain`
  - `auth`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `food`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `region`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
* `presentation`
  - `auth`
    - `login`
      - `fragment`
      - `viewmodel`
    - `register`
      - `fragment`
      - `viewmodel`
  - `customview`
  - `dialog`
  - `food`
      - `fragment`
      - `viewmodel`
  - `home`
      - `fragment`
      - `viewmodel`
  - `profile`
      - `fragment`
      - `viewmodel`
  - `region`
      - `fragment`
      - `viewmodel`
  - `scanner`
      - `fragment`
      - `viewmodel`
  - `splash`
      - `fragment`
      - `viewmodel`
* `utils`
  - `ext`

