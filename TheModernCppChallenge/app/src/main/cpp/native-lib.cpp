#include <jni.h>
#include <string>

[[nodiscard]] constexpr auto sumOf3and5MultipleUpTo(const unsigned int limit)
{
    size_t sum = 0;
    for(auto number = limit; number >= 3; --number)
    {
        if(number % 3 == 0 || number % 5 == 0)
        {
            sum += number;
        }
    }
    return sum;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_themoderncppchallenge_MainActivity_Sum3And5Multiples(
        JNIEnv* env,
        jobject /* this */, const jint i) {
    auto sum = sumOf3and5MultipleUpTo(i);
    return env->NewStringUTF(std::to_string(sum).c_str());
}
