import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSX_358_HW1_16103055 {

	static void summary(BufferedWriter bw,int a,int b,int c,int d,int f,int max,double total,int count) throws IOException {
	
	//Writing the summary to output file	
	bw.newLine();
	bw.write("Summary Report");
	bw.newLine();
	bw.newLine();
	bw.write("Average total point percent of all students:"+Math.round(total/count)+"%");
	bw.newLine();
	bw.newLine();
	bw.write("Number of A's ="+a);
	bw.newLine();
	bw.write("Number of B's ="+b);
	bw.newLine();
	bw.write("Number of C's ="+c);
	bw.newLine();
	bw.write("Number of D's ="+d);
	bw.newLine();
	bw.write("Number of F's ="+f);
	bw.newLine();bw.newLine();
	bw.write("Maximum Points:"+max);
	
	bw.close();
	
	}
	static void write(BufferedWriter bw,int data[],int sum,int points,double pct,char gr) throws IOException {
		
		
		//Writing data to output file with spaces
	
		if(data[0]/10000000<1)
		{String l = "0"+Integer.toString(data[0]);
	bw.write(l+"  ");}
	else
		bw.write(data[0]+"  ");
	for(int i=1;i<12;i++) {
		if(data[i]/10<1)
			bw.write(" "+data[i]+" ");
		else
		bw.write(data[i]+" ");}
	bw.write(" ");
	bw.write(sum+"  ");
	sum=0;
	bw.write(data[12]+"  ");
	bw.write(" "+data[13]+"  ");
	if(data[14]/10<1)
		bw.write(" "+data[14]+"  ");
	else
		bw.write(data[14]+"  ");
	bw.write(points+"  ");
	points=0;
	bw.write(" "+Math.round(pct)+"  ");
	bw.write(" "+gr);
	bw.newLine();
	}


	static void ReadandPrint(BufferedWriter bw,BufferedReader br,int data[],int max,int count,double total) throws IOException {
		String thisLine=null;
		int a=0,b=0,c=0,d=0,f=0;
		while((thisLine=br.readLine())!=null)
	
	 {
	 double pct;
	 char gr;
	 int points=0,sum=0;
		count++;
		
		
		//Tokenizing a single input line and parsing it to integer array
		StringTokenizer tk = new StringTokenizer(thisLine);
		for(int j=0;j<15;j++) {
	    String s = tk.nextToken();
	    data[j]=Integer.parseInt(s);
		}
		for(int j=2;j<12;j++)
			sum+=data[j];
		for(int j=1;j<15;j++)
			points+=data[j];
		
		if(points>max)
			max=points;
		pct = points/4.2;
		total += pct;
		
		
		//Counting the number of students with each respective grade and forming summary
		if(Math.round(pct)>=90)
			{gr='A';
			a++;
			}
		else if(Math.round(pct)<90&&Math.round(pct)>=78)
			{gr='B';
			b++;
			}
		else if(Math.round(pct)<=77&&Math.round(pct)>=62)
			{gr='C';
			c++;
			}
		else if(Math.round(pct)<62&&Math.round(pct)>=46)
			{gr='D';
			d++;
			}
		else
			{gr='F';
			f++;
			}
		write(bw,data,sum,points,pct,gr);
		}
		
		//Writing summary to output file
		summary(bw,a,b,c,d,f,max,total,count);
		br.close();
}
	

	public static void main(String[] args) throws IOException {
	
	
		
		FileReader fr=null;
		FileWriter fw=null;
		try {
		
			int data[]=new int [15];
			fr = new FileReader("/home/nagar/Desktop/java lab/lab 1/HW1-data.txt");
			BufferedReader br=new BufferedReader(fr);
			fw=new FileWriter("/home/nagar/Desktop/HW1-output-16103055.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("Stdnt ID  ---------Assignments------------  Tot  Mi  Fin  CL  Pts  Pct  Gr");
			bw.newLine();
			bw.write("--------  --------------------------------  ---  --  ---  --  ---  ---  --");
			bw.newLine();
			int max=0,count=0;
			double total=0;
			ReadandPrint(bw,br,data,max,count,total);
			bw.close();
			
			
			
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		

	}

}

