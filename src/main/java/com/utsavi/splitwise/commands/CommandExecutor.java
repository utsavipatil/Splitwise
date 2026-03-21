package com.utsavi.splitwise.commands;

import java.util.List;

public class CommandExecutor {
  private List<Command> commands;

  public CommandExecutor(List<Command> commands){
    this.commands = commands;
  }

  public void add(Command command){
    commands.add(command);
  }

  public void remove(Command command){
    commands.remove(command);
  }

  public void execute(String input){
    for(Command command : commands){
      if(command.match(input)){
        command.execute(input);
      }
    }
  }
}
