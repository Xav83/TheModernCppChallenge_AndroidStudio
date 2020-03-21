#include "Problem_1.hpp"

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_MainActivity_Sum3And5Multiples(
        JNIEnv* env,
        jobject /* this */, const jint i) {
    auto sum = sumOf3and5MultipleUpTo(i);
    return env->NewStringUTF(std::to_string(sum).c_str());
}
