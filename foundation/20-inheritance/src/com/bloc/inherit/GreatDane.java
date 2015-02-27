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

	@Override
	void feed() {
		mWeight += WEIGHT_GAINED_FROM_FEEDING;
		mFeedCounter += 1;
		if (mFeedCounter % 3 == 0) {
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