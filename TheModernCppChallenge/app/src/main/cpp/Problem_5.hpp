#ifndef THEMODERNCPPCHALLENGE_PROBLEM_5_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_5_HPP

#include "primeNumber.hpp"

#include <cmath>
#include <vector>
#include <utility>

static const bool isSexyPrimePair(unsigned int firstNumber, unsigned int secondNumber)
{
    return (std::abs(static_cast<int>(firstNumber - secondNumber)) == 6) && isPrime(firstNumber) && isPrime(secondNumber);
}

std::vector<std::pair<unsigned int, unsigned int>> sexyPrimeSmallerThan (const unsigned int upperLimit)
{
    std::vector<std::pair<unsigned int, unsigned int>>  results;
    for(unsigned int i = upperLimit; i > 6; --i)
    {
        auto firstIndex = i;
        auto secondIndex = static_cast<unsigned int>(i-6);
        if(isSexyPrimePair(i, secondIndex))
        {
            results.emplace_back(std::make_pair<unsigned int, unsigned int>(std::move(firstIndex), std::move(secondIndex)));
        }
    }
    return results;
}


#endif //THEMODERNCPPCHALLENGE_PROBLEM_5_HPP
