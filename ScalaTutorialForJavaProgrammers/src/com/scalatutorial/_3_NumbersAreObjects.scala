package com.scalatutorial

object _3_NumbersAreObjects {
	def main (args: Array[String]){
	  var x = 4
	//Since numbers are objects, they also have methods. 
	//And in fact, an arithmetic ex- pression like the following:
	var y = 1+2*3/x
	//consists exclusively of method calls, because it is equivalent to the following 
	//expression, as we saw in the previous section:

	var t = (1).+(((2).*(3))./(x))
	//This also means that +, *, etc. are valid identifiers in Scala.
	//The parentheses around the numbers in the second version are necessary because 
	// Scalas lexer uses a longest match rule for tokens. Therefore, it would break the 
	// following expression: 1.+(2)
	var t2 = (1.)+(((2).*(3))./(x))
	// into the tokens 1., +, and 2. The reason that this tokenization is chosen is 
	// because 1. is a longer valid match than 1. The token 1. is interpreted as the 
	// literal 1.0, making it a Double rather than an Int. Writing the expression as:
	// (1).+(2)
	// prevents 1 from being interpreted as a Double.
	
	println(y)
	println(t)
	println(t2)
	println(y == t)
	}
	
}