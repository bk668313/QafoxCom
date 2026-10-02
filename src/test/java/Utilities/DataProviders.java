
	
	package Utilities;
	import java.io.IOException;

	import org.testng.annotations.DataProvider;

	public class DataProviders {
		
		
		@DataProvider(name="LoginData")
		public String[][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"\\testData\\LoginData.xlsx";
			ExcelUtility xl=new ExcelUtility(path);
			int row=xl.getRowCount("Sheet1");
			int cols=xl.getCellCount("Sheet1", 0);
			String LoginData[][]=new String[row][cols];
			
			
			for(int i=1;i<=row;i++)
			{
				for(int j=0;i<cols;j++)
				{
					LoginData[i-1][j]=xl.getCellDat("Sheet1", i, j);
				}
			}
			
			return LoginData;
			
					}

	}


