# Blackjack Project

This java program utilizes different objects and classes to simulate a game of Blackjack based on the specifications given by the user. This project is the first step in a long term personal project where I would like to build a program that understands Basic Strategy and how to count cards in Blackjack. 

## Features

The following features have been currently implemented:

- User can specify their bankroll, the minimum wager at the table they are playing at, how long they intend on playing, and what seat at the table they would like to take.
- The simulator currently runs each hand at the table using basic blackjack strategy regardless if it is a player hand or not
- The dealer hand runs its hand hitting on soft 17.
- The simulation will stop running when the user no longer has enough money to begin another hand.
- Sometimes due to doubling down the number of hands in the game will increase, so at the end of the round it will delete all hands until there are 4 normal hands and one other hand that belongs to the player

The following features are things I would like to implement in the future:

- add the functionality that would allow the user to decide whether or not they want the simulation to use basic strategy or card counting version of the turn function that takes the player hand as a parameter
- possibly add a gui that would display the hands as they are played as well as display the players current amount of money

## Current Bugs that will be Fixed
- Simulation behaves funny when player is using seat 7 (the last seat at the table) 
- Need to add a condition so that the player doesnt double down when they don't have the money to.

