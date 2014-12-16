package com.scalatutorial

//Classes in Scala are declared using a syntax which is close to Java syntax.
object _5_Classes {
//  This complex class takes two arguments, which are the real and imaginary part of the complex. 
	class Complex(real: Double, imaginary: Double) {
//		The class contains two methods
//		called re and im, which give access to these two parts.
//		return type of these two methods is not given explicitly.
//		Inferred automatically by the compiler that deduces that both return a value of type Double.
//	  	The compiler is not always able to infer types: there is no simple rule to understand when. Trying different cases is the best
		def re() = real
		def im() = imaginary
	}
	// link to parameters explanation:
	// http://stackoverflow.com/questions/15639078/scala-class-constructor-parameters
	class Complex2(real: Double, imaginary: Double) {
		//If the values real and imaginary not accessible directly, they only are visible through methods
//		def re() = real
//		def im() = imaginary
		override def toString = real +" +i "+ imaginary
	}
	
	def main (args: Array[String]){
		//These arguments must be passed when creating an instance of class Complex, as follows: 
		var c = new Complex(1.5, 2.3)
		println(c toString)
		println(c.re() +"+i"+ c.im())
		
		var c2 = new Complex2(1.5, 2.3)
		println(c2 toString)
		//These two lines  would not compile
//		println(c2.re() +"+i"+ c2.im())
//		println(c2.real +"+i"+ c2.imaginary)
		
	}
}