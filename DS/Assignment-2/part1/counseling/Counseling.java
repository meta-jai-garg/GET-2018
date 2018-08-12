package part1.counseling;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import queue.LinkedQueue;
import queue.Queue;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Counseling {

	public Map<String, String> allotProgram(String courseFilePath) {
		Map<String, String> allotedProgram = new HashMap<String, String>();
		if (courseFilePath.equals(null)) {
			throw new AssertionError("Can't find file path!");
		}
		try {
			Workbook courseBook = Workbook
					.getWorkbook(new File(courseFilePath));
			Sheet programSheet = courseBook.getSheet(0);
			Sheet studentSheet = courseBook.getSheet(1);
			Map<String, Integer> programs = new HashMap<String, Integer>();
			int noOfPrograms = programSheet.getRows() - 1;
			for (int i = 1; i <= noOfPrograms; i++) {
				String courseName = programSheet.getCell(0, i).getContents();
				int courseCapacity = Integer.parseInt(programSheet
						.getCell(1, i).getContents());
				programs.put(courseName, courseCapacity);
			}
			Queue<Student> studentQueue = new LinkedQueue<Student>();
			int totalStudent = studentSheet.getRows() - 1;
			int totalPreference = studentSheet.getColumns() - 1;
			List<String> preferences = new ArrayList<String>();
			for (int i = 1; i <= totalStudent; i++) {
				Cell[] s = studentSheet.getRow(i);
				for (int j = 1; j < s.length; j++) {
					preferences.add(s[j].getContents());
				}
				studentQueue.enqueue(new Student(s[0].getContents(),
						preferences));
				System.out.println(preferences);
				preferences.clear();
			}

			for (int i = 1; i <= totalStudent; i++) {
				Student student = studentQueue.dequeue();
				System.out.println(student.getProgramPreference());
				for (String preference : student.getProgramPreference()) {
					int programCapacity = programs.get(preference);
					System.out.println(programCapacity);
					if (programCapacity != 0) {
						student.setAllotedProgram(preference);
						programs.put(preference, programCapacity - 1);
						break;
					}
				}
				allotedProgram.put(student.getName(),
						student.getAllotedProgram());
			}

			// WritableWorkbook workbook = Workbook.createWorkbook(new File(
			// "C:/Users/User22/Downloads/alloted_sheet.xls"));
			// WritableSheet allotedSheet = workbook.createSheet("sheet1", 0);
			//
			// for (int i = 0; i < allotedProgram.size(); i++) {
			// for (String studentName : allotedProgram.keySet()) {
			// Label l1 = new Label(0, i, studentName);
			// allotedSheet.addCell(l1);
			//
			// Label l2 = new Label(1, i, allotedProgram.get(studentName));
			// allotedSheet.addCell(l2);
			// }
			// }
			// workbook.write();
			// workbook.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allotedProgram;
	}

	public static void main(String[] args) {
		new Counseling()
				.allotProgram("C:/Users/User22/Downloads/course_data_complete.xls");
	}
}