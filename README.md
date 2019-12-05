# Mas script

Script which transform data from [Stopwatch-portable](https://free-stopwatch-portable.soft112.com/) format to Input Analyzer format. Input Analyzer format include only time between arrivals.
Input Analyzer format example: 00:00:01.47
Stopwatch format include Lap No. (serial number) "\t" time between arrivals "\t" total time from measurement start.
Stopwatch format example: Lap 1 00:00:02.55 00:00:02.55

## Usage

```bash
java -jar script.jar inputFile.txt outputFile.txt
```

Where inputFile.txt is data in Stopwatch format,
and outputFile.txt is data in Input Analyzer format.
