#ifndef THEMODERNCPPCHALLENGE_PROBLEM_4_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_4_HPP

#include "primeNumber.hpp"
#include <cassert>

constexpr unsigned int largestPrimeSmallerThan (const unsigned int upperLimit)
{
    for(auto number = upperLimit; number > 1; --number)
    {
        if(isPrime(number))
        {
            return number;
        }
    }
    assert(false);
    return 1;
}

#endif //THEMODERNCPPCHALLENGE_PROBLEM_4_HPP
