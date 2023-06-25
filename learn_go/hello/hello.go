package main

import (
	"fmt"
	"log"

	"example.com/greetings"
)

func main() {
	//Set properties of the predefined Logger, including
	// the log entry prefix and a flag to disable printing
	// the time, source file an line number.
	log.SetPrefix("greetings: ")
	log.SetFlags(0)

	// Request greeting message.
	// message, err := greetings.Hello("Paul")

	// A slice of names
	names := []string{"Gladis", "Samantha", "Darrin", "Paul", "Hilary"}

	//Request greeting  messages for the names.
	messages, err := greetings.Hellos(names)

	// If an error message was returned, print it to the console and
	// exit the program.
	if err != nil {
		log.Fatal(err)
	}

	// If no error was returned, print the returned message
	fmt.Println(messages)
}
