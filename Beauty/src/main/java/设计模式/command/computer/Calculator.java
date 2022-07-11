package 设计模式.command.computer;//package com.pattern.command.computer;
//
///**
// * @version: v1.0
// * @description：计算器类
// * @author: zhangconglong on 2021/11/29 22:24
// */
//public class Calculator {
//	private AbstractCommand command;
//
//	public Calculator(){
//	}
//
//	public void setCommand(AbstractCommand command){
//		this.command = command;
//	}
//
//	public int compute(int value){
//		int res = command.execute(value);
//		System.out.println(res);
//		return res;
//	}
//
//	public int undo(){
//		int res = command.undo();
//		System.out.println("撤销操作，当前结果为" + res);
//		return  res;
//	}
//
//	public int redo(){
//		int res = command.redo();
//		System.out.println("取消撤销操作，当前结果为" + res);
//		return res;
//	}
//
//	public int display(){
//		int res = command.display();
//		System.out.println("计算结果为：" + res);
//		return res;
//	}
//
//}
