package testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

class Bank
{
	double rateOfInterest()
	{
		return 0;
	}
	
}


class SBI extends Bank
{
	double rateOfInterest()
	{
		return 10.5;
	}
}


class ICICI extends Bank
{
	double rateOfInterest()
	{
		return 9.7;
	}
}


class AXIS extends Bank
{
	double rateOfInterest()
	{
		return 8.5;
	}
}



public class MethodOverridingDemo {

	public static void main(String[] args) {
	
		SBI sbi=new SBI();
		System.out.println(sbi.rateOfInterest());
		
		ICICI icici=new ICICI();
		System.out.println(icici.rateOfInterest());
		
		AXIS axis =new AXIS();
		System.out.println(axis.rateOfInterest());
		
	}

}
