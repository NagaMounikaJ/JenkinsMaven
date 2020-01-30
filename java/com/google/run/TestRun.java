package com.google.run;

import org.testng.annotations.Test;

import com.google.automation.util.GenericConfig;
import com.google.search.JenkinsSearch;

public class TestRun extends GenericConfig{
	JenkinsSearch js = new JenkinsSearch();
	
	@Test
	public void search(){
		js.search(driver, extTest);
	}

}
