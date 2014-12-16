package com.scalatutorial

//object declaration is a "singleton" declaration
// It created the the _1_HelloWorld class and one instance of that class.
// The instance is created the first time it is used.
object _1_HelloWorld {
	//Main method, it doesn't return any value.
	// def: return, it is not necessary to define return object type in Scala
	// args: name of argument
	// Array[String] type of the argument defined just before the preceeding :

	// Note: it is not static as static methods and objects do not exist in Scala.
	// Instead we use singletons
	def main(args: Array[String]){ 
	  //Main function body
		println("Hello, world.")
	}
}