package com.bloc.objects;

class PopSong extends Song {
	// The number of weeks this song stayed on Billboard's top 100
	int mWeeksOnBillboard;

	/*
	 * PopSong
	 *
	 * Side-effects: Assigns some default ensemble, title,
	 *				 year and number of weeks on billboard
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the first PopSong constructor
	/************************************************/
	PopSong() {
		Artist[] artistArray = new Artist[1];
		Artist mArtist = new Artist("Antonio", "Carella");
		artistArray[0] = mArtist; 
		mEnsemble = new Ensemble(artistArray);
		mTitle = "Daddy Why Did You Eat My Fries?";
		mYearReleased = 2009;
		mWeeksOnBillboard = 500;
	}

	/*
	 * PopSong
	 * 
	 * Side-effects: Sets the year of release to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the second PopSong constructor
	/************************************************/
	PopSong(Ensemble ensemble, String title) {
		mEnsemble = ensemble;
		mTitle = title;
		mYearReleased = 0;
	}

	/*
	 * PopSong
	 *
	 * Side-effects: Sets the weeks on billboard to 0
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the third PopSong constructor
	/************************************************/
	PopSong(Ensemble ensemble, String title, int yearReleased) {
		mEnsemble = ensemble;
		mTitle = title;
		mYearReleased = yearReleased;
		mWeeksOnBillboard = 0;
	}

	/*
	 * PopSong
	 *
	 * @param ensemble the ensemble responsible (Ensemble)
	 * @param title the song title (String)
	 * @param yearReleased the year the song was released (int)
	 * @param weeksOnBillboard number of weeks this song lasted on the
	 *		  				   Billboard's top 100 (int)
	 */
	/************************************************
	 *	ASSIGNMENT:
	 *	Create the fourth PopSong constructor
	/************************************************/
	PopSong(Ensemble ensemble, String title, int yearReleased, int weeksOnBillboard) {
		mEnsemble = ensemble;
		mTitle = title;
		mYearReleased = yearReleased;
		mWeeksOnBillboard = weeksOnBillboard;
	}
}