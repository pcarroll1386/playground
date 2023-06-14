import math

def process_numbers(n, i, primes):
    running = True
    while running:
        if n % i == 0:
            primes.append(i)
            n = n/i
        else:
            running = False
    return {
        "primes": primes,
        "number": n
    }

def process_odds(n, primes):
    x = int(round(math.sqrt(n), 0))
    for i in range(3,x,2):
        result = process_numbers(n, i, primes)
        n = int(result["number"])
    if n > 2:
        result["primes"].append(n)
    return result


def start(number):
    result = process_numbers(number, 2, [])
    result = process_odds(result["number"], result["primes"])
    print(result["primes"])
    print(set(result["primes"]))



if __name__ == "__main__":
    start(123456543457)