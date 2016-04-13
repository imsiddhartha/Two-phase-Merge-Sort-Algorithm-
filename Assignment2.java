import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Assignment2 {
/*
 * 1. ­­meta_file ​
<Metadata file path> i.e metadata file containing the metadata 
information. 
2. ­­input_file​
 <Input file path> i.e input file containing the raw records.  
3. ­­output_file​
 <output file path> i.e. Ouput file containing sorted records 
4. ­­output_column​
 <list of columns that will be present in output file separated by 
comma> 
5. ­­sort_column​
 <list of columns that will be used to sort the records> 
6. ­­mm​
 <size for main memory in MB> Main memory size (in MB) 
7. ­­order ​
<asc/desc> i.e. asc means to sort in ascending order and desc means to sort 
in descending orde
 * */
	
	class Item
	{
		List<String> data;
		int fileno;
	}
	 class AscComp implements Comparator<List<String>>
	 {
	     @Override
	     public int compare(List<String> l1,List<String> l2)
	     {
	    	 int col_no=0,size=all_cols.size();
//	    	 j=all_cols.indexOf(sort_cols.get(col_no));// jispe sort marna h woh col ka index
	    	 String type;
	    	 String str1="",str2="";
	    	// System.out.println("Inside Asc comparator");
        	 str1=l1.get(0);
        	 str2=l2.get(0);
	    	 String st1[]=str1.split(",", size);
    		 String st2[]=str2.split(",", size);
	         for(int i=0;i<col_order.size();)
	         {

	        	 col_no=all_cols.indexOf(sort_cols.get(i));
	        	 type=type_cols.get(col_no);
//	        	 System.out.println("String 1 "+str1);
//	        	 System.out.println("String 2 "+str2);
//	        	 System.out.println("type "+type);
	        	 if(type.equalsIgnoreCase("char"))
	        	 {
	        		
	        		 if(st1[col_no].equals(st2[col_no]))
	        		 {
	        			 i++;
	        			 continue;
		             } 
		             else
		                 return str1.compareTo(str2);
	        	 }else if(type.equalsIgnoreCase("int"))
	        	 {
	        		
	        		 int it1=Integer.parseInt(st1[col_no]);
	        		 int it2=Integer.parseInt(st2[col_no]);
	        		 if(it1==it2)
	        		 {
	        			 i++;
	        			 continue;
	        		 }
	        		 else
	        			 return it1-it2;
	        	 }else if(type.equalsIgnoreCase("date"))
	        	 {
	        		
	        		 String s1[]=st1[col_no].split("/", 3);
	        		 String s2[]=st2[col_no].split("/", 3);
	        		 
	        		 if(s1[2].equalsIgnoreCase(s2[2]))
	        		 {
	        			 if(s1[1].equalsIgnoreCase(s2[1]))
	        			 {
	        				 if(s1[0].equalsIgnoreCase(s2[0]))
	        				 {
	        					 i++;
	        					 continue;
	        				 }
	        				 else
	        					 return s1[0].compareTo(s2[0]); 
	        			 }
	        			 else
	        				 return s1[1].compareTo(s2[1]);
	        		 }else
	        			 return s1[2].compareTo(s2[2]);
	        	 }
	        	 
	         }
	         return 0;
	     }
	 }
	 class DescComp implements Comparator<List<String>>
	 {
	     @Override
	     public int compare(List<String> l1,List<String> l2)
	     {
	    	 int col_no=0,size=all_cols.size();
//	    	 j=all_cols.indexOf(sort_cols.get(col_no));// jispe sort marna h woh col ka index
	    	 String type;
	    	 String str1="",str2="";
	    	// System.out.println("Inside Asc comparator");
        	 str1=l1.get(0);
        	 str2=l2.get(0);
	    	 String st1[]=str1.split(",", size);
    		 String st2[]=str2.split(",", size);
	         for(int i=0;i<col_order.size();)
	         {

	        	 col_no=all_cols.indexOf(sort_cols.get(i));
	        	 type=type_cols.get(col_no);
//	        	 System.out.println("String 1 "+str1);
//	        	 System.out.println("String 2 "+str2);
//	        	 System.out.println("type "+type);
	        	 if(type.equalsIgnoreCase("char"))
	        	 {
	        		
	        		 if(st1[col_no].equals(st2[col_no]))
	        		 {
	        			 i++;
	        			 continue;
		             } 
		             else
		                 return (-1*str1.compareTo(str2));
	        	 }else if(type.equalsIgnoreCase("int"))
	        	 {
	        		
	        		 int it1=Integer.parseInt(st1[col_no]);
	        		 int it2=Integer.parseInt(st2[col_no]);
	        		 if(it1==it2)
	        		 {
	        			 i++;
	        			 continue;
	        		 }
	        		 else
	        			 return -1*(it1-it2);
	        	 }else if(type.equalsIgnoreCase("date"))
	        	 {
	        		
	        		 String s1[]=st1[col_no].split("/", 3);
	        		 String s2[]=st2[col_no].split("/", 3);
	        		 
	        		 if(s1[2].equalsIgnoreCase(s2[2]))
	        		 {
	        			 if(s1[1].equalsIgnoreCase(s2[1]))
	        			 {
	        				 if(s1[0].equalsIgnoreCase(s2[0]))
	        				 {
	        					 i++;
	        					 continue;
	        				 }
	        				 else
	        					 return (-1*s1[0].compareTo(s2[0])); 
	        			 }
	        			 else
	        				 return (-1*s1[1].compareTo(s2[1]));
	        		 }else
	        			 return (-1*s1[2].compareTo(s2[2]));
	        	 }
	        	 
	         }
	         return 0;
	     }
	 }
	 
	 class PqDescComp implements Comparator<Item>
	 {
	     @Override
	     public int compare(Item I1,Item I2)
	     {
	    	 int col_no=0,size=all_cols.size();
//	    	 j=all_cols.indexOf(sort_cols.get(col_no));// jispe sort marna h woh col ka index
	    	 String type;
	    	 String str1="",str2="";
	    	// System.out.println("Inside Dsc comparator");
        	 str1=I1.data.get(0);
        	 str2=I2.data.get(0);
        	 
	    	 String st1[]=str1.split(",", size);
    		 String st2[]=str2.split(",", size);
	         for(int i=0;i<col_order.size();)
	         {

	        	 col_no=all_cols.indexOf(sort_cols.get(i));
	        	 type=type_cols.get(col_no);
//	        	 System.out.println("String 1 "+str1);
//	        	 System.out.println("String 2 "+str2);
//	        	 System.out.println("type "+type);
	        	 if(type.equalsIgnoreCase("char"))
	        	 {
	        		
	        		 if(st1[col_no].equals(st2[col_no]))
	        		 {
	        			 i++;
	        			 continue;
		             } 
		             else
		                 return (-1*str1.compareTo(str2));
	        	 }else if(type.equalsIgnoreCase("int"))
	        	 {
	        		
	        		 int it1=Integer.parseInt(st1[col_no]);
	        		 int it2=Integer.parseInt(st2[col_no]);
	        		 if(it1==it2)
	        		 {
	        			 i++;
	        			 continue;
	        		 }
	        		 else
	        			 return -1*(it1-it2);
	        	 }else if(type.equalsIgnoreCase("date"))
	        	 {
	        		
	        		 String s1[]=st1[col_no].split("/", 3);
	        		 String s2[]=st2[col_no].split("/", 3);
	        		 
	        		 if(s1[2].equalsIgnoreCase(s2[2]))
	        		 {
	        			 if(s1[1].equalsIgnoreCase(s2[1]))
	        			 {
	        				 if(s1[0].equalsIgnoreCase(s2[0]))
	        				 {
	        					 i++;
	        					 continue;
	        				 }
	        				 else
	        					 return (-1*s1[0].compareTo(s2[0])); 
	        			 }
	        			 else
	        				 return (-1*s1[1].compareTo(s2[1]));
	        		 }else
	        			 return (-1*s1[2].compareTo(s2[2]));
	        	 }
	        	 
	         }
	         return 0;
	     }
	 }
	 
	 class PqAscComp implements Comparator<Item>
	 {
	     @Override
	     public int compare(Item I1,Item I2)
	     {
	    	 int col_no=0,size=all_cols.size();
//	    	 j=all_cols.indexOf(sort_cols.get(col_no));// jispe sort marna h woh col ka index
	    	 String type;
	    	 String str1="",str2="";
	    	// System.out.println("Inside Asc comparator");
        	 str1=I1.data.get(0);
        	 str2=I2.data.get(0);
	    	 String st1[]=str1.split(",", size);
    		 String st2[]=str2.split(",", size);
	         for(int i=0;i<col_order.size();)
	         {

	        	 col_no=all_cols.indexOf(sort_cols.get(i));
	        	 type=type_cols.get(col_no);
//	        	 System.out.println("String 1 "+str1);
//	        	 System.out.println("String 2 "+str2);
//	        	 System.out.println("type "+type);
	        	 if(type.equalsIgnoreCase("char"))
	        	 {
	        		
	        		 if(st1[col_no].equals(st2[col_no]))
	        		 {
	        			 i++;
	        			 continue;
		             } 
		             else
		                 return str1.compareTo(str2);
	        	 }else if(type.equalsIgnoreCase("int"))
	        	 {
	        		
	        		 int it1=Integer.parseInt(st1[col_no]);
	        		 int it2=Integer.parseInt(st2[col_no]);
	        		 if(it1==it2)
	        		 {
	        			 i++;
	        			 continue;
	        		 }
	        		 else
	        			 return it1-it2;
	        	 }else if(type.equalsIgnoreCase("date"))
	        	 {
	        		
	        		 String s1[]=st1[col_no].split("/", 3);
	        		 String s2[]=st2[col_no].split("/", 3);
	        		 
	        		 if(s1[2].equalsIgnoreCase(s2[2]))
	        		 {
	        			 if(s1[1].equalsIgnoreCase(s2[1]))
	        			 {
	        				 if(s1[0].equalsIgnoreCase(s2[0]))
	        				 {
	        					 i++;
	        					 continue;
	        				 }
	        				 else
	        					 return s1[0].compareTo(s2[0]); 
	        			 }
	        			 else
	        				 return s1[1].compareTo(s2[1]);
	        		 }else
	        			 return s1[2].compareTo(s2[2]);
	        	 }
	        	 
	         }
	         return 0;
	     }
	 }
	 
	 static List<List<String>> data = new ArrayList<>();
    
    public static List<Integer> col_order = new ArrayList<Integer>();
    public static List<Integer> op_col_order = new ArrayList<Integer>();
    public static List<String> all_cols = new ArrayList<String>();
    public static List<String> op_cols = new ArrayList<String>();
    public static List<String> type_cols = new ArrayList<String>();
    public static List<String> sort_cols = new ArrayList<String>();
    
    static Comparator<Item> com1 = new Assignment2().new PqAscComp();
    static Comparator<Item> com2= new Assignment2().new PqDescComp();
    public static PriorityQueue<Item> pq;
    public static void main(String args[]) throws Exception
    {
    	//java -Xmx1024M -Xms512M Assignment2
    	System.out.println("Called");
    	long start = System.currentTimeMillis();
    	// String meta="/home/siddharth/Downloads/IIIT/SEM2/DB/Assignments/Assignment2/DB Generator/metadata.txt";
    	 String meta = args[0];
    	 String ipfile = args[1];
         String opfile = args[2];
         String opcol=args[3];
         String sortcol=args[4];
         String mems = args[5];
         String order = args[6];
//    	 String ipfile = "/home/siddharth/Downloads/IIIT/SEM2/DB/Assignments/Assignment2/DB Generator/input.txt";
//    	 String mems = "100";
//    	 String opcol="col0,col1";
// 	     String sortcol="col0,col2";
// 	     String order = "desc";
//       String opfile = "";
         System.out.println(meta);
         System.out.println(ipfile);
         System.out.println(opfile);
         System.out.println(opcol);
         System.out.println(sortcol);
         System.out.println(mems);
         System.out.println(order);
         BufferedReader br = new BufferedReader(new FileReader(meta));
         String read=br.readLine();
         int rsize=0;
         int mem_size = Integer.parseInt(mems);
         
         mem_size = (int) (0.1*1000000*mem_size);	//restrict the heap size to 1/10 times memory specified in MB. 
         
         while(read!=null)
         {
             String cname = read.substring(0,read.indexOf(","));
             String ctype = read.substring(read.indexOf(",")+1);
             cname=cname.trim();
             ctype=ctype.trim();
             all_cols.add(cname);
             if(ctype.equalsIgnoreCase("int"))
            	 rsize+=4;
             else if(ctype.equalsIgnoreCase("date"))
            	 rsize+=20;						//each char 2 byte!!
             else if(ctype.contains("char"))
             {
//            	 System.out.println("Size of char : "+ctype.substring(ctype.indexOf('(')+1, ctype.indexOf(')')));
            	 rsize=rsize+2*Integer.parseInt(ctype.substring(ctype.indexOf('(')+1, ctype.indexOf(')')));
            	 ctype=ctype.substring(0,ctype.indexOf('('));
             }
             type_cols.add(ctype);
             read=br.readLine();
         }
         br.close();
         
         // System.out.println("record size= "+rsize+" bytes");
         StringTokenizer st = new StringTokenizer(opcol,",");
         while(st.hasMoreElements())
         {
             op_cols.add(st.nextToken());
         }
         st = new StringTokenizer(sortcol,",");
         while(st.hasMoreElements())
         {
             sort_cols.add(st.nextToken());
         }
       //Read column nums of cols which appears in sortcol
         for(int i=0;i<sort_cols.size();i++)
         {
             String cur = sort_cols.get(i);
             boolean flag=false;
             for(int j=0;j<all_cols.size();j++)
             {
                 if(cur.equals(all_cols.get(j)))
                 {
                	 //System.out.println("Equal "+cur+" "+j);
                     col_order.add(j);
                     flag=true;
                     break;
                 }
             }
             if(!flag)
             {
            	 System.out.println("ERRORR!!!Col does not exist");
            	 System.exit(0);
             }
         }
         for(int i=0;i<op_cols.size();i++)
         {
             String cur = op_cols.get(i);
             boolean flag=false;
             for(int j=0;j<all_cols.size();j++)
             {
                 if(cur.equals(all_cols.get(j)))
                 {
                	 //System.out.println("Equal "+cur+" "+j);
                     op_col_order.add(j);
                     flag=true;
                     break;
                 }
             }
             if(!flag)
             {
            	 System.out.println("ERRORR!!!Col does not exist");
            	 System.exit(0);
             }
         }  
//         System.out.println("Size List and op order");
//         System.out.println(op_cols);
//         System.out.println(op_col_order);
         BufferedReader br1 = new BufferedReader(new FileReader(ipfile));
         read=br1.readLine();
         //System.out.println(read);
        // System.out.println("actual size a record"+read.getBytes().length+" bytes");
         rsize=read.getBytes().length;
         System.out.println("record size= "+rsize+" bytes");
         int loc_count=0,filecount=0,tot_rec=0;
         
         int readlimit=(int)mem_size/rsize;			// no of lines that can be readed
         
//         System.out.println("Limit= "+readlimit);
//         System.out.println("rsize= "+rsize);
//         System.out.println("Mem= "+mem_size);
//         System.out.println(data);
         long t1=System.currentTimeMillis();
         while(loc_count<readlimit&&read!=null)
         {
             String cur_line = read;
             st = new StringTokenizer(cur_line);
             List<String> loc_list = new ArrayList<>();
             while(st.hasMoreElements())
             {
                 loc_list.add(st.nextToken());
             }
             data.add(loc_list);
            
             loc_count++;
             read=br1.readLine();
             tot_rec++;
             if(readlimit==loc_count||read==null)
             {
                 //Sort the all_data
                  if(order.equals("asc"))
                  {
                	  //System.out.println("Asc sort");
                	  Collections.sort(data,new Assignment2().new AscComp());
                  }
                  else
                  {
                	 // System.out.println("Dsc sort");
                	  Collections.sort(data,new Assignment2().new DescComp());
                  }
                 write_intofile(filecount,opfile);
                 loc_count=0;
                 filecount++;
             }
         }
         br1.close();
         if(data.size()>0)
         {
        	 if(order.equals("asc"))
             {
           	  Collections.sort(data,new Assignment2().new AscComp());
             }
             else
             {
           	  Collections.sort(data,new Assignment2().new DescComp());
             }
        	 write_intofile(filecount,opfile);
        	 filecount++;
         }
         long t2=System.currentTimeMillis();
         
        System.out.println("Total files "+filecount);
        System.out.println("Total records "+tot_rec);
        System.out.println("Spilt time "+(t2-t1)+"ms");
        if((int)(tot_rec/readlimit)*rsize>mem_size)			//No of files>850 then not efficient
        {
        	System.out.println("Insufficient Memory!!!!");
        	deletefiles(filecount);
        	System.exit(0);
        }
        t1=System.currentTimeMillis();
        if(order.equals("asc"))
        	Asc(filecount,mem_size,opfile,rsize);
        else
        	Desc(filecount,mem_size,opfile,rsize);
        
        long end = System.currentTimeMillis();
        t2=System.currentTimeMillis();
        deletefiles(filecount);
        System.out.println("Merge time "+(t2-t1)+"ms");
        System.out.println((end - start) + " ms"); 
        System.out.println("ENDED");
    }

	private static void deletefiles(int filecount) {
		// TODO Auto-generated method stub
		try {
			
			for(int i=0;i<filecount;i++)
			{
				boolean success = (new File
				         ("tmp/file"+i)).delete();
			}
		} catch (Exception e) {
			System.out.println("In deleeting fiels");
			// TODO: handle exception
		}
	}

	private static void Desc(int filecount, int mem_size, String opfile,int rsize) {
		// TODO Auto-generated method stub
		try {
			
			
			pq =  new PriorityQueue<Item>(filecount+2,com2);
			BufferedReader br[] = new BufferedReader[filecount+2];
			
			
		 	  //BufferedWriter bw = new BufferedWriter(fw);
			// int block_size = (int)mem_size/(filecount*rsize*2);
			int block_size = (int)(mem_size-(filecount*rsize))/2;
			System.out.println("one line of all file requires:"+filecount*rsize+" bytes");
			System.out.println("mem size:"+mem_size+" bytes");
			System.out.println("block size:"+block_size+" bytes");
			 readfirtline(br,filecount);
			 while(!pq.isEmpty())
			 {
				 Item it=pq.poll();
				 data.add(it.data);
				 if(data.size()*rsize>=block_size)			//blocsize is in bytes so jb tk pura block fill nh hota tb tk
				 {
				 	//System.out.println("data size:"+data.size()*rsize);
					 long t1=System.currentTimeMillis();
				 	CreateFile(opfile);
				 	long t2=System.currentTimeMillis();
				 	//System.out.println((t2-t1)+" ms time to write one block");
				 }
				 readNextLine(br,it.fileno);
			 }
			 if(data.size()>0)
				 {
					//System.out.println("data size:"+data.size());
				 	CreateFile(opfile);
				}
			 //bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void Asc(int filecount, int mem_size, String opfile,int rsize) {
		// TODO Auto-generated method stub
		try {
			pq =  new PriorityQueue<Item>(filecount+2,com1);
			BufferedReader br[] = new BufferedReader[filecount+2];
			int block_size = (int)(mem_size-(filecount*rsize))/2;			//if memory size is 10MB for pgrm,then in memory i have to fill one line from each file,so reamining can consider as a block to write!
																			//divided by 2 for to be on safe side
			 System.out.println("one line of each file requires:"+filecount*rsize+" bytes");
			 System.out.println("mem size:"+mem_size+" bytes");
			 System.out.println("block size:"+block_size+" bytes");
			 readfirtline(br,filecount);
			 while(!pq.isEmpty())
			 {
				 Item it=pq.poll();
				 data.add(it.data);
				if(data.size()*rsize>=block_size)
				{
					//System.out.println("data size:"+data.size());
					long t1=System.currentTimeMillis();
				 	CreateFile(opfile);
				 	long t2=System.currentTimeMillis();
				 	//System.out.println((t2-t1)+" ms time to write one block");
				}
				 readNextLine(br,it.fileno);
			 }
			 if(data.size()>0)
				 {
					//System.out.println("data size:"+data.size());
				 	CreateFile(opfile);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void CreateFile(String opfile) {
		// TODO Auto-generated method stub
		
		String output=opfile;
        //System.out.println(output);
        
		try {
			File file = new File(opfile);
			if (!file.exists()) {
		 	       file.createNewFile();
		 	     }

		 	 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);

		 	  int le=op_col_order.size();
		 	  String str="";int size=data.size();int wcount=0;
		 	  StringBuilder sb=new StringBuilder();
		 	  for(int i=0;i<size;i++)
		 	  {
		 	            List<String> loc_list = new ArrayList<>(data.get(i));
		 	            for(int j=0;j<loc_list.size();j++)
		 	            {
		 	            	String s[]=loc_list.get(j).split(",");
		 	            	
		 	            	for(int p=0;p<le;p++)
		 	            	{
		 	            		if(p!=le-1)
		 	            		{
		 	            			//str=str+s[op_col_order.get(p)]+",";
		 	            			sb.append(s[op_col_order.get(p)]+",");
		 	            		}
		 	            		else
		 	            		{
		 	            			//str=str+s[op_col_order.get(p)]+'\n';
		 	            			sb.append(s[op_col_order.get(p)]+"\n");
		 	            		}
		 	            	}
		 	            	//System.out.println("op "+str);
		 	                if(size/2 >0 &&i+1%(size/2)==0)
		 	                {
		 	                	bw.write(sb.toString());
		 	                	sb.setLength(0);
		 	                	str="";
		 	                	wcount++;
		 	                }
		 	                else
		 	                {
		 	                	bw.write(sb.toString());
		 	                	sb.setLength(0);
		 	                	str="";
		 	                	wcount++;	
		 	                }
		 	            }
		 	  }
		 	  	if(sb.length()>0)
		 	  	{
		 	  		bw.write(sb.toString());
		 	      	//str="";
		 	      	sb.setLength(0);
		 	      	wcount++;
		 	  	}
		 	  	//System.out.println("No of writes="+wcount);
		 	        bw.close();
		 	        data.clear();
			
		} catch (Exception e) {
			System.out.println("In creating main file");
			e.printStackTrace();
			// TODO: handle exception
		}
   	
	}

	private static void readNextLine(BufferedReader[] br, int i) {
		// TODO Auto-generated method stub
		
		try {
			String s="";
			if((s=br[i].readLine())!=null)
			{
				Item it=new Assignment2().new Item();
				it.data=new ArrayList<String>();
				it.data.add(s);
				it.fileno=i;
				pq.add(it);
			}
			else
			{
					br[i].close();//System.out.println("File"+i+" Completed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readfirtline(BufferedReader[] br, int filecount) {
		// TODO Auto-generated method stub
		for(int i=0;i<filecount;i++)
		{
			try {
				br[i]=new BufferedReader(new FileReader("tmp/file"+i));
				String s="";
				if((s=br[i].readLine())!=null)
				{
					Item it=new Assignment2().new Item();
					it.data=new ArrayList<String>();
					it.data.add(s);
					it.fileno=i;
					pq.add(it);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("In reading next line");
				e.printStackTrace();
			}
		}
	}

	private static void write_intofile(int filecount,String op) {
		// TODO Auto-generated method stub

		//String output="/home/siddharth/Downloads/IIIT/SEM2/DB/Assignments/Assignment2/tmp";
		 //output=output+"file"+filecount;
		File theDir = new File("tmp");
		
		if (!theDir.exists()) {
		   try{
		        theDir.mkdir();
		    } 
		    catch(SecurityException se){
		        //handle it
		    	System.out.println("In creating new dicrectory");
		    	se.printStackTrace();
		    }   
		}
		String output="tmp/file"+filecount;
         File file = new File(output);
    try {
    	if (!file.exists()) {
    	       file.createNewFile();
    	     }

    	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	  BufferedWriter bw = new BufferedWriter(fw);
    	  StringBuilder sb=new StringBuilder();
    	  for(int i=0;i<data.size();i++)
    	  {
    	            List<String> loc_list = new ArrayList<>(data.get(i));
    	            for(int j=0;j<loc_list.size();j++)
    	            {
    	            	//sb.append(loc_list.get(j)+'\n');
   	                bw.write(loc_list.get(j));
//    	                if(j!=loc_list.size()-1)
//    	                    bw.write("  ");
    	            }
   	            bw.write("\n");
    	  }
    	  //bw.write(sb.toString());
    	        bw.close();
    	        data.clear();

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} 	
	}
    
}