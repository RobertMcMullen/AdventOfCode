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
        private static string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Robert\Downloads\input.txt");
        private static List<int> reachedFrequencies = new List<int>();
        private static int part2Frequency = 0;

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
            reachedFrequencies.Add(0);
            read(lines, reachedFrequencies, part2Frequency);
            while (!read(lines, reachedFrequencies, reachedFrequencies[reachedFrequencies.Count - 1]))
            {

            }
            watch.Stop();
            Console.Write("TIME TO FINISH = " + watch.ElapsedMilliseconds + "ms \r\n");
        }
        private static bool read(string[] lines, List<int> reachedFrequencies,int frequency)
        {    
            bool isFound = false;
            foreach (string s in lines)
            {
                int value = Int32.Parse(s);
                frequency += value;
                if (reachedFrequencies.Contains(frequency))
                {
                    Console.Write("THE FIRST DOUBLE IS: " + frequency + "\r\n");
                    isFound = true;
                    break;
                }
                else
                {
                    reachedFrequencies.Add(frequency);
                }
            }
            return isFound;

        }

    }
}
