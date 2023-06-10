def number_error(message: str):
    print("*")
    print("*******************")
    print("*")
    print("* Oh you didn't listen did you?")
    print(f"* {message}")
    print("* Listen to me!")
    print("* Now lets try again. A NUMBER between 1 and not a billion")


def get_number() -> int:
    print("*******************")
    print("*")
    print("* Okay Boy-Os!!")
    print("* Give me a number between 1 and not a billion.")
    valid = False
    while not valid:
        try:
            number = int(input("Enter the number here:"))
            if number <= 999999999 and number > 1:
                print("*")
                print("* Okay here we go!")
                print("*")
                print("*******************")
                return number
            elif number == 1000000000:
                number_error("I said a number that is NOT a Billion!")
            elif number > 1000000000:
                number_error("Oh way to go. You found a loop hole in my launguage. CLAP CLAP. Now give me a number less than a Billion!")
            elif number < 1:
                number_error("I said a number Greater than 0!")
        except ValueError as e:
            try:
                was_typed = e.args[0].split(":")[1]
                was_typed = was_typed.replace("'", "").strip()
                is_Float = float(was_typed)
                number_error("Oh haha! I meant whole number and you know it!")
            except ValueError:
                number_error("I said a NUMBER! not a lettor or symbol!")


def proccess_number(number: int) -> list[int]:
    factors = []
    for x in range(number+1):
        if x != 0:
            result = number % x
            if result == 0:
                factors.append(x)
    return factors


def check_if_prime(factors: list[int]) -> bool:
    if len(factors) >= 3:
        return False
    else:
        return True
    

def report_findings(number: int, factors: list[int], is_prime: bool):
    print("*")
    print("* Okay! so I have crunched the numbers.... no need to check!")
    print("*")
    print(f"* you entered {number}")
    print("*")
    if number < 10:
        print("* wow... you really streached for that one didn't you?")
        print("*")
    elif number > 999999:
        print("* Eh Gods! I know I said less than a billion but shit!")
        print("*")
    if is_prime:
        print(f"* So fun news first. {number} is a Prime Number!! woot woot!!!")
        print("*")
        print("* And because it is prime I am not going to list off all factors. Figure it out.")
        print("*")
    else:
        print(f"* Well I hate to break this to you, but {number} is not a prime number.")
        print("*")
        print("* I know... there, there, poor thing.")
        print("*")
        print(f"* Now on to the fun news. The following numbers are all facors of {number}!")
        for n in factors:
            print("*")
            print(f"* {n}")
        print("*")
    print("* Well that is it. Go away.")
    print("*******************")


def run_program():
    number = get_number()
    factors = proccess_number(number)
    is_prime = check_if_prime(factors)
    report_findings(number=number, factors=factors, is_prime=is_prime)


if __name__ == "__main__":
    run_program()