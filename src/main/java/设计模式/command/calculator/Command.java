package 设计模式.command.calculator;
 
public abstract class Command {
	protected Caculator cal;
	protected char op;;
	protected int num;
	
public Command(Caculator cal, char op, int num) {
		
		this.cal = cal;
		this.op = op;
		this.num = num;
	}
public abstract void Execute();
public abstract void UnExecute();
}