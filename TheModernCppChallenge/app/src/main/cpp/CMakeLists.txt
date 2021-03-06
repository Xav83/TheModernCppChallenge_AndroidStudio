# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

add_library(primeNumber STATIC primeNumber.hpp)
set_property(TARGET primeNumber PROPERTY LINKER_LANGUAGE CXX)

add_library(problem1 STATIC Problem_1.hpp)
set_property(TARGET problem1 PROPERTY LINKER_LANGUAGE CXX)

add_library(problem2 STATIC Problem_2.hpp)
set_property(TARGET problem2 PROPERTY LINKER_LANGUAGE CXX)

add_library(problem3 STATIC Problem_3.hpp)
set_property(TARGET problem3 PROPERTY LINKER_LANGUAGE CXX)

add_library(problem4 STATIC Problem_4.hpp)
set_property(TARGET problem4 PROPERTY LINKER_LANGUAGE CXX)
target_link_libraries(problem4 PRIVATE primeNumber)

add_library(problem5 STATIC Problem_5.hpp)
set_property(TARGET problem5 PROPERTY LINKER_LANGUAGE CXX)
target_link_libraries(problem5 PRIVATE primeNumber)

add_library(problem6 STATIC Problem_6.hpp)
set_property(TARGET problem6 PROPERTY LINKER_LANGUAGE CXX)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             native-lib.cpp )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} problem1 problem2 problem3 problem4 problem5 problem6)