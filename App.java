package FastExchange.WordProject;

import java.io.*;
import java.util.*;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * автозаполнение доков
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	int x = 4;
    	int c = 5 >=++x?3:2;
    	System.out.print(c);
    	File directory = new File("D:\\project\\WordProject\\src\\test\\resources\\Templated");//переделать:директорию считывать с интерфейса <(0w0 )>
    	selectAndCopy(fileWatch(directory));
    	/*File readyDirectory = new File("D:\\project\\WordProject\\src\\test\\resources\\Ready");
    	String[] forModifyFailes = fileWatch(readyDirectory);*/								//для выходящей/готовой документации,?изменять только файлы в работе, а не все?   
    }
    
    private static void selectAndCopy(String[] files) throws IOException {
    	Scanner inner = new Scanner(System.in);
    	String varible = inner.next();														//набор файлов ограничен до 10 char get numeric\(0o0 )/
    	//(предупреждение о том что идентификация файла должна быть "число!")    	
    	Integer[] witchFilesNeed = new Integer[files.length];
    	for(int i = 0; i < varible.length(); i++) {
    		witchFilesNeed[i] = Character.getNumericValue(varible.charAt(i));				//изменить тип считывания, char подходит только для цифр, поменать при подкл интерфейса(-_- )
        	System.out.println("Co. Name?");
        	String name = inner.next();														//задать имя файлу
        	File source = new File("D:\\project\\WordProject\\src\\test\\resources\\Templated",files[witchFilesNeed[i]]);
        	File dest = new File("D:\\project\\WordProject\\src\\test\\resources\\Ready",name + files[witchFilesNeed[i]]);
            copyFileUsingStream(source,dest);
    	}
        inner.close();
    }
    
    private static String[] fileWatch(File directory) throws IOException{

    	System.out.println("Which file?");
    	String[] files = directory.list();													//масив файлов в директории
    	for(int i = 0; i < files.length; i++) {												//вывести список файлов
    		System.out.println(i + ". " + files[i]);
    	}
    	System.out.println("Only numeric value");
    	return files;

    }
    
    private static void copyFileUsingStream(File source, File dest) throws IOException {	//метод копирования файлов
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    private static void replacer(File source) throws IOException{
    	XWPFDocument docx = new XWPFDocument(OPCPackage.open(sourse + files[witchFilesNeed[i]]));
    	 
    }
}
