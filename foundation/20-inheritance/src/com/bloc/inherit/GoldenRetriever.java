package com.bloc.inherit;

/************************************************
 *	ASSIGNMENT:
 *	Define the GoldenRetriever class below
 *
 *	Golden Retrievers shrink to a smaller size after
 *	playing only 3 times.
/************************************************/
class GoldenRetriever extends Dog {
	final float MIN_WEIGHT = 1.25f;
	final float WEIGHT_LOSS = 0.2f;
	int mPlayCounter;

	@Override
	void play() {
		mPlayCounter += 1;
		if (mWeight > MIN_WEIGHT) {
			mWeight -= WEIGHT_LOSS;
		}
		if (mPlayCounter % 3 == 0) {
			if (mSize == "large") {
				mSize = "average";
			}
			else if (mSize == "average") {
				mSize = "small";
			}
			else if (mSize == "small") {
				mSize = "tiny";
			} 
		}
    }
}