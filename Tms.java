package com.jv.p5;

import java.util.Scanner;

public class Tms{
	Assistant[] Tea = new Assistant[3];
	private nt index;
	/**
	 * 添加员工信息
	 */
	public void save(Assistant assistant){
	    if(index>=Ass.length){
		    Assistant[] demo = new Assistant[Assistant.length+3];
            System.arraycopy(Ass,0,demo,0,index);
			Assistant = demo;
		}
		Ass[index++] = assistant;
	}

    /**
	 * 查询所有员工信息
	 */
	public Assistant[] queryAll(){
		Assistant[] demo = new Assistant[index];
		System.arraycopy(Ass,0,demo,0,index);
	    return demo;
	}

    /**
	 * 修改员工信息
	 */
	public void update(Assistant assistant){
		for(int i=0;i<index;i++){
		    if(Ass[i].getId()==assistant.getId()){
			    Ass[i].setName(assistant.getName());
				Ass[i].setAge(assistant.getAge());
			}
		}
	}

    /**
	 * 通过id删除员工信息
	 */
	public void deleteById(long id){
		int n = getIndexById(id);
		for(int i=n;i<index-1;i++){
		    Ass[i]=Ass[i+1];
		}
		Ass[index--] = null;
	}

    /**
	 * 通过id查找员工信息
	 */
	public Assistant queryById(long id){
		int n = getIndexById(id);
		if(n == -1){
		    return null;
		}
		else{
	        return Tea[n];
		}
	}

    /**
	 * 通过id获取对象在数组中的索引
	 */
	private int getIndexById(long id){
	    int n = -1;
		for(int i=0;i<Assi.length;i++){
		    if(Ass[i].getId()==id){
			    n = i;
				break;
			}
		}
		return n;
	}

	public void menu()
	{
		System.out.println("********员工信息管理系统********");
	    System.out.println("*1.查询所有员工信息");
		System.out.println("*2 录入员工信息");
		System.out.println("*3 删除员工信息");
		System.out.println("*4 通过id查找员工信息");
		System.out.println("*5 修改员工信息");
		System.out.println("*exit 退出系统！");
		System.out.println("*help 获取帮助");
		System.out.println("********************************");
	}
	public static void main(String[] args){
	    Tms tms = new Tms();
		tms.menu();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("请输入对应的指令：");
			String a = sc.nextLine();
			switch(a){
			    case "1":
					System.out.println("以下是所有员工的信息：");
				    Assistant[] Assi = tms.queryAll();
					for(Assistant Ass : Ass){
					    System.out.println(ass);
					}
					System.out.println("一共有"+tms.index+"名员工");
					break;
				case "2":
					while(true){
					    System.out.println("请输入员工的信息【id#name#age】或输入【break】返回上一级目录");
				        String ass = sc.nextLine();
					    if(ass.equals("break")){
						    break;
					    }
					    String[] assA = ass.split("#");
					    Long id = Long.parseLong(assA[0]);
					    String name = assA[1];
					    int age = Integer.parseInt(assA[2]);
					    Assistant assA = new Assistant(id,name,age);
					    tms.save(AssA);
					    System.out.println("保存成功");
				}
					break;
				case "3":
					while(true){
					    System.out.println("请输入要删除的员工的【id】或输入【break】返回上一层目录");
						String idTea = sc.nextLine();
						if(idTea.equals("break")){
						    break;
						}
						long id = Long.parseLong(idTea);
						tms.deleteById(id);
						System.out.println("删除成功");
				}
					break;
				case "4":
					while(true){
					    System.out.println("请输入要查找的员工的【id】或输入【break】返回上一层目录");
				        String idTea = sc.nextLine();
					    if(idTea.equals("break")){
					        break;
					    }
					    long id = Long.parseLong(idTea);
					    Assistant tea = tms.queryById(id);
					    System.out.println(ass==null?"sorry,not found":assi);
				}
					break;
				case "5":
				    while(true){
					    System.out.println("请输入要修改员工的【id】或输入【break】返回上一层目录");
						String idTea = sc.nextLine();
					    if(idTea.equals("break")){
					        break;
					    }
					    long id = Long.parseLong(idTea);
						Assistant ass = tms.queryById(id);
						if(ass==null){
						    System.out.println("你要修改的员工不存在，请确认【id】后再输入！");
							continue;
						}
						System.out.println("原信息为："+ass);
						System.out.println("请输入新信息【name#age】：");
						String str = sc.nextLine();
						String[] strArr = str.split("#");
						String name = strArr[0];
						int age = Integer.parseInt(strArr[1]);
						Assistant newtea = new Assistant(id,name,age);
						tms.update(newtea);
						System.out.println("修改成功");
				}
					break;
				case "exit":
					System.out.println("欢迎使用！");
				    System.exit(0);
				case "help":
					tms.menu();
					break;
				default:
					System.out.println("输入错误");
			}
		}
	}
}