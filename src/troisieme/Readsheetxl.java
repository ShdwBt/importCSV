package troisieme;
import jxl.Cell;
import jxl.Sheet;
//import jxl.*;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import jxl.write.WriteException;
import java.util.Locale;

public class Readsheetxl {
	
		//String sql = "UPDATE compte SET cpt_numero = CONCAT( ?, ?) WHERE"
		/*public Object ReadXlsFile() throws IOException, WriteException, BiffException{
			
			return null;
		}*/
	 
		/**
		 * @param args
		 */
		public static void main(String[] args) throws IOException, BiffException{ //WriteException
			// TODO Auto-generated method stub
	        try
	        {	
	        	
	        	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("b:/script3.sql")));
	        	//writer.close();
	        	
	        	// Opening of the xls file
	        	File xlsDocument = new File("C:/Users/ShdwBt/Documents/GitHub/importCSV/lib/Correspondance_FR_contrat_ancien_nouveau.xls");
	        	
	        	// Get the settings characterizing an excel document or Excel interface ??
	        	
	        	// WorkbookSettings : A bean which client applications may use to set various advanced workbook properties
	        	WorkbookSettings ws = new WorkbookSettings();
	        	
	        	// setLocale - new Locale : construct a locale from language and country
	        	ws.setLocale(new Locale("fr","FR"));
	        	
	        	// Class representing a workbook and contains the various factory methods and provides a variety of accessors 
	        	// which provide access to the work sheets.
	        	
	        	// getWorkbook : method which takes in an excel file and reads in the contents.
	        	Workbook workbook = Workbook.getWorkbook(xlsDocument,ws);
	        	
	        	// Get Sheet number
	        	Sheet readSheet = workbook.getSheet(0);
	        	// Sheet name
	        	System.out.println("Nom de la feuille : " + readSheet.getName());
	        	
	        	// Get Columns number
	        	System.out.println("Nombre de colonnes : " + readSheet.getColumns());
	        	
	        	// Get Lines number
	        	System.out.println("Nombre de lignes : " + readSheet.getRows());
	        	
	        	System.out.println();
	        	
	        	// xls file reading 
	        	// int i = 1 to avoid Headers Catching
	        	for (int i = 1; i < readSheet.getRows(); i++){
	        		for (int j = 0; j < readSheet.getColumns(); j++){
	        			Cell cell = readSheet.getCell(j, i);
	        			/*writer.write(String.valueOf(cell.getContents()));
	        			writer.write("\r\n"); // a la ligne */ //chaque colonne surune ligne du fichier
	        			
	        			// get toutes les colonnes -> but : supp la premiere et use sql concat pour les 2 autres
	        			
	        			// vrai but faire la comparaison avec concat('000', column1) catch dans le script.sql
	        			// sinon udpate compte avec old_cpt_number (+ '000' avec concat ?) catch dans le script
	        			
	        			// recup du code du script local infile
	        			
	        			// http://www.ukonline.be/programmation/java/tutoriel/chapitre12/page4.php
	        			// http://www.commentcamarche.net/forum/affich-1165710-java-ecrire-dans-un-fichier ....
	        			
	        			// COURS http://www.jmdoudoux.fr/java/dej/chap-flux.htm !!!
	        			writer.write(String.valueOf("UPDATE compte set cpt_numero = " + readSheet.getCell(j,i).getContents()));
	        			writer.write("\r\n");
	        			
	        			System.out.print(cell.getContents()+" ");
	        		}
	        		System.out.println();
	        	}
	 
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        }
	 
	        catch(BiffException e)
	        {
	        	e.printStackTrace();
	        }
		} 
		
		/*public static void main(String[] args) throws IOException {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("c:/xls/script.sql")));
			// normalement si le fichier n'existe pas, il est cr�e � la racine du projet
			//writer.write(....);
			 
			writer.close();
		}*/
	 
	
}
