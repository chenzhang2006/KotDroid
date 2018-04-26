# KotDroid (Summer 2017)

Demo Android app of fetching github repo as *Proof of Concept* for:

- *Kotlin*: All application code and dagger configuration
- *Dagger 2*: Custom scope @PerActivity to manage lifecycle of MVP Presenter(retained across screen config changes)
- *Model-View-Presenter(MVP)*: Decouple business logic with UI controllers(Activity/Fragment)
- *RxJava*: Interface with network resource
- *Retrofit* with OkHttp and JSON

Network endpoint:
https://api.github.com/users/{user}/repos/
