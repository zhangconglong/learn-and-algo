package 设计模式.command.calculator;
 
import java.util.ArrayList;

public class User {
private ArrayList<Command>commands=new ArrayList<Command>();
private int count=0;
public void Compute(Command command)
{command.Execute();
count++;
commands.add(command);
 
}
public void Redo(int levels)
{for(int i=0;i<levels;i++)
{if(count<commands.size())
	{count++;
	commands.get(count-1).Execute();
 
}
}
}
public void Undo(int levels)
{for(int i=0;i<levels;i++)
	if(count>0)
	{
		commands.get(count-1).UnExecute();
	count--;
	}
}
}