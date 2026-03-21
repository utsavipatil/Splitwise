package com.utsavi.splitwise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/* Command Design Pattern */
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	private Scanner scanner;

	@Override
	public void run(String... args) throws Exception{
		//Ask [u]ser to enter command

		//User will enter command
		//Process user input
			//Identify commands wants to execute and check if we have some command line
			//parse input params
			//call the right controller

		String input = scanner.nextLine();
		String[] words = input.split(" ");

		if(words[0].equalsIgnoreCase("Register") && words.length == 3){
			System.out.println("Register Command !!!");
			//TODO: call controller
		}else if(words[0].equalsIgnoreCase("Login") && words.length == 3){
			System.out.println("Login Command !!!");
			//TODO: call controller
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
