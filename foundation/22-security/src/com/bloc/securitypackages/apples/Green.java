package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.*;
import com.bloc.securitypackages.colors.*;
/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Green extends Apple {

	public Green() {
		super();
	}

	void bite() {
		setWeight(getWeight() - 0.02d);
	}

}