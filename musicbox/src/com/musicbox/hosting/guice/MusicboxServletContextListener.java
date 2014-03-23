package com.musicbox.hosting.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class MusicboxServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new MainModule());
	}

}
