package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.*;
import com.bloc.securitypackages.colors.*;
/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Macintosh extends Apple {

	public Macintosh() {
		super();
	}

	void bite() {
		setWeight(getWeight() - 0.01d);
	}

}