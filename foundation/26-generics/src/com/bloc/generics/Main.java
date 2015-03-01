package com.bloc.generics;

import com.bloc.generics.things.*;

public class Main extends Object {

	public static void main(String [] args) {

		ToyBox toyBox = new ToyBox();

		ActionFigure antonioCarella = new ActionFigure();
		Book flowersForAlgernon = new Book();
		Spoon shinySpoon = new Spoon();

		Toy<ActionFigure> blocSuperMentors = new Toy<ActionFigure>(antonioCarella);
		Toy<Book> superSadBooks = new Toy<Book>(flowersForAlgernon);
		Toy<Spoon> heartbreakingBeauty = new Toy<Spoon>(shinySpoon);

		toyBox.addToy(blocSuperMentors);	
		toyBox.addToy(superSadBooks);
		toyBox.addToy(heartbreakingBeauty);
		
		/************************************************
 		 *	ASSIGNMENT:
 		 *	Place several Toy objects into toyBox
		/************************************************/

		assert toyBox.getToyCount() > 0 : "Let's get some toys in that box!";
		System.out.println("Inside your toybox you've got:");
		for (int i = 0; i < toyBox.getToyCount(); i++) {
			System.out.println("- " + toyBox.getToyAtIndex(i).get());
		}
		System.out.println("Sounds like fun!\n");

		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/*   If you see this,   */");
		System.out.println("/*   congratulations!   */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}
}
