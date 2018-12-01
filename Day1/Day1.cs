using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdventOfCode
{
    class Program
    {
        private static string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Robert\Downloads\input(1).txt");
        private static HashSet<int> reachedFrequenciesSet = new HashSet<int>();
        private static int part2Frequency = 0;
        private static int timesReRead = 0;

        static void Main(string[] args)
        {
            Console.Write("****PART 1*****\r\n");
            part1();
            Console.Write("****PART 2*****\r\n");
            part2();
        }

        private static void part1()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Robert\Downloads\input.txt");
            int frequency = 0;
            foreach (string s in lines)
            {
                int value = Int32.Parse(s);
                frequency += value;
            }
            Console.Write("frequency = " + frequency+"\r\n");
            watch.Stop();
            Console.Write("TIME TO FINISH = " + watch.ElapsedMilliseconds+"ms \r\n");
        }

        private static void part2()
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            reachedFrequenciesSet.Add(0);
            read(lines, reachedFrequenciesSet, part2Frequency);
            while (!read(lines, reachedFrequenciesSet, reachedFrequenciesSet.ElementAt(reachedFrequenciesSet.Count-1)))
            {
                timesReRead++;
            }
            watch.Stop();
            Console.Write("TIME TO FINISH = " + watch.ElapsedMilliseconds + "ms \r\n" );
            Console.Write("Required passes: "+ timesReRead + "\r\n");
        }
        private static bool read(string[] lines, HashSet<int> reachedFrequencies,int frequency)
        {    
            bool isFound = false;
            foreach (string s in lines)
            {
                int value = Int32.Parse(s);
                frequency += value;
                if (reachedFrequenciesSet.Contains(frequency))
                {
                    Console.Write("THE FIRST DOUBLE IS: " + frequency + "\r\n");
                    isFound = true;
                    break;
                }
                else
                {
                    reachedFrequenciesSet.Add(frequency);
                }
            }
            return isFound;

        }

    }
}
