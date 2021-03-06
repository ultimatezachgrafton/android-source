package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the Chihuahua class below
 *
 *	Chiuahuas must be fed 5 times in order to grow
 *	larger.
/************************************************/
class Chihuahua extends Dog {
	final float WEIGHT_GAIN = 0.25f;
	int mFeedCounter;

	@Override
	void feed() {
		mWeight += WEIGHT_GAIN;
		mFeedCounter += 1;
		if (mFeedCounter % 5 == 0) {
			if (mSize == "tiny") {
				mSize = "small";
			}
			else if (mSize == "small") {
				mSize = "average";
			}
			else if (mSize == "average") {
				mSize = "large";
			} 
		}
	}
}