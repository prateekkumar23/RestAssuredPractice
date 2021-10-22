package encapsulationExample;

public class Person {
	
	private String name;
	private String gender;
	private Integer age;
	private String occupation;
	
	
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			if(name.equalsIgnoreCase("Pattyson")) {
				this.name=name;
			}
		}

		public int getAge() {
			return age;
		}
		
		public void setAge(Integer age) {
			if(age.intValue(32)) {
			this.age=age;
			}
		}

	
}
