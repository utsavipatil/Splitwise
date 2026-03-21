package com.utsavi.splitwise;

import com.utsavi.splitwise.commands.Command;
import com.utsavi.splitwise.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Command Design Pattern */
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	private Scanner scanner = new Scanner(System.in);
	private CommandExecutor commandExecutor = new CommandExecutor(new ArrayList< >());

	@Override
	public void run(String... args) throws Exception{
		//Ask [u]ser to enter command

		//User will enter command
		//Process user input
			//Identify commands wants to execute and check if we have some command line
			//parse input params
			//call the right controller

		String input = scanner.nextLine();

		commandExecutor.execute(input );
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
