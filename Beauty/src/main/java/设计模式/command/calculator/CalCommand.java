package 设计模式.command.calculator;
 
public class CalCommand extends Command {
 
	public CalCommand(Caculator cal, char op, int num) {
		super(cal, op, num);
		
	}
 
	@Override
	public void Execute() {
	cal.Operation(op, num);
	}
 
	@Override
	public void UnExecute() {
		cal.Operation(undo(op), num);
 
	}
	private char undo(char op)
	{char undo=' ';
	switch(op)
	{case '+':undo='-';break;
	case '-':undo='+'; break;
	case '*':undo='/';break;
	case '/': undo='*'; break;
	}
	return undo;
	}
 
}