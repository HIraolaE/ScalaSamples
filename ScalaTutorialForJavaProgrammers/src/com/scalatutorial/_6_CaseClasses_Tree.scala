package com.scalatutorial

// Tree Structure
//XML documents
//containers are based on trees

//Tree manipulation: Small calculator example
//Goal: manipulate simple arithmetic expressions composed of sums, integer constants and variables.
// Example :  1+2 
// Example2: (x + x)+(7+ y).

//Representation: Nodes - operations and leaves - values

//In Java, such a tree would be represented using an abstract super-class for the trees,
//and one concrete sub-class per node or leaf. 
//In a functional programming language, one would use an algebraic data-type for the same purpose. 
//Scala provides the concept of case classes which is somewhat in between the two. 



object _6_CaseClasses_Tree {
	abstract class Tree
	case class Sum(l: Tree, r: Tree) extends Tree
	case class Sub(l: Tree, r: Tree) extends Tree
	case class Var(n: String) extends Tree
	case class Const(v: Int) extends Tree
	
//	case classes means vs. standard classes:
	
//	Environment class
//	The aim of the environment is to give values to variables.
	type Environment = String => Int
	
//	Evaluation function definition
 
//	This evaluation function works by performing pattern matching on the tree t. 
//	
//	1. it first checks if the tree t is a Sum, and if it is, it binds the left sub-tree to a new
//	variable called l and the right sub-tree to a variable called r, and then proceeds
//	with the evaluation of the expression following the arrow; this expression
//	can (and does) make use of the variables bound by the pattern appearing
//	on the left of the arrow, i.e. l and r,
//	
//	2. if the next check does not succeed, it makes the same process of the first one but the instead of summing up left 
//	operand with the right one it substracts the right one to the left one. 
//	
//	3. if the next check does not succeed, that is if the tree is not a Sub, it goes on and
//	checks if t is a Var; if it is, it binds the name contained in the Var node to a
//	variable n and proceeds with the right-hand expression,
//	
//	4. if the next check also fails, that is if t is neither a Sum nor a Var, it checks
//	if it is a Const, and if it is, it binds the value contained in the Const node to a
//	variable v and proceeds with the right-hand side,
//	
//	5. finally, if all checks fail, an exception is raised to signal the failure of the pattern
//	matching expression; this could happen here only if more sub-classes of
//	Tree were declared.
	
	def eval(t: Tree, env: Environment): Int = t match {
	  	//	The value of a sum of two expressions is simply the sum of the value of these expressions;
	  	case Sum(l, r) => eval(l, env) + eval(r, env)
	  	//	The value of a substraction of two expressions is simply the substraction of the value of these expressions;
	  	case Sub(l, r) => eval(l, env) - eval(r, env)
		//	the value of a variable is obtained directly from the environment;
	  	case Var(n) => env(n)
//		the value of a constant is the constant itself
		case Const(v) => v
	}
	
//	To explore pattern matching further, let us define another operation on arithmetic expressions: symbolic derivation. 
//	The reader might remember the following rules

//	Two new pattern matching concepts 
//	1. The case expression for variables has a guard, an expression following the if keyword.
//		This guard prevents pattern matching from succeeding unless its expression is true. 
//		Here it is used to make sure that we return the constant 1 only if the name of
//		the variable being derived is the same as the derivation variable v. 
//	2. The second new feature of pattern matching used here is the wild-card, written _, 
//		which is a pattern matching any value, without giving it a name.
	
	def derive(t: Tree, v: String): Tree = t match {
//	  	the derivative of a sum is the sum of the derivatives,
		case Sum(l, r) => Sum(derive(l, v), derive(r, v))
//		the derivative of some variable v is one if v is the variable relative to which the derivation takes place, 
//		and zero otherwise,
		case Var(n) if (v == n) => Const(1)
//		the derivative of a constant is zero.
		case _ => Const(0)
	}
	
	
	def main(args: Array[String]) {
		val exp: Tree = Sub(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
		val env: Environment = { case "x" => 5 case "y" => 7 }
		println("Expression: " + exp)
		println("Expression(with toString): " + exp.toString())
		println("Evaluation with x=5, y=7: " + eval(exp, env))
		val exp2: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
		println("Derivative relative to x:\n " + derive(exp2, "x"))
		println("Derivative relative to y:\n " + derive(exp2, "y"))
	}
	
}