
public class SimSchoolXMLReader {
	
	String data;
	FileIO reader;
	
	public SimSchoolXMLReader(String filename) {
		reader = new FileIO();
		data = reader.readFile(filename);
	}
	
	public void setFilename(String filename) {
		data = reader.readFile(filename);
	}
	
	private String returnBetweenTag(String keyword) {
		return data.substring(data.indexOf('<' + keyword + '>') + keyword.length() + 2, data.indexOf("</" + keyword + '>'));
	}
	
	private String getFirstKeyword() {
		
	}
	
	private String substringInside(int start) {
		
	}
	
	public Person[] toPeople() {
		String k = getFirstKeyword();
		if (k.equalsIgnoreCase("person")) {
			
		}
	}
	
	private Person toPerson(String s) {
		int age = Integer.parseInt(returnBetweenTag("age"));
		String gender = returnBetweenTag("gender");
		String name = returnBetweenTag("name");
		return new Person(name, age, gender);
		
	}
	
	private Student toStudent(String s) {
		Person p = toPerson(s);
		String ID = returnBetweenTag("ID");
		double GPA = Double.parseDouble(returnBetweenTag("GPA"));
		return new Student(p.getName(), p.getAge(), p.getGender(), ID, GPA);
	}
	
	private CollegeStudent toCollegeStudent(String s) {
		Student p = toStudent(s);
		String major = returnBetweenTag("major");
		int year = Integer.parseInt(returnBetweenTag("year"));
		return new CollegeStudent(p.getName(), p.getAge(), p.getGender(), p.getIdNum(), p.getGPA(), year, major);
	}

	private Teacher toTeacher(String s) {
		Person p = toPerson(s);
		String subject = returnBetweenTag("subject");
		double salary = Double.parseDouble(returnBetweenTag("salary"));
		return new Teacher(p.getName(), p.getAge(), p.getGender(), subject, salary);
	}
}
