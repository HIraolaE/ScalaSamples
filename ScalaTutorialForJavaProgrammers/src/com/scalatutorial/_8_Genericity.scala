package com.scalatutorial

//Genericity is the ability to write code parametrized by types.
//For example, a programmer writing a library for linked lists faces the problem of deciding which type
//to give to the elements of the list. Since this list is meant to be used in many different
//contexts, it is not possible to decide that the type of the elements has to be, say,
//Int. This would be completely arbitrary and overly restrictive.

//In Java we would use Object. This solution is however far from being ideal, since it doesn't work for basic types (int,
//long, float, etc.) and it implies that a lot of dynamic type casts have to be inserted by the programmer.

//Scala makes it possible to define generic classes (and methods) to solve this problem.


object _8_Genericity {
	
	// class with one var and setter and getter methods, valid for any type
	class Reference[T] {
		private var contents: T = _
		def set(value: T) { contents = value }
		def get: T = contents
	}
//	The class Reference is parametrized by a type, called T.
//	The above code sample introduces variables in Scala It is however interesting to see that the initial value given to that
//	variable is _, which represents a default value. This default value is 0 for numeric
//	types, false for the Boolean type, () for the Unit type and null for all object types.
	
	//Using reference types
	def main(args: Array[String]) {
		val cell = new Reference[Int]
		cell.set(13)
		println("Reference contains the half of " + (cell.get * 2))
	}
	
}