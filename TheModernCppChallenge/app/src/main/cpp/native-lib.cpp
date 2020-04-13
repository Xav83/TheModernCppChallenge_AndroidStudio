#include "Problem_1.hpp"
#include "Problem_2.hpp"
#include "Problem_3.hpp"
#include "Problem_4.hpp"

#include <jni.h>
#include <string>
#include <vector>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_MainActivity_Sum3And5Multiples(
        JNIEnv* env,
        jobject /* this */, jint i) {
    auto sum = sumOf3and5MultipleUpTo(i);
    return env->NewStringUTF(std::to_string(sum).c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_Problem_12_Gcd(JNIEnv *env, jobject thiz, jint i, jint j) {
    auto result = std::gcd(i, j);
    return env->NewStringUTF(std::to_string(result).c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_Problem_13_Lcm(JNIEnv *env, jobject /* this */,
                                                      jintArray arr) {
    jsize size = env->GetArrayLength( arr );
    std::vector<jint> input( size );
    env->GetIntArrayRegion( arr, jsize{0}, size, &input[0] );

    auto result = my_lcm(std::begin(input), std::end(input));
    return env->NewStringUTF(std::to_string(result).c_str());
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_Problem_14_LargestPrimeSmallerThan(JNIEnv *env, jobject thiz,
                                                                          jint user_input) {
    auto result = largestPrimeSmallerThan(user_input);
    return env->NewStringUTF(std::to_string(result).c_str());
}
