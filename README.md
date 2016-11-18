# Udemy에서 진행하는 Kotlin 샘플 자료

[![License](https://img.shields.io/hexpm/l/plug.svg)]()

Udemy 코틀린 안드로이드 시작하기! 강좌의 샘플 자료입니다.

`part 16` 상세 페이지 추가하는 예제입니다.

Intent를 넘길때 putExtra을 사용한 예제와 Kotlin에서 Parcelable을 추가하는 예제입니다.

## 포함된 자료

- Java : [Java sample](https://github.com/taehwandev/Kotlin-Udemy-Sample/tree/11-Add-Detail-Page/app-java/src/main)
- Kotlin : [Kotlin sample](https://github.com/taehwandev/Kotlin-Udemy-Sample/tree/11-Add-Detail-Page/app-kotlin/src/main)
  - [Kotlin putExtra Sample](https://github.com/taehwandev/Kotlin-Udemy-Sample/tree/11-Add-Detail-Page/sample_01_putextra/src/main)
  - [Kotlin BottomSheet Sample](https://github.com/taehwandev/Kotlin-Udemy-Sample/tree/11-Add-Detail-Page/sample_02_bottomsheet/src/main)

## Preview Java

| Java Sample       |                 |
|:-----------------:|:---------------:|
| ![sample_java_01] |![sample_java_02]|

## Preview Kotlin

| Kotlin Sample       |                 |
|:-------------------:|:-----------------:|
| ![sample_kotlin_01] |![sample_kotlin_02]|
| ![sample_kotlin_03] |![sample_kotlin_04]|

## Kotlin image load library

![sample_kotlin_anim]


## 이번 장에서 사용한 API

- [Glide](https://github.com/bumptech/glide)
- [Retrofit 2.0](https://square.github.io/retrofit/)
- [OkHttp](https://github.com/square/okhttp)
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
- [Thdev Android Base](https://github.com/taehwandev/AndroidBase)
    - 제가 작성한 Android Base(Kotlin 기반)의 코드를 사용하였습니다.(MVP 패턴으로 작성)

## 개발 버전에 대한 정보
- buildToolsVersion = 24.0.3
- compile sdk version = 24
- Target sdk version = 24
- Min sdk version = 16
- Android studio = 2.2.2

## 사용한 라이브러리 현황
- Kotlin library
    - Kotlin version = 1.0.5
- [Android support library](https://developer.android.com/topic/libraries/support-library/revisions.html)
    - support libraryVersion = 24.2.1

## API Key

- Create Flickr api key.
    - [Flickr web page](https://www.flickr.com/services/apps/create/)
- Add a flickr api key `local.properties`.
    - flickrApiKey="Flickr api key"

## Load 실패가 발생할 경우

![load_fail]

위와 같은 화면을 확인하였다면 다음의 순서대로 따라주세요.

- [API 생성 페이지로 이동합니다.](https://www.flickr.com/services/apps/create/)
    - 다음의 페이지에서 01. `API 키 요청`을 눌러주세요.
        ![flickr_01]
    - `비상업용 키 신청`을 눌러주세요.
        ![flickr_02]
    - App의 이름과 설명을 간단하게 작성해주세요.
        ![flickr_03]
    - App 키가 발급되었습니다.
        ![flickr_04]
    - 발급받은 APP 키를 `local.properties`에 아래와 같이 추가하세요.
        `flickrApiKey="발급 받은 키"`
        ![flickr_05]

## License

```
Copyright 2016 Tae-hwan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[load_fail]: images/load_fail.png

[flickr_01]: images/flickr_01.png
[flickr_02]: images/flickr_02.png
[flickr_03]: images/flickr_03.png
[flickr_04]: images/flickr_04.png
[flickr_05]: images/flickr_05.png

[sample_java_01]: images/sample_java_01.png
[sample_java_02]: images/sample_java_02.png

[sample_kotlin_01]: images/sample_kotlin_01.png
[sample_kotlin_02]: images/sample_kotlin_02.png
[sample_kotlin_03]: images/sample_kotlin_03.png
[sample_kotlin_04]: images/sample_kotlin_04.png
[sample_kotlin_anim]: images/sample_kotlin_anim.gif