package com.qzk.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

//lombok@bulider注解例子
public class BuilderExample {
	  private String name;
	  private int age;
	  private Set<String> occupations;
	  
	  BuilderExample(String name, int age, ArrayList<String> occupations2) {
	    this.name = name;
	    this.age = age;
	    //this.occupations = occupations2.;
	  }
	  
	  public static BuilderExampleBuilder builder() {
	    return new BuilderExampleBuilder();
	  }
	  
	  public static class BuilderExampleBuilder {
	    private String name;
	    private int age;
	    private java.util.ArrayList<String> occupations;
	    
	    BuilderExampleBuilder() {
	    }
	    
	    public BuilderExampleBuilder name(String name) {
	      this.name = name;
	      return this;
	    }
	    
	    public BuilderExampleBuilder age(int age) {
	      this.age = age;
	      return this;
	    }
	    
	    public BuilderExampleBuilder occupation(String occupation) {
	      if (this.occupations == null) {
	        this.occupations = new java.util.ArrayList<String>();
	      }
	      
	      this.occupations.add(occupation);
	      return this;
	    }
	    
	    public BuilderExampleBuilder occupations(Collection<? extends String> occupations) {
	      if (this.occupations == null) {
	        this.occupations = new java.util.ArrayList<String>();
	      }

	      this.occupations.addAll(occupations);
	      return this;
	    }
	    
	    public BuilderExampleBuilder clearOccupations() {
	      if (this.occupations != null) {
	        this.occupations.clear();
	      }
	      
	      return this;
	    }

	    public BuilderExample build() {
	      // complicated switch statement to produce a compact properly sized immutable set omitted.
	      // go to https://projectlombok.org/features/Singular-snippet.html to see it.
	      //Set<String> occupations = ...;
	      return new BuilderExample(name, age, occupations);
	    }
	    
	    @java.lang.Override
	    public String toString() {
	      return "BuilderExample.BuilderExampleBuilder(name = " + this.name + ", age = " + this.age + ", occupations = " + this.occupations + ")";
	    }
	  }
	}