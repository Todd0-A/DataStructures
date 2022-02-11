package HashTable;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable=new HashTable(7);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("find");
            System.out.println("exit");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("Input id");
                    int id=scanner.nextInt();
                    System.out.println("Input name");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("input id");
                    id=scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    static class Emp{
        public int id;
        public String name;
        public Emp next;
        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    static class EmpLinkedList{
        private Emp head;
        public void add(Emp emp){
            if(head==null){
                head=emp;
                return;
            }
            Emp temp=head;
            while (true){
                if (temp.next==null)
                    break;
                temp=temp.next;
            }
            temp.next=emp;
        }
        public void list(int no){
            if(head==null){
                System.out.println(no+1+":  \n"+"Empty LinkedList");
                return;
            }
            Emp temp=head;
            System.out.println(no+1+":  ");
            while (true){
                System.out.printf("=> id=%d  name:%s\t",temp.id,temp.name);
                if (temp.next==null)
                    break;
                temp=temp.next;
            }
            System.out.println();
        }
        public Emp findEmpById(int id){
            if (head==null){
                System.out.println("Empty LinkedList");
                return null;
            }
            Emp temp=head;
            while(true) {
                if (temp.id == id) {
                    break;
                }
                if (temp.next==null){
                    temp=null;
                    break;
                }
                temp=temp.next;
            }
            return temp;
        }
    }

    static class HashTable{
        private EmpLinkedList[] empLinkedLists;
        private int size;
        public HashTable(int size){
            empLinkedLists=new EmpLinkedList[size];
            this.size=size;
            for (int i=0;i<size;i++){
                empLinkedLists[i]=new EmpLinkedList();
            }
        }
        public void add(Emp emp){
            int index=hashFun(emp.id);
            empLinkedLists[index].add(emp);
        }
        public void list(){
            for (int i=0;i<size;i++){
                empLinkedLists[i].list(i);
            }
        }
        public int hashFun(int id){
            return id%size;
        }
        public void findEmpById(int id){
            int index=hashFun(id);
            Emp emp=empLinkedLists[index].findEmpById(id);
            if(emp!=null){
                System.out.printf("No:%d id=%d",index+1,id);
            }else {
                System.out.println("Not found");
            }
        }
    }
}
