package com.utsavi.splitwise.commands;

public class RegisterUserCommand implements Command{

  @Override
  public boolean match(String input){
    String[] words = input.split(" ");
    return words[0].equalsIgnoreCase("Register") && words.length == 3;
  }

  @Override
  public void execute(String input){
    String[] words = input.split(" ");
    System.out.println("Execute User Registration");
    //TODO: call controller
  }
}
