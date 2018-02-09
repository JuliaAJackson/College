import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CollegesArray  extends JFrame
	{
		private static final long serialVersionUID = 1L;
		static String name; 
		static String stringDeduction;
		static int deduction;
		static String stringRecordedFeeling;
		static int recordedFeeling;
		static String location; 
		static String decisionDate; 
		static String bestKnownFor; 
		static String stringTuition; 
		static String stringStudentBodySize; 
		static int tuition;
		static int studentBodySize;
		static int feeling; 
		static int college;
		static int choice;
		static int financial;
		static JFrame frame = new JFrame();
		static ArrayList <Colleges> education = new ArrayList <Colleges>();
		public static void main(String[] args)
			{
				fillArray();
				addCollege();
				subtractFinancialAid();
				recordFeelings();
				decideHowToSort();
				sortSize();
				sortFeeling();
				sortTuition();
			}
		public static void fillArray()
			{
				education.add(new Colleges("Colorado College", "Colorado Springs, Colorado", "Early Action: December 20", "the block schedule", 68616, 2101, -1));
				education.add(new Colleges("Georgetown University", "Georgetown Neighborhood, Washignton D.C.", "Early Action: December 15", "politician heaven", 66971, 7453, -1));
				education.add(new Colleges("Claremont McKenna College", "Claremont, California", "Regular Decision: April 1", "the athenaeum", 69045, 1349, -1));
				education.add(new Colleges("Pomona College", "Claremont, California", "Regular Descision: April 1", "the consortium", 64870, 1660, -1));
				education.add(new Colleges("University of Colorado Boulder", "Boulder, Colorado", "Regular Descision: April 1", "sko buffs", 27884, 33246, -1));
			}
		public static void addCollege()
			{
				for (int i=0; i< education.size(); i++)
					{
						System.out.println(education.get(i).getName());
					}
				Object[] options = {"yes", "no"};
				college = JOptionPane.showOptionDialog(frame, "Would you like to add a college to this list?",
						"College",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options, options[1]);
				switch(college)
				{
					case 0:
						{
							JOptionPane.showMessageDialog(frame,"Okay you'll need some specifics about the school... get Google (or your intricate knowlege of the college process) ready");
							name = JOptionPane.showInputDialog("What is the name of the school");  
							location = JOptionPane.showInputDialog("Where is the school located");  
							decisionDate = JOptionPane.showInputDialog("When does the school put out acceptances?");  
							bestKnownFor = JOptionPane.showInputDialog("What is the school best known for?");  
							stringTuition = JOptionPane.showInputDialog("What is the tuition of the school?");  
							stringStudentBodySize = JOptionPane.showInputDialog("What is the school's student body size?");  
							feeling = -1;
							tuition = Integer.parseInt(stringTuition);
							studentBodySize = Integer.parseInt(stringStudentBodySize);
							education.add(new Colleges(name, location, decisionDate, bestKnownFor, tuition, studentBodySize, feeling));
							System.out.println("You have added " +  education.get(education.size()-1).getName() + "to the list");
							System.out.println(education.get(education.size()-1).getTuition());
							break;
						}
							
					case 1:
						{
							JOptionPane.showMessageDialog(frame, "Okay! Glad you've narrowed your choices down!");
							break;
						}
				}
			}
		public static void subtractFinancialAid()
			{
				
				Object[] options = new Object [education.size()];
				for (int i=0; i< education.size(); i++)
					{
						options[i]=education.get(i).getName();
					}
					
				choice = JOptionPane.showOptionDialog(frame, "Choose a College?",
						"Choice",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options, options[1]);
				Object[] options1 = {"yes", "no"};
				financial = JOptionPane.showOptionDialog(frame, "Did you receive any money from this school (do not include a dollar sign)?",
						"Financial",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options1, options1[1]);
				switch(financial)
				{
					case 0:
						{
							
							stringDeduction = JOptionPane.showInputDialog("How much money did they offer (do not incluse a dollar sign)");  
							deduction = Integer.parseInt(stringDeduction);
							education.get(choice).setTuition(education.get(choice).getTuition()-deduction);
							JOptionPane.showMessageDialog(frame, "Tuition for " + education.get(choice).getName() + " would now be $" + education.get(choice).getTuition());
							break;
						}
					case 1:
							{
								JOptionPane.showMessageDialog(frame, "Too bad! Enjoy being poor!");
								break;
							}
				}
			}
		public static void recordFeelings()
			{
				JOptionPane.showMessageDialog(frame, "How confident are you that you want to go to each school on a scale of 1-10 (1 being 'ew no') (10 being 'Why aren't I there already?')");
				for (int i=0; i< education.size(); i++)
					{
						stringRecordedFeeling = JOptionPane.showInputDialog("How do you feel about " + education.get(i).getName() + "?");
						recordedFeeling = Integer.parseInt(stringRecordedFeeling);
						education.get(i).setFeeling(recordedFeeling);
					}	
				for (int e=0; e< education.size(); e++)
					{
						JOptionPane.showMessageDialog(frame,"You have " + education.get(e).getFeeling() + " confidence about going to " + education.get(e).getName());
					}
			}
		public static void sortTuition()
			{
				Collections.sort(education, new TuitionComparison());
			}
		public static void sortSize()
			{
				Collections.sort(education, new SizeComparison());
			}
		public static void sortFeeling()
			{
				Collections.sort(education, new FeelingComparison());
			}
		public static void decideHowToSort()
			{
				String[] organization = { "By tuition", "By school size (favoring big schools)", "By school size (favoring small schools)",  "By feeling" };
				JFrame frame = new JFrame();
			    String order = (String) JOptionPane.showInputDialog(frame, 
			            "How would you like to sort the schools?",
			            "Order",
			            JOptionPane.QUESTION_MESSAGE, 
			            null, 
			            organization, 
			            organization[0]);
			  switch(order) 	
				{
					case "By tuition":
						{
							sortTuition();
							JOptionPane.showMessageDialog(frame, "The cheapest (more money for vacation) school is " + education.get(education.size()-1).getName());
							break;
						}
					case "By school size (favoring big schools)":
						{
							
							sortSize();
							JOptionPane.showMessageDialog(frame, "The biggest (best?) school is " + education.get(0).getName());
							break;
						}
					case "By school size (favoring small schools)":
						{
							sortSize();
							JOptionPane.showMessageDialog(frame, "The smallest (coziest) school is " + education.get(education.size()-1).getName());
							break;	
						}
					case "By feeling":
						{
							sortFeeling();
							JOptionPane.showMessageDialog(frame, "The school you feel most confident about going to is " + education.get(0).getName() );
							break;		
						}
				}
			}
		}
	









