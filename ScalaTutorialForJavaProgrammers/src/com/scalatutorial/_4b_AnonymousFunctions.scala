package com.scalatutorial

//the function timeFlies is only defined in order to be passed later to the
//oncePerSecond function. 
//Naming the function to be only used once, might seem unnecessary, 
//Construct the function as it is passed :functions without a name. 
//The revised version uses anonymous function instead of timeFlies 

object _4b_AnonymousFunctions {
	def oncePerSecond(callback: () => Unit) {
		while (true) { callback(); Thread sleep 1000 }
	}
	def main(args: Array[String]) {
	  // The right arrow '=>' separates the argument list from its body.
		oncePerSecond(() => //the argument list is empty
		//body of the function
		  println("time flies like an arrow..."))
	}  
}