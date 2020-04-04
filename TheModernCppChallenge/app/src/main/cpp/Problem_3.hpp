#ifndef THEMODERNCPPCHALLENGE_PROBLEM_3_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_3_HPP

#include <numeric>
#include <iterator>

template <class InputIterator>
constexpr auto my_lcm (InputIterator first, InputIterator last)
{
    return std::accumulate(first, last, 1, [](const auto& first, const auto& second){
        return std::lcm(first, second);
    });
}

#endif //THEMODERNCPPCHALLENGE_PROBLEM_3_HPP
