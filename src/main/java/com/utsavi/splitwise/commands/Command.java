package com.utsavi.splitwise.commands;

public interface Command {
   boolean match(String input);

   void execute(String input);
}
