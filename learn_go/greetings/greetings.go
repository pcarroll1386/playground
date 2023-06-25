package greetings

import (
	"errors"
	"fmt"
	"math/rand"
)

// Hello returns greeting for the named persaon.
func Hello(name string) (string, error) {
	// If no name given return error with message.
	if name == "" {
		return "", errors.New("empty name")
	}
	//Return a greeting  that embeds the name in the message.
	//In greetings message
	message := fmt.Sprintf(randomFormat(), name)
	return message, nil
}

//  Hello returns a greeting for the named person.
// func Hello(name string) (string, error) {
// 	// If no name was given, return an error with a message.
// 	if name == "" {
// 		return name, errors.New("empty name")
// 	}
// 	// Create a message using a random format.
// 	// message := fmt.Sprintf(randomFormat(), name)
// 	message := fmt.Sprint(randomFormat())
// 	return message, nil
// }

// Hellos returns a map that associates each of the named people
// with a greeting message.
func Hellos(names []string) (map[string]string, error) {
	// A map associates names with messages.
	messages := make(map[string]string)
	// Loop through the recieved slice of names, calling
	// the Hello function to get a message for each name.
	for _, name := range names {
		message, err := Hello(name)
		if err != nil {
			return nil, err
		}
		// In the map, associate the retrieved message with the name.
		messages[name] = message
	}
	return messages, nil
}

// randomFormat returns one of the set greeting messages. The returned
// message is selected at random.
func randomFormat() string {
	// A slice of message formats.
	formats := []string{
		"Hi, %v, Welcome!",
		"Great to see you %v!",
		"Hail, %v, Well met!",
	}

	// Return a randomly selected by specifying
	// a random index for the slice of formats
	return formats[rand.Intn(len(formats))]
}
