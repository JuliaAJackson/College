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
		static String pro;
		static String con;
		static String prosList;
		static String consList;
		static int finalDecision;
		static JFrame frame = new JFrame();
		static ArrayList <Colleges> education = new ArrayList <Colleges>();
		public static void main(String[] args)
			{
				fillArray();
				addCollege();
				subtractFinancialAid();
				recordFeelings();
				makeProsCons();
				decideHowToSort();
				sortSize();
				sortFeeling();
				sortTuition();
				educateChoice();
				makeAChoice();
				randomChoice();
			}
		public static void fillArray()
			{
				education.add(new Colleges("Colorado College", "Colorado Springs, Colorado", "Early Action: December 20", "the block schedule", 68616, 2101, -1, "", " "));
				education.add(new Colleges("Georgetown University", "Georgetown Neighborhood, Washignton D.C.", "Early Action: December 15", "political heaven", 66971, 7453, -1, "", " "));
				education.add(new Colleges("Claremont McKenna College", "Claremont, California", "Regular Decision: April 1", "the athenaeum", 69045, 1349, -1, "", " "));
				education.add(new Colleges("Pomona College", "Claremont, California", "Regular Descision: April 1", "the consortium", 64870, 1660, -1, "", " "));
				education.add(new Colleges("University of Colorado Boulder", "Boulder, Colorado", "Regular Descision: April 1", "sko buffs", 27884, 33246, -1, "", " "));
			}
		public static void addCollege()
			{
    				
				JOptionPane.showMessageDialog(frame, "Hello! Here are some potential colleges you may want to attend: " + education.get(0).getName() + ", " + education.get(1).getName() + ", " + education.get(2).getName() + ", " + education.get(3).getName() + ", " + education.get(4).getName());
   						
   					Object[] options = {"yes", "no"};
    				int college = JOptionPane.showOptionDialog(frame, "Would you like to add a college to this list?",
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
    							pro = " ";
    							con = " ";
    							tuition = Integer.parseInt(stringTuition);
    							studentBodySize = Integer.parseInt(stringStudentBodySize);
    							education.add(new Colleges(name, location, decisionDate, bestKnownFor, tuition, studentBodySize, feeling, pro, con));
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
				boolean subtracting = true; 
				while (subtracting)
    				{
    					Object[] options = new Object [education.size()];
    					for (int i=0; i< education.size(); i++)
    						{
    							options[i]=education.get(i).getName();
    						}	
    					int choice = JOptionPane.showOptionDialog(frame, "Let's figure out the financials! Chose a college.",
    							"Choice",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options, options[1]);
    					Object[] options1 = {"yes", "no"};
    					int financial = JOptionPane.showOptionDialog(frame, "Did you receive any money from this school?",
    							"Financial",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options1, options1[1]);
    					switch(financial)
    						{
    						case 0:
    							{
							
    								stringDeduction = JOptionPane.showInputDialog("How much money did they offer (do not include a dollar sign)");  
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
    					Object[] options2 = {"yes", "no"};
    					int financial2 = JOptionPane.showOptionDialog(frame, "Did you receive any money from other schools??",
    							"Financial",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options2, options2[1]);
    					switch(financial2)
							{
							case 0:
								{
									JOptionPane.showMessageDialog(frame,"good!"); 
									break;
								}
							case 1: 
								{
									JOptionPane.showMessageDialog(frame,"I see debt in your future!"); 
									subtracting = false;
									break;
								}
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
			}
		public static void makeProsCons()
			{
				boolean listing = true; 
				while (listing)
    				{
    					Object[] options = new Object [education.size()];
    					for (int i=0; i< education.size(); i++)
    						{
    							options[i]=education.get(i).getName();
    							int schoolChoice = i; 
    						}	
    					int school = JOptionPane.showOptionDialog(frame, "Let's figure out the pros and cons! Chose a college.",
    							"School",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options, options[1]);
    					Object[] options1 = {"yes", "no"};
    					int list = JOptionPane.showOptionDialog(frame, "Would you like to list the pros and cons for this school?",
    							"list",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options1, options1[1]);
    					switch(list)
    						{
    						case 0:
    							{
    								JOptionPane.showMessageDialog(frame,"Let's start!"); 
    								prosList = JOptionPane.showInputDialog("What are the pros about this school?"); 
    								education.get(school).setPro(prosList);
    								consList = JOptionPane.showInputDialog("What are the cons about this school?"); 
    								education.get(school).setCon(consList);
    								break;
    							}
    						case 1: 
    							{
    								JOptionPane.showMessageDialog(frame,"Let's hope you know what you're doing!"); 
									break;	
    							}
    						}
    					Object[] options2 = {"yes", "no"};
    					int moreList = JOptionPane.showOptionDialog(frame, "Do you want to make a list for another school?",
    							"More List",
    							JOptionPane.YES_NO_CANCEL_OPTION,
    							JOptionPane.QUESTION_MESSAGE,
    							null, options2, options2[1]);
    					switch(moreList)
							{
							case 0:
								{
									JOptionPane.showMessageDialog(frame,"Good!"); 
									break;
								}
							case 1: 
								{
									JOptionPane.showMessageDialog(frame,"Alright! Good luck!"); 
									listing = false;
									break;
								}
							}
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
		public static void educateChoice()
			{	
				Object[] options1 = {"yes", "no"};
				int findList = JOptionPane.showOptionDialog(frame, "Would you like to see the pros and cons list for some schools before you make your decision?",
						"find list",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options1, options1 [1]);
				switch(findList)
					{
					case 0:
						{
							boolean comparing = true; 
							while (comparing)
								{
									Object[] options = new Object [education.size()];
			    					for (int i=0; i< education.size(); i++)
			    						{
			    							options[i]=education.get(i).getName();
			    						}	
			    					int school2 = JOptionPane.showOptionDialog(frame, "Chose a college.",
			    							"School",
			    							JOptionPane.YES_NO_CANCEL_OPTION,
			    							JOptionPane.QUESTION_MESSAGE,
			    							null, options, options[1]);
			    					JOptionPane.showMessageDialog(frame,"Pros: " + education.get(school2).getPro()); 
			    					JOptionPane.showMessageDialog(frame,"Cons: " +  education.get(school2).getCon()); 
			    					
			    					
			    					Object[] options2 = {"yes", "no"};
			    					int moreLists = JOptionPane.showOptionDialog(frame, "Would you like to see more lists?",
			    							"more lists",
			    							JOptionPane.YES_NO_CANCEL_OPTION,
			    							JOptionPane.QUESTION_MESSAGE,
			    							null, options2, options2 [1]);
			    					switch(moreLists)
			    						{
			    							case 0:
			    								{
			    									JOptionPane.showMessageDialog(frame,"Good!"); 
			    									break;
			    								}
			    							case 1: 
			    								{
			    									JOptionPane.showMessageDialog(frame,"Let's hope you know what you're doing!"); 
			    									comparing = false;
			    									break;
			    								}
			    						}
			    							
								}
	    					break;
						}
					case 1: 
						{
							JOptionPane.showMessageDialog(frame,"Okay!"); 
							break;	
						}
					}
			}
		public static void makeAChoice()
			{
				Object[] options = new Object [education.size()];
				for (int e=0; e< education.size(); e++)
					{
						options [e]=education.get(e).getName();
					}	
				
				 finalDecision = JOptionPane.showOptionDialog(frame, "What is your final college choice?",
						"Decision",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, options, options[1]);
				JOptionPane.showMessageDialog(frame, education.get(finalDecision).getName() + " is awesome! Enjoy paying $" + education.get(finalDecision).getTuition() + " for " + education.get(finalDecision).getBestKnownFor() + " in " + education.get(finalDecision).getLocation() + " with " +  education.get(finalDecision).getStudentBodySize() + " of your closest friends!" );
			}
		public static void randomChoice()
			{
				Object[] options1 = {"yes", "no"};
				int happy = JOptionPane.showOptionDialog(frame, "Are you happy with your college choice?",
					"Happy",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, options1, options1[1]);
				switch(happy)
				{
					case 0:
						{
							JOptionPane.showMessageDialog(frame, "Good! Glad to help!");
							break;
						}
					case 1:
						{
							Object[] options2 = {"yes", "no"};
							int computer = JOptionPane.showOptionDialog(frame, "Aw! Would you like the computer to chose for you?",
									"Computer",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null, options2, options2[1]);
							switch(computer)
							{
								case 0:
										{
											education.remove(finalDecision);
											for (int i=0; i< education.size(); i++)
						    					{
						    						int finalFeeling =  education.get(i).getFeeling();
						    						if (finalFeeling < 5)
						    							{
						    								education.remove(i);
						    							} 
						   						} 
											int randomCollege = (int) (Math.random() * education.size());
											JOptionPane.showMessageDialog(frame, education.get(randomCollege).getName() + " is in your future according to this computer! Enjoy paying $" + education.get(randomCollege).getTuition() + " for " + education.get(randomCollege).getBestKnownFor() + " in " + education.get(randomCollege).getLocation() + " with " +  education.get(randomCollege).getStudentBodySize() + " of your closest friends!" );
											break;
										}
								case 1: 
									{
										JOptionPane.showMessageDialog(frame, "Well, you better go do some soul searching");
										break;
									}
			
							}
						}
				}		
		}
	}	










