PrimeNumberGenerator
====================
Generate the prime numbers based on the range given by user. There are three different strategies used to generate the prime numbers in this application.<br/>
1) Basic Algorithm - It use the simple linear search algorithm to find the prime number. Prime number is a number which is divisible by one and itselt.
There fore it has only two divisor.Algorithm search for the numbers which has two divisor sequencially from startRange to endRange.<br/>
2) Sieve of Eratosthenes Algorithm - In mathematics, the sieve of Eratosthenes is a simple, ancient algorithm for finding all prime numbers up to any given limit.<a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">
Sieve of Eratosthenes</a><br/>
3) Segmented Sieve Algorithm - The problem with the sieve of Eratosthenes is not the number of operations it performs but rather its memory requirements.For large n, the range of primes may not fit in memory; worse, even for moderate n, its cache use is highly suboptimal. The algorithm walks through the entire array A, exhibiting almost no locality of reference.
A solution to these problems is offered by segmented sieves, where only portions of the range are sieved at a time.
<a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Segmented_sieve">Segmented Sieve</a></br>

Prerequisites
------------

You need to have installed a jdk 1.8 or higher and gradle distribution 3.5 or higher.<br/>
Application Server for deploying war file e.g. Apache Tomcat, Glassfish, etc.

Description
------------
The application contains two projects <br/>
* PrimeNumberGenerator - Standalone Application
* PrimeGeneratorService - Restful Web Service 

Execution of PrimeGeneratorService
----------------------------------

This application needs to be deployed on application server. To generate war of this application use following command in the project directory.
The PrimeGeneratorService.war will be generated inside build/libs/
```bash
# Linux
gradle clean build

# windows:
gradlew clean build
```

If Apache tomcat is used then copy this war and paste it under apache-tomcat-directory/webapps folder and restart server.
Or if any other server is used then deploy the war file accordingly.

The application can be accessed using two methods :

* Web User Interface : URL to access your the application : http://hostname:port/PrimeGeneratorService/ <br>
e.g. http://localhost:8080/PrimeGeneratorService/


![Screenshot](screenshot.png)




Iterating over primes
---------------------

Instead of generating a large list of primes and then do something
with the primes it is also possible to simply iterate over the primes
which uses less memory.

```Python
>>> import primesieve

it = primesieve.Iterator()
prime = it.next_prime()

# Iterate over the primes below 10000
while prime < 10000:
    print prime
    prime = it.next_prime()

# Set iterator start number to 100
it.skipto(100)
prime = it.prev_prime()

# Iterate backwards over the primes below 100
while prime > 0:
    print prime
    prime = it.prev_prime()
```

NumPy support
-------------
Using the ```primesieve.numpy``` module you can generate an array of
primes using **native C++ performance!**

In comparison the ```primesieve``` module generates a list of primes
about 7 times slower mostly because the conversion of the C++ primes
array into a python list is very slow.

```Python
>>> from primesieve.numpy import *

# Generate a numpy array with the primes below 100
>>>  primes(100)
array([ 2,  3,  5,  7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
       61, 67, 71, 73, 79, 83, 89, 97])

# Generate a numpy array with the first 100 primes
>>>  n_primes(100)
array([  2,   3,   5,   7,  11,  13,  17,  19,  23,  29,  31,  37,  41,
        43,  47,  53,  59,  61,  67,  71,  73,  79,  83,  89,  97, 101,
       103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167,
       173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
       241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
       317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
       401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467,
       479, 487, 491, 499, 503, 509, 521, 523, 541])
```

Development
-----------

You need to have installed a C++ compiler, see [Prerequisites](#prerequisites).

```bash
# Install prerequisites
pip install cython pytest numpy

# Clone repository
git clone --recursive https://github.com/hickford/primesieve-python

cd primesieve-python

# Build and install primesieve-python
pip install . --upgrade

# Run tests
py.test
```
