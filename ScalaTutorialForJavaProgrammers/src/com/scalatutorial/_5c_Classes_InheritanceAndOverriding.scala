package com.scalatutorial

//All the classes inherit from a super-class. When no super-class is specified, as
//in the Complex example of previous section, scala.AnyRef is implicitly used.

//It is possible to override inherited methods 
//It is mandatory to explicitly specify that  using the override modifier, 

object _5c_Classes_InheritanceAndOverriding {
//  This complex class takes two arguments, which are the real and imaginary part of the complex. 
	class Complex(real: Double, imaginary: Double) {
//		The class contains two methods without arguments
//		called re and im, which give access to these two parts.
//		return type of these two methods is not given explicitly.
		def re = real
		def im = imaginary
		//overriding an inherited method
		override def toString() ="" + re + (if (im < 0) "" else "+") + im + "i"
	}
	def main (args: Array[String]){
		//These arguments must be passed when creating an instance of class Complex, as follows: 
		var c = new Complex(1.5, 2.3)
		println(c toString)
	}
}