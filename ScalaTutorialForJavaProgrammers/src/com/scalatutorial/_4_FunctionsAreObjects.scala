package com.scalatutorial

//Functions are also objects in Scala.
//It is  possible to pass them as arguments, to store them in variables,
//and to return them from other functions. 
//functional programming paradigm 

//simple example: timer function - perform every X.

object _4_FunctionsAreObjects {
  //The type of this function is written () => Unit
  //take no arguments and return nothing (the type Unit is similar to void in C/C++). 
	def oncePerSecond(callback: () => Unit) {
		while (true) { callback(); Thread sleep 1000 }
	}
	// callback function which prints a sentence on the terminal.
	def timeFlies() {
		println("time flies like an arrow...")
	}
	def main(args: Array[String]) {
	  //Pass the action as a function.
	  //The main function calls this timer function with a call-back function
		oncePerSecond(timeFlies)
	}
}