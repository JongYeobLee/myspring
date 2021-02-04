package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

		//Exam exam = new NewlecExam();
		
		/*
		 * ExamConsole console = new InlineExamConsole(exam); // DI(Dependency
		 * Injection) ExamConsole console2 = new GridExamConsole(exam);
		 * 
		 * console.print(); console2.print();
		 */

		/*
		 * ExamConsole console3 = new GridExamConsole();
		 * console3.setExam(exam);
		 * console3.print();
		 */
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		ExamConsole console4 = (ExamConsole) context.getBean("console4");
		//ExamConsole console4 = context.getBean(ExamConsole.class);
		console4.print();

	}

}
