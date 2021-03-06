package com.scalatutorial

//Apart from inheriting code from a super-class, a Scala class can also import code
//from one or several traits.

// We might think in traits(from Java programmer point of view) as interfaces which can also contain code
// To study usefullness of the traits we will implement an example: ordered objects. 
// In Java, we would implement the Comparable interface.
// In Scala, we can do a bit better than in Java by defining our equivalent of Comparable as a trait, which we will call Ord.

//six different predicates can be useful: 
//smaller, smaller or equal, equal, not equal, greater or equal, and greater. 
// four out of these six can be expressed using the remaining two. 

object _7_Traits {
	//Ord trait declaration
  
//	This definition both creates a new type called Ord, which plays the same role as Javas Comparable interface
//	The predicates for equality and inequality do not appear here since they are by default present in all objects.
	trait Ord {
		def < (that: Any): Boolean
		def <=(that: Any): Boolean = (this < that) || (this == that)
		def > (that: Any): Boolean = !(this <= that)
		def >=(that: Any): Boolean = !(this < that)
	}
//	The type Any which is used above is the type which is a super-type of all other types in Scala. 
//	It can be seen as a more general version of Javas Object type, since it is  Traits 13 also a 
//	super-type of basic types like Int, Float, etc.
	
//	To make objects of a class comparable, it is therefore sufficient to define the predicates
//	which test equality and inferiority, and mix in the Ord class above.
	
	//Example Gregorian Date
	
	//Extending ord trait defined above. Inherits there
	class Date(y: Int, m: Int, d: Int) extends Ord {
		def year = y
		def month = m
		def day = d
		override def toString(): String = year + "-" + month + "-" + day
		
//		The default implementation of equals is not usable, because as in Java it compares objects physically.
//		Redefinition
		
		override def equals(that: Any): Boolean =
			//isInstanceOf, corresponds to Javas instanceof operator, and returns
//			true if and only if the object on which it is applied is an instance of the given type.
		  	that.isInstanceOf[Date] && { 
//				corresponds to Javas cast operator: if the object is
//				an instance of the given type, it is viewed as such, otherwise a ClassCastException is thrown.	
				val o = that.asInstanceOf[Date]
				o.day == day && o.month == month && o.year == year
			}
		
//		Finally, the last method to define is the predicate which tests for inferiority, as follows.
		def <(that: Any): Boolean = {
			if (!that.isInstanceOf[Date])
				error("cannot compare " + that + " and a Date") //throws an exception with the given message
			val o = that.asInstanceOf[Date]
			
			val x = year < o.year 
			(month == o.month && day < o.day)
			(month < o.month ||(month == o.month && day < o.day))
			val y = (year == o.year && (month < o.month ||(month == o.month && day < o.day)))
			x||y
//			year < o.year || (year == o.year && (month < o.month ||(month == o.month && day < o.day))) 
		}
	}
}