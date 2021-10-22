package encapsulationExample;

public class OutsidePerson {

	public static void main(String[] args) {
		Person p = new Person();
		
		p.setAge(32);
		System.out.println(p.getAge());
		p.setName("Pattyson");
		System.out.println(p.getName());

	}

}
