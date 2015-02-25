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
		Ensemble mEnsemble = new Ensemble(artistArray);
		String mTitle = "Daddy Why Did You Eat My Fries?";
		int mYearRelease = 2009;
		int mWeeksOnBillboard = 500;
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
		int mYearRelease = 0;
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
		Ensemble mEnsemble = ensemble;
		String mTitle = title;
		int mYearRelease = yearReleased;
		int mWeeksOnBillboard = 0;
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
		Ensemble mEnsemble = ensemble;
		String mTitle = title;
		int mYearRelease = yearReleased;
		int mWeeksOnBillboard = weeksOnBillboard;
	}
}