package com.bloc.securitypackages.apples;

import com.bloc.securitypackages.*;
import com.bloc.securitypackages.colors.*;
/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

abstract public class Apple extends Fruit {

	public Apple(){
		super(Apple.class.getSimpleName(), 230, new LimeGreen(), 0.21d);
	}

	abstract void bite();

}