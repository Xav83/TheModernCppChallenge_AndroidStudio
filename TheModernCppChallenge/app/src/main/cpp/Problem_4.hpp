#ifndef THEMODERNCPPCHALLENGE_PROBLEM_4_HPP
#define THEMODERNCPPCHALLENGE_PROBLEM_4_HPP

static constexpr bool isPrime(unsigned int number)
{
    if(number < 2) { return false; }

    for(auto divisor = (number / 2); divisor > 1; --divisor)
    {
        if(number % divisor == 0)
        {
            return false;
        }
    }
    return true;
}

unsigned int largestPrimeSmallerThan (const unsigned int upperLimit)
{
    for(auto number = upperLimit; number > 1; --number)
    {
        if(isPrime(number))
        {
            return number;
        }
    }
//    assert(false);
    return 1;
}

#endif //THEMODERNCPPCHALLENGE_PROBLEM_4_HPP
