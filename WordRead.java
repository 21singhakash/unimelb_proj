package word_blend_kt;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
 /**
 * preprocessing &  
 * calculating recall and precision
 **/
public class WordRead {
  public static void main(String[] args) throws IOException {
 
	 
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	  System.out.println("initial" + "Current Time Stamp: " + ts);
	  
	  
	  try {
		  		
			String pathname = "C:\\Users\\Akash Singh\\Desktop\\Data_Science_Subjects\\Sem2_Subjects\\Knowledge_Technologies\\Project\\2019S2-COMP90049_project1-data\\candidates.txt"; 
			String pathname1 = "C:\\Users\\Akash Singh\\Desktop\\Data_Science_Subjects\\Sem2_Subjects\\Knowledge_Technologies\\Project\\2019S2-COMP90049_project1-data\\dict.txt";
					
			File filename = new File(pathname); 
			File filename1 = new File(pathname1);
			
			
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader);
			
			InputStreamReader reader1 = new InputStreamReader(
					new FileInputStream(filename1)); 
			BufferedReader br1 = new BufferedReader(reader1);
			
			
			ArrayList<String> candidates=null, dictionary=null,pot_cad_list=null,blends_list=null;
			String line=null, sufix=null,line_dic=null,dic_word=null,cad_word=null,pot_dic_word=null,blends_line=null;
			int count1 =0;
			float max = 0, similar_val=0;
			
			
			candidates=new ArrayList<String>();
			dictionary=new ArrayList<String>();
			pot_cad_list= new ArrayList<String>();
			blends_list = new ArrayList<String>();
			
			
			
			 do{
				 line = br.readLine();
				 if(line != null)
					 line.trim();
					 candidates.add(line);}
			 while(line != null);
			 
			 do{
				 line_dic = br1.readLine();
				 if(line_dic != null)
					 line_dic.trim();
					 dictionary.add(line_dic);}
			while(line_dic != null);
			  
			 
				int stringLength=0;
				String string;
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-2;j++) {					
							if(string.charAt(j+1)==string.charAt(j)) {				
								if(string.charAt(j+2)==string.charAt(j)) {
									candidates.remove(i);
									i--;
									break;
								}
								j++;
							}					
						}
					}

					}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-2;j++) {					
							if(string.charAt(j+1)==string.charAt(j)) {				
								if(string.charAt(j+2)==string.charAt(j)) {
									dictionary.remove(i);
									i--;
									break;
								}
								j++;
							}					
						}
					}

					}
				
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null) {
						stringLength=string.length();
							int j =0;				
							if(string.charAt(j+1)==string.charAt(j)) {				
								
									candidates.remove(i);
									i--;
				    	}					
						
					}

					}
				
				
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-3;j++) {				
							if(string.charAt(j+2)==string.charAt(j)) {	
								if(string.charAt(j+3)==string.charAt(j+1)) {
									candidates.remove(i);
									i--;
									break;
								}
								j+=2;						
							}					
						}
					}
				}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-3;j++) {				
							if(string.charAt(j+2)==string.charAt(j)) {	
								if(string.charAt(j+3)==string.charAt(j+1)) {
									dictionary.remove(i);
									i--;
									break;
								}
								j+=2;						
							}					
						}
					}
				}
				
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-5;j++) {				
							if(string.charAt(j+3)==string.charAt(j)) {
								if(string.charAt(j+4)==string.charAt(j+1)) {
									if(string.charAt(j+5)==string.charAt(j+2)) {
										candidates.remove(i);
										i--;
										break;
									}
								}					
							}
						}
					}
				}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null) {
						stringLength=string.length();
						for(int j=0;j<stringLength-5;j++) {				
							if(string.charAt(j+3)==string.charAt(j)) {
								if(string.charAt(j+4)==string.charAt(j+1)) {
									if(string.charAt(j+5)==string.charAt(j+2)) {
										dictionary.remove(i);
										i--;
										break;
									}
								}					
							}
						}
					}
				}
				
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null && string.matches("(.*)ing(.*)")) {
						
						candidates.remove(i);
									i--;
							}
					}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null && string.matches("(.*)ing(.*)")) {
						
						dictionary.remove(i);
									i--;
							}
					}
								
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null && string.matches("(.*)ly(.*)")) {
						
						candidates.remove(i);
									i--;
							}
					}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null && string.matches("(.*)ly(.*)")) {
						
						dictionary.remove(i);
									i--;
							}
					}
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null && string.matches("(.*)ed(.*)")) {
						
						candidates.remove(i);
									i--;
							}
					}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null && string.matches("(.*)ed(.*)")) {
						
						dictionary.remove(i);
									i--;
							}
					}
				
				
				for(int i=0;i<candidates.size();i++) {
					 string= candidates.get(i);		
					if (string != null && string.matches("(.*)ions(.*)")) {
						
						candidates.remove(i);
									i--;
							}
					}
				
				for(int i=0;i<dictionary.size();i++) {
					 string= dictionary.get(i);		
					if (string != null && string.matches("(.*)ions(.*)")) {
						
						dictionary.remove(i);
									i--;
							}
					}
				System.out.println("9th dictionary.size" + dictionary.size());
				System.out.println("3rd.d" + candidates.size());
				
				int number=0;
				for(int i = 0; i<candidates.size(); i++) {
					number++;
					System.out.println(number);
					cad_word = candidates.get(i);
					if(cad_word!=null && cad_word.length()>2 ) {
						if(cad_word.length()<=7) {
						sufix = candidates.get(i).substring(2);}
						
						if(cad_word.length()>7) {
							sufix = candidates.get(i).substring(4);}
								
				
				max =0;
				for(int j=0;j<dictionary.size();j++) {
					if(dictionary.get(j)!=null) {
					dic_word = dictionary.get(j);
				
				JaroDis jwd=new JaroDis();
				
				similar_val=jwd.JaroSimilarity(sufix, dic_word);
				count1 = count1 +1;
				
				if(max<similar_val) {
					max = similar_val;
					pot_dic_word = dic_word;
					System.out.println("6th " + " cad_word.length: & name:  " + cad_word.length() + " " + cad_word + "pot_dic_word.length: & name:  " + pot_dic_word.length() + " " + dic_word);
					System.out.println("7th " + " max similarity value:  " + max + " similarity value:  " + similar_val + " cad_word:  " + cad_word + " dic_word:  " + pot_dic_word );
					
				}
				
				
					}
				}
				if((cad_word.length()-pot_dic_word.length())<=4) {
					System.out.println("8th" + "cad_word.length:" + cad_word.length() + "pot_dic_word.length:" + pot_dic_word.length());
					System.out.println("9th " + " pot_cad_word name:  " + " " + cad_word + "pot_dic_word name:  " + " " + dic_word);
					if(!pot_cad_list.contains(cad_word)&&(cad_word.length()>3)) {
						
					pot_cad_list.add(cad_word);}
				}
					}
				}
								
				System.out.println("pot_cad_list.size() :"+pot_cad_list.size());
				for(int j=0;j<pot_cad_list.size();j++) {
					 System.out.println(pot_cad_list.get(j));
				 }
				
				 System.out.println();
				 System.out.println(pot_cad_list.size());
				 double tpfp=pot_cad_list.size();

					try {
						
						String pathname3 = "C:\\Users\\Akash Singh\\Desktop\\Data_Science_Subjects\\Sem2_Subjects\\Knowledge_Technologies\\Project\\2019S2-COMP90049_project1-data\\trueblend.txt"; 
						File filename3 = new File(pathname3); 
						InputStreamReader reader3 = new InputStreamReader(
								new FileInputStream(filename3)); 
						BufferedReader br3 = new BufferedReader(reader3); 

						 blends_list=new ArrayList<String>();
						 
						 do{
							 blends_line = br3.readLine();
							 if(blends_line != null)
								 blends_line.trim();			 
							 blends_list.add(blends_line);			 
						 }
						 while(blends_line != null);

						} catch (Exception e) {
							e.printStackTrace();
						
						}
					
					double trueblend=0;
					 
					 File writename = new File("C:\\Users\\Akash Singh\\Desktop\\results18.txt"); 
					 
					 writename.createNewFile(); 
					 BufferedWriter out = new BufferedWriter(new FileWriter(writename));
					 for(int j=0;j<pot_cad_list.size();j++) {
						 if(blends_list.contains(pot_cad_list.get(j))) {
							 trueblend++;
							out.write(pot_cad_list.get(j)+trueblend); 
							out.write("\n");
						 }
						 out.write(pot_cad_list.get(j)); 
						 out.write("\n");
				    }
						out.flush(); 
						out.close();
					 
					 double precision=trueblend/tpfp;
					 System.out.println(precision);
					 
					 double recall=trueblend/151;
					 System.out.println(recall);
					
								
					 System.out.println("count1 " + count1);			
			} catch (Exception e) {
				e.printStackTrace();
			
			}
	  
	  Timestamp ts1 = new Timestamp(System.currentTimeMillis());
	  System.out.println("11th & " + "Current Time Stamp: " + ts1);
  }
}
