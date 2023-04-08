# Dokternak

## <a name="introduction"></a> Introduction :
DOKTERNAK: Aplikasi Pencarian Petugas Kesehatan Hewan di Kabupaten Bondowoso, Jawa Timur, Indonesia

![banner](https://user-images.githubusercontent.com/36506828/230712990-77bb915b-aa4a-47ac-8041-9c37ca1259c9.png)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Libraries](#libraries)
- [Project Structure](#project-structures)


## <a name="features"></a> Features :
A few features Dokternak's has on this app : <br/><br/>
<img src="https://user-images.githubusercontent.com/36506828/230712554-00a39776-1b86-407a-ae5c-26afdbbc71d3.png" width=200/>
<img src="https://user-images.githubusercontent.com/36506828/230713120-d10e9396-fcc5-4ab8-8660-186429c83212.png" width=200/>
<img src="https://user-images.githubusercontent.com/36506828/230712558-f2ee2683-e86f-47c8-8b93-aa220c4fa2e8.png" width=200/>
<img src="https://user-images.githubusercontent.com/36506828/230712560-64098b99-991d-44a2-bcea-f2fad6a34911.png" width=200/>


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
  - `article`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `category`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `consultation`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `lib`
  - `membership`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `officer`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
  - `puskeswan`
    - `model`
    - `remote`
    - `datastore`
    - `repository`
* `di`
* `domain`
  - `article`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `category`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `consultation`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `membership`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `officer`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
  - `puskeswan`
    - `mapper`
    - `model`
    - `interactor`
    - `usecase`
* `presentation`
  - `article`
  - `consultation`
  - `home`
  - `login`
  - `officer`
  - `profile`
  - `puskeswan`
  - `register`
  - `splash`
* `utils`
  - `ext`

