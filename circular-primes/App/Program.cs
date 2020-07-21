using System;

namespace NetCore.Docker
{

    class Program
    {
        static void Main(string[] args)
        {
            // can loop up to 50000 since 50000 is not prime
            for (var i = 2; i < 50000; ++i)
            {
                if (CheckCircular(i))
                {
                    Console.Write($"{i}, ");
                }
            }
        }

        // code inspired by https://www.javatpoint.com/prime-number-program-in-csharp
        static bool IsPrime(int number)
        {
            var m = number / 2;

            for (var i = 2; i <= m; ++i)
            {
                if (number % i == 0)
                {
                    return false;
                }
            }

            return true;
        }

        // code inspired by https://www.geeksforgeeks.org/check-whether-number-circular-prime-not/
        static bool CheckCircular(int number)
        {
            var count = number.ToString().Length;
            var perm = number;

            while (IsPrime(perm))
            {
                var remainder = perm % 10;
                var div = perm / 10;
                perm = (int)(Math.Pow(10, count - 1) * remainder) + div;

                if (perm == number)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
