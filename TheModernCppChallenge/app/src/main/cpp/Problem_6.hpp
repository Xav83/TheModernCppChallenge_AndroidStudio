#ifndef THEMODERNCPPCHALLENGE_PROBLEM_6_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_6_HPP

#include <optional>
#include <vector>
#include <utility>

static constexpr unsigned int getSumOfDivisors(unsigned int number)
{
    unsigned int sumOfDivisors{0};
    for(auto i = 1; i < number; ++i)
    {
        if(number % i == 0)
        {
            sumOfDivisors += i;
        }
    }
    return sumOfDivisors;
}

std::optional<unsigned int> getAbundance(unsigned int number)
{
    const auto sum = getSumOfDivisors(number);
    if(number < sum)
    {
        return {static_cast<unsigned int>(sum - number)};
    }
    return std::nullopt;
}

std::vector<std::pair<unsigned int, unsigned int>> getAllAbundantNumbersUpTo(unsigned int upperLimit)
{
    std::vector<std::pair<unsigned int, unsigned int>> results;
    for(auto i = 1; i <= upperLimit; ++i)
    {
        auto potentialAbundantNumber = i;
        auto abundance = getAbundance(i);
        if(abundance.has_value())
        {
            results.emplace_back(std::make_pair<unsigned int, unsigned int>(std::move(potentialAbundantNumber), std::move(*abundance)));
        }
    }
        return results;
}

#endif //THEMODERNCPPCHALLENGE_PROBLEM_6_HPP
