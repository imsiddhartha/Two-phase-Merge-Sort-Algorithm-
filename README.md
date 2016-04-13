Implemented two-­phase merge sort algorithm in java to sort large number of records with the following specifications: 

1.Metadata information: 

	a. This information will be provided in a file as an input to your algorithm and will 
	contain the information about the columns and their data type.
	 
	b. The number of columns can vary from 1 to 20. 

	c. The data type for the column can be String, Integer or Date.
	
		i. Date​: It will be represent by date. e.g. col1,date or mycol,date etc. 
		
		ii. String​:It will be represented by char(<length of string>) i.e. every string will be of same size defined by <length of 			string> e.g. cols,char(10) or column,char(11) etc. 
		
		iii.Integer​: e.g.  It will be represented by int. col1,int or mycol,int etc. 

2.Input Data​: 

	a. Each record will start from newline. 

	b. Column values will be separated by comma. 

	c. String will comprise of alphanumeric characters only i.e. A­Za­z0­9 

	d. Date will be in the format DD/MM/YYYY format. 
	
3.Output Data: 

	a. Output file will contain the columns that you have specified as an argument to your algorithm. So, the number of columns can differ in output file as compared to input file.

	b. Each record will be separated by new line and column values by comma 
	(similar to input data format).

4.Sorting columns: 

	a. If the sorting needs to be done using multiple columns then if the values of the first column is same, you need to sort on the basis of the second and so on. 

	b. If the value of all the columns mentioned for sorting is same, for such records the order in the output should be maintained as the order in the input file. 
	
5.Different file formats: 

	1. metainfo.txt: 
		
		<column name 1>,<datatype of the column> 
		<column name 2>,<datatype of the column> 
		<column name 3>,<datatype of the column> 
		...... 
		<column name n>,<datatype of the column> 
	
	2. Input File: 
		
		<value1 of col1>,<value1 of column>,<value1 of col3>,<value1 of col2> 
		<value1 of col1>,<value1 of column>,<value1 of col3>,<value1 of col2> 
		<value1 of col1>,<value1 of column>,<value1 of col3>,<value1 of col2>
		
6.Command Line Flags:
	1. ­­meta_file ​
		<Metadata file path> i.e metadata file containing the metadata information. 

	2. ­­input_file​
		<Input file path> i.e input file containing the raw records.  
	
	3. ­­output_file​
	
		 <output file path> i.e. Ouput file containing sorted records 
	
	4. ­­output_column​
	
		 <list of columns that will be present in output file separated by comma> 
	5. ­­sort_column​
	
	 <list of columns that will be used to sort the records> 

	6. ­­mm​

		 <size for main memory in MB> Main memory size (in MB) 
	
	7. ­­order ​
		
		<asc/desc> i.e. asc means to sort in ascending order and desc means to sort in descending order

Example:

java Assingment2 ­­metafile.txt /home/user/mydir/db/input.txt /home/user/mydir/db/output.txt col1,col2,col3,column4 ­col2,col1  50 ­­desc

