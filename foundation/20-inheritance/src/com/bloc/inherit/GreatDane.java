package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the GreatDane class below
 *
 *	Great Danes have an extra size category, "huge".
 *	After growing to a "large" size, they may grow
 *	to an additional, "huge" size after 3 meals.
/************************************************/
class GreatDane extends Dog {
	final float WEIGHT_GAIN = 0.25f;
	int mMeals;
	String[] sizeArray = {"tiny", "small", "average", "large", "huge"};

	@Override
	void feed() {
		mWeight += WEIGHT_GAIN;
		mMeals += 1;
		if (mMeals < 3) {
			mSize = "tiny";
		}
		else if (mMeals % 3 == 0) {
			mSize = sizeArray[(mMeals/3)];
		}
	}
}