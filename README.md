# Cynnovative Coding Exercise

Fork this repository, answer the questions in whichever form you want (e.g. `.txt`, add new `README.md` files, etc.), build your Dockerized programs in the language of your choice, then submit a pull request with your code.

## Question 1 - How big is this file?

The following screenshot is of a file opened in a text editor, with MIME  type `text/plain`, and is seemingly small. What is the file's size in `bytes`? 

I believe the answer is 5 bytes. 1 bytes for each character '0', '.', and '1' and 1 byte each for the carriage return '/r' and the new line '/n' characters. I also double checked this by creating a text file and making its contents match the image and verified that according the OS the file size was 5 bytes.

![alt text](how-big-is-this-file.png)

## Question 2 - Python and Switch Statements

The programming language Python does not have a `switch` construct. What is a way of recreating a `switch` statement in Python? Write an example that will use the following list of values as cases and actions:

```
Value: 'red', Action: paintItRed()
Value: 'green', Action: paintItGreen()
Value: 'blue', Action: paintItBlue()
Value: 'default', Action: paintIt()
```

The python file that implements the switching logic can be found in python-switch directory. I made use of functions and a switcher in order to achieve the switching logic.

## Question 3 - StackOverflow and Java

The most copied Java code snippet in StackOverflow has a bug in it:

```
private static String[] prefix = new String[] {"","K","M","G","T","P","E"};

public static String humanByteCount(long bytes, boolean si) {
    if (bytes == 0) return "0 B";
    int unit = si ? 1000 : 1024;
    double power = Math.min(Math.floor(Math.log(bytes)/Math.log(unit)), 6);
    String pref = prefix[(int) power] + (si && power > 0 ? "iB" : "B");
    String format = power == 0 ? "%.0f %s" : "%.1f %s";
    return String.format(format, bytes / Math.pow(unit, power), pref);
}
```

Can you find the bug?

I put code in java-bug/JavaBug.java that has the bug fix, but I believe the bug is in the assignment of unit. When si is true, unit should 1024 instead of 1000.

## Question 4 - Binary File Analysis

Binary file analysis takes various forms. Write a Dockerized program, in the language of your choice, that finds all the printable `strings` in an input binary file and prints them out to `stdout`.

Example of desired functionality:

```
$ docker build -t $YOUR_DOCKER_IMAGE Dockerfile
$ docker run -it $YOUR_DOCKER_IMAGE find_strings /bin/ls
$ Corresponding Output:
  $FreeBSD: src/bin/ls/cmp.c,v 1.12 2002/06/30 05:13:54 obrien Exp $
  @(#) Copyright (c) 1989, 1993, 1994
  The Regents of the University of California.  All rights reserved.
  $FreeBSD: src/bin/ls/ls.c,v 1.66 2002/09/21 01:28:36 wollman Exp $
  $FreeBSD: src/bin/ls/print.c,v 1.57 2002/08/29 14:29:09 keramida Exp $
  $FreeBSD: src/bin/ls/util.c,v 1.38 2005/06/03 11:05:58 dd Exp $
  \\""
  @(#)PROGRAM:ls  PROJECT:file_cmds-287.40.2
  fffff
  COLUMNS
  1@ABCFGHLOPRSTUWabcdefghiklmnopqrstuvwx%
  bin/ls
  Unix2003
  CLICOLOR
  ...
```

For this problem, I used the linux function strings which is defined in binutils. The Dockerfile can be found in binary-strings and I built my image using the following command:

```
docker build -t binary-strings-image -f Dockerfile .
```

when executed from within the App directory. To run the container, I used the following command

```
docker run -it binary-strings-image strings /bin/ls
```

which should output all printable strings.

## Question 5 - Circular Prime Numbers

A very interesting mathematical concept is that of circular prime numbers. A circular prime number is a prime number `p` that, when rearraging its digits, all the possible combinations are also prime.

For example, the number `13` is a circular prime because `13` and `31` are primes.

Create a Dockerized program, in the language of your choice, that finds all the circular prime numbers below `500000`.

Example of desired functionality:

```
$ docker build -t $YOUR_DOCKER_IMAGE Dockerfile
$ docker run -it $YOUR_DOCKER_IMAGE circular_primes
$ Corresponding Output:
  2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, ...
```

The application written in C# using .NET Core 3.1 can be found in the circular-primes directory. The Dockerfile is in circular-primes/App and should be able to be built using:

```
docker build -t circular-prime-image -f Dockerfile .
```

when executed from within the App directory. To run the container, I used the following command

```
docker run -it circular-prime-image
```

which should output all of the circular primes between 1 and 50000.