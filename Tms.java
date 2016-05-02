package com.jv.p5;

import java.util.Scanner;

public class Tms{
	Assistant[] Tea = new Assistant[3];
	private nt index;
	/**
	 * ���Ա����Ϣ
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
	 * ��ѯ����Ա����Ϣ
	 */
	public Assistant[] queryAll(){
		Assistant[] demo = new Assistant[index];
		System.arraycopy(Ass,0,demo,0,index);
	    return demo;
	}

    /**
	 * �޸�Ա����Ϣ
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
	 * ͨ��idɾ��Ա����Ϣ
	 */
	public void deleteById(long id){
		int n = getIndexById(id);
		for(int i=n;i<index-1;i++){
		    Ass[i]=Ass[i+1];
		}
		Ass[index--] = null;
	}

    /**
	 * ͨ��id����Ա����Ϣ
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
	 * ͨ��id��ȡ�����������е�����
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
		System.out.println("********Ա����Ϣ����ϵͳ********");
	    System.out.println("*1.��ѯ����Ա����Ϣ");
		System.out.println("*2 ¼��Ա����Ϣ");
		System.out.println("*3 ɾ��Ա����Ϣ");
		System.out.println("*4 ͨ��id����Ա����Ϣ");
		System.out.println("*5 �޸�Ա����Ϣ");
		System.out.println("*exit �˳�ϵͳ��");
		System.out.println("*help ��ȡ����");
		System.out.println("********************************");
	}
	public static void main(String[] args){
	    Tms tms = new Tms();
		tms.menu();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("�������Ӧ��ָ�");
			String a = sc.nextLine();
			switch(a){
			    case "1":
					System.out.println("����������Ա������Ϣ��");
				    Assistant[] Assi = tms.queryAll();
					for(Assistant Ass : Ass){
					    System.out.println(ass);
					}
					System.out.println("һ����"+tms.index+"��Ա��");
					break;
				case "2":
					while(true){
					    System.out.println("������Ա������Ϣ��id#name#age�������롾break��������һ��Ŀ¼");
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
					    System.out.println("����ɹ�");
				}
					break;
				case "3":
					while(true){
					    System.out.println("������Ҫɾ����Ա���ġ�id�������롾break��������һ��Ŀ¼");
						String idTea = sc.nextLine();
						if(idTea.equals("break")){
						    break;
						}
						long id = Long.parseLong(idTea);
						tms.deleteById(id);
						System.out.println("ɾ���ɹ�");
				}
					break;
				case "4":
					while(true){
					    System.out.println("������Ҫ���ҵ�Ա���ġ�id�������롾break��������һ��Ŀ¼");
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
					    System.out.println("������Ҫ�޸�Ա���ġ�id�������롾break��������һ��Ŀ¼");
						String idTea = sc.nextLine();
					    if(idTea.equals("break")){
					        break;
					    }
					    long id = Long.parseLong(idTea);
						Assistant ass = tms.queryById(id);
						if(ass==null){
						    System.out.println("��Ҫ�޸ĵ�Ա�������ڣ���ȷ�ϡ�id���������룡");
							continue;
						}
						System.out.println("ԭ��ϢΪ��"+ass);
						System.out.println("����������Ϣ��name#age����");
						String str = sc.nextLine();
						String[] strArr = str.split("#");
						String name = strArr[0];
						int age = Integer.parseInt(strArr[1]);
						Assistant newtea = new Assistant(id,name,age);
						tms.update(newtea);
						System.out.println("�޸ĳɹ�");
				}
					break;
				case "exit":
					System.out.println("��ӭʹ�ã�");
				    System.exit(0);
				case "help":
					tms.menu();
					break;
				default:
					System.out.println("�������");
			}
		}
	}
}