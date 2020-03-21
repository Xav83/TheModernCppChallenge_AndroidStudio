#ifndef THEMODERNCPPCHALLENGE_PROBLEM_1_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_1_HPP

#include <cstddef>

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

#endif //THEMODERNCPPCHALLENGE_PROBLEM_1_HPP
