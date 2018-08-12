package part1.counseling;

import java.util.List;

public class Student {
	private final String name;
	private final List<String> programPreference;
	private String allotedProgram;

	/**
	 * @param name
	 * @param programPreference
	 */
	public Student(String name, List<String> programPreference) {
		this.name = name;
		this.programPreference = programPreference;
	}

	public String getName() {
		return name;
	}

	public List<String> getProgramPreference() {
		return programPreference;
	}

	public String getAllotedProgram() {
		return allotedProgram;
	}

	public void setAllotedProgram(String allotedProgram) {
		this.allotedProgram = allotedProgram;
	}
	
}
