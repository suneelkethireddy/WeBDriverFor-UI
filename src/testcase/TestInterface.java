package testcase;

interface interfaceOne{   //By default public abstract
	int i=10;             //by default public static final(public static final int i=10
	public abstract void display();		  //by default it will be public abstract(public abstract void display()
	String getMsg(String str);
}
interface interfaceTwo{
	void showInt();
}
class BaseClass implements interfaceOne,interfaceTwo{
	
	@Override
	public void display(){
		System.err.println("Interface Method One");
	}
	@Override
	public String getMsg(String str){
		return str;
	}
	@Override
	public void showInt() {
		System.err.println("Interface Method Two");
		
	}
}
public class TestInterface {

	public static void main(String[] args) {
		BaseClass obj=new BaseClass();
		obj.display();
		System.err.println("value : "+obj.getMsg("Method"));
		obj.showInt();
		
		interfaceOne obj1=new BaseClass();
		obj1.display();
		obj1.getMsg("Interface as object");
		

	}

}
