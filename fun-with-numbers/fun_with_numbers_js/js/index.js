import * as readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";

const rl = readline.createInterface({ input, output });

const numberError = (message) => {
  console.log("*");
  console.log("* Oh no... You didn't listen did you?");
  console.log("*");
  console.log(message);
  console.log("*");
  console.log("* Listen to me!");
  console.log("*");
  console.log("* Now Lets try this again. A NUMBER between 2 not a billion.");
};

const getNumber = async () => {
  let isValid = false;
  console.log("*");
  console.log("*******************");
  console.log("* Okay Folks! Lets do this!");
  console.log("*");
  console.log("* Give me a number between 2 and not a billion.");
  console.log("*");
  while (!isValid) {
    let number = await rl.question("Enter the number here: ");

    if (!isNaN(number) && number.toString().indexOf(".") != -1) {
        console.log("*")
      numberError("* Oh Ha Ha Ha... You know I meant a whole number!");
    }else if(!isNaN(number)){
        console.log("*")
        numberErrorz("* I said a NUMBER! Not a letter or a symbol!")
    }

  }

};

getNumber()
