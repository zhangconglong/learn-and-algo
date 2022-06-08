package 设计模式.command.calculator;
 
public class Caculator {
private int total;
 
public Caculator() {
	
	this.total = 0;
}
 
public void Operation(char op,int num)
{switch(op)
	{case '+':total+=num;break;
	case '-':total-=num;break;
	case '*':total*=num;break;
	case '/':total/=num;break;
}
System.out.println(op+" "+num+"="+total);
 
}
}