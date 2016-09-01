# DBC-Android
Fluent design by contract assertions for Android

[![JitPack](https://jitpack.io/v/busybusy/DBC-Android.svg)](https://jitpack.io/#busybusy/DBC-Android)
[![Build Status](https://travis-ci.org/busybusy/DBC-Android.svg?branch=master)](https://travis-ci.org/busybusy/DBC-Android)

## Installation
Add the JitPack repository to your root build.gradle:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

In your module's build.gradle file, add the dependency:
```groovy
dependencies {
    ...
    compile 'com.github.busybusy:DBC-Android:{LatestVersionHere}'
}
```

## Usage

Use the design by contract assertions throughout your code to verify assumptions
```java
import static com.busybusy.dbc.Dbc.*;

@NonNull
public String someMethod(@NonNull String arg1) {
    require(arg1).isNotNull();
    
    //or with a custom message
    require(arg1).message("See \"foo()\" for \"someMethod(String)\" usage example").isNotNull();
    
    String postFix = getPostFix();
    
    check(postFix).passes(CustomChecks::someCheck) //Java 8 method refference 
                  .passes((subject) -> subject.length() > 2) //Java 8 lambda syntax
                  .passes(new SomeCustomYetFrequentCheck()) //Prebuilt check with concrete type 
                  .passes(new DbcBlock<String>() { //Java 6/7 anonymous class   
                      @Override
                      boolean checkState(String subject) {
                          return subject.length() > 2;
                      }
                  }); 
    
    String result = arg1 + postFix;
    ensure(result).isValid();
    return result;
}
```

## Build time removal

To remove the assertions from your code simple ensure that proguard minify is enabled and that you are using a config similar to the following:
```groovy
proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
```

The configuration necessary for proguard to remove the dbc related methods is included in the AAR dependency and should be automatically applied.

Due to the nature of dbc assertions and that they typically result in a fatal error,
it is highly recommend you verify that your proguard configuration is correctly removing all related method calls before publishing your release APK to the play store.

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
