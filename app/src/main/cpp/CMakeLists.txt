### For more information about using CMake with Android Studio, read the
### documentation: https://d.android.com/studio/projects/add-native-code.html.
### For more examples on how to use CMake, see https://github.com/android/ndk-samples.
##
### Sets the minimum CMake version required for this project.
##cmake_minimum_required(VERSION 3.22.1)
##
### Declares the project name. The project name can be accessed via ${ PROJECT_NAME},
### Since this is the top level CMakeLists.txt, the project name is also accessible
### with ${CMAKE_PROJECT_NAME} (both CMake variables are in-sync within the top level
### build script scope).
##project("fclient")
##
### Creates and names a library, sets it as either STATIC
### or SHARED, and provides the relative paths to its source code.
### You can define multiple libraries, and CMake builds them for you.
### Gradle automatically packages shared libraries with your APK.
###
### In this top level CMakeLists.txt, ${CMAKE_PROJECT_NAME} is used to define
### the target library name; in the sub-module's CMakeLists.txt, ${PROJECT_NAME}
### is preferred for the same purpose.
### In order to load a library into your app from Java/Kotlin, you must call
### System.loadLibrary() and pass the name of the library defined here;
### for GameActivity/NativeActivity derived applications, the same library name must be
### used in the AndroidManifest.xml file.
##add_library(spdlog STATIC IMPORTED)
##set_target_properties(spdlog PROPERTIES IMPORTED_LOCATION
##        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/build/x86_64/libspdlog.a)
##
##add_library(mbedcrypto SHARED IMPORTED)
##set_target_properties(mbedcrypto PROPERTIES IMPORTED_LOCATION
##        /Users/nikitakalmackiy/AndroidStudioProjects/libs/mbedtls/build/x86_64/library/libmbedcrypto.so)
##
##target_include_directories(spdlog INTERFACE
##        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/spdlog/include
##        /Users/nikitakalmackiy/AndroidStudioProjects/libs/mbedtls/mbedtls/include
##)
##
##add_library(${CMAKE_PROJECT_NAME} SHARED
##        native-lib.cpp)
### Specifies libraries CMake should link to your target library. You
### can link libraries from various origins, such as libraries defined in this
### build script, prebuilt third-party libraries, or Android system libraries.
##target_link_libraries(${CMAKE_PROJECT_NAME}
##        native-lib
##        spdlog
##        android
##        mbedcrypto
##        log)
#
## For more information about using CMake with Android Studio, read the
## documentation: https://d.android.com/studio/projects/add-native-code.html
#
## Sets the minimum version of CMake required to build the native library.
#
#cmake_minimum_required(VERSION 3.22.1)
#
## Declares and names the project.
#
#project("fclient")
#
## Creates and names a library, sets it as either STATIC
## or SHARED, and provides the relative paths to its source code.
## You can define multiple libraries, and CMake builds them for you.
## Gradle automatically packages shared libraries with your APK.
#
#add_library( # Sets the name of the library.
#        native-lib
#
#        # Sets the library as a shared library.
#        SHARED
#
#        # Provides a relative path to your source file(s).
#        native-lib.cpp )
#
#add_library(spdlog STATIC IMPORTED)
#set_target_properties(
#        spdlog PROPERTIES IMPORTED_LOCATION
#        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/build/x86_64/libspdlog.a
#)
#
#add_library(mbedcrypto SHARED IMPORTED)
#set_target_properties(
#        mbedcrypto PROPERTIES IMPORTED_LOCATION
#        /Users/nikitakalmackiy/AndroidStudioProjects/libs/mbedtls/build/x86_64/library/libmbedcrypto.so
#)
#
## Searches for a specified prebuilt library and stores the path as a
## variable. Because CMake includes system libraries in the search path by
## default, you only need to specify the name of the public NDK library
## you want to add. CMake verifies that the library exists before
## completing its build.
#
#find_library( # Sets the name of the path variable.
#        log-lib
#
#        # Specifies the name of the NDK library that
#        # you want CMake to locate.
#        log )
#
#target_include_directories(
#        native-lib PUBLIC
#        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/spdlog/include
#        /Users/nikitakalmackiy/AndroidStudioProjects/libs/mbedtls/mbedtls/include
#)
#
## Specifies libraries CMake should link to your target library. You
## can link multiple libraries, such as libraries you define in this
## build script, prebuilt third-party libraries, or system libraries.
#
##target_link_libraries( # Specifies the target library.
##native-lib
#
## Links the target library to the log library
## included in the NDK.
##${log-lib} )
#
#target_link_libraries(
#        native-lib
#        spdlog
#        mbedcrypto
#        ${log-lib}
#)

# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html.
# For more examples on how to use CMake, see https://github.com/android/ndk-samples.

# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.22.1)

# Declares the project name. The project name can be accessed via ${ PROJECT_NAME},
# Since this is the top level CMakeLists.txt, the project name is also accessible
# with ${CMAKE_PROJECT_NAME} (both CMake variables are in-sync within the top level
# build script scope).
project("fclient")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
#
# In this top level CMakeLists.txt, ${CMAKE_PROJECT_NAME} is used to define
# the target library name; in the sub-module's CMakeLists.txt, ${PROJECT_NAME}
# is preferred for the same purpose.
#
# In order to load a library into your app from Java/Kotlin, you must call
# System.loadLibrary() and pass the name of the library defined here;
# for GameActivity/NativeActivity derived applications, the same library name must be
# used in the AndroidManifest.xml file.
add_library(
        fclient

        SHARED
        # List C/C++ source files with relative paths to this CMakeLists.txt.
        native-lib.cpp)

# Specifies libraries CMake should link to your target library. You
# can link libraries from various origins, such as libraries defined in this
# build script, prebuilt third-party libraries, or Android system libraries.
target_link_libraries(${CMAKE_PROJECT_NAME}
        spdlog
        mbedcrypto
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib} )

target_link_libraries(${CMAKE_PROJECT_NAME}
        # List libraries link to the target library
        android
        log)


add_library(spdlog STATIC IMPORTED)
set_target_properties(spdlog PROPERTIES IMPORTED_LOCATION
        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/build/x86_64/libspdlog.a)
target_include_directories(fclient PUBLIC
        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/spdlog/include)

add_library(mbedcrypto SHARED IMPORTED)
set_target_properties(mbedcrypto PROPERTIES IMPORTED_LOCATION
        ${CMAKE_CURRENT_SOURCE_DIR}/../nativeLibs/${ANDROID_ABI}/libmbedcrypto.so)

target_include_directories(fclient PUBLIC
        /Users/nikitakalmackiy/AndroidStudioProjects/libs/spdlog/spdlog/include
        /Users/nikitakalmackiy/AndroidStudioProjects/libs/mbedtls/mbedtls/include
        )
