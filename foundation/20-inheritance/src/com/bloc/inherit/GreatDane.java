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

	@Override
	void feed() {
		mWeight += WEIGHT_GAIN;
		mMeals += 1;
		if (mMeals % 3 == 0) {
			if (mSize == "tiny") {
				mSize = "small";
			}
			else if (mSize == "small") {
				mSize = "average";
			}
			else if (mSize == "average") {
				mSize = "large";
			}
			else if (mSize == "large") {
				mSize = "huge";
			} 
		}
	}
}