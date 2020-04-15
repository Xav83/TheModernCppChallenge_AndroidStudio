#ifndef THEMODERNCPPCHALLENGE_PRIMENUMBER_HPP
#define THEMODERNCPPCHALLENGE_PRIMENUMBER_HPP

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

#endif //THEMODERNCPPCHALLENGE_PRIMENUMBER_HPP
