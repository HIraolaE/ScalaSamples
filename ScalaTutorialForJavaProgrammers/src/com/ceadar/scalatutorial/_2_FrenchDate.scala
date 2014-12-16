package com.ceadar.scalatutorial

//Importing java libraries

//Scalas import statement looks very similar to Javas equivalent
//, however, it is more powerful. Multiple classes can be imported from the 
//same package by enclosing them in curly braces as on the first line. 
import java.util.{Date, Locale} 

//Another difference is that when importing all the names of a package or class, 
//one uses the underscore character (_) instead of the asterisk (*). 
//Thats because the asterisk is a valid Scala identifier (e.g. method name), 
//as we will see later.
//The import statement on the third line therefore imports all members of the 
//DateFormat class. This makes the static method getDateInstance and the static 
//field LONG di- rectly visible.
import java.text.DateFormat 
import java.text.DateFormat._

//create a singleton object
object _2_FrenchDate {

  //Creating a main class
  def main(args: Array[String]) {
    //Using a java class. Use new and constructor
    // Store return using val
    val now = new Date 
    //Defining date format
    val df = getDateInstance(LONG, Locale.FRANCE)
    //Scala way
    println(df format now)
    // Java way. Equivalent
    //println(df.format(now))
    
  }
  //To conclude this section about integration with Java, 
  // it should be noted that it is also possible to inherit from Java classes 
  //and implement Java interfaces directly in Scala.
}