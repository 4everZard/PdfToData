
package pdf2image;
 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.BaseField;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class GenericFields {
	
    public static final String SRC = "/home/developer/Downloads/PDFform.pdf";
    public static final String DEST = "/home/developer/Downloads/example.pdf";
    
//    public static final String SRC = "/home/developer/Downloads/hello.pdf";
//    public static final String DEST = "/home/developer/Downloads/hello2.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new GenericFields().manipulatePdf(SRC, DEST);
    }
    
  
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        
    	int xll1 = 36;
    	int yll1 = 800;
    	int xur1 = 144;
    	int yur1 = 830;
    	
    	
    	int xll2 = 150;
    	int yll2 = 800;
    	int xur2 = 450;
    	int yur2 = 830;
    	
    	boolean isDataField(int x, int y) {
			if(x >=x0 && x <= x1 && y>=y0 && y <=y1) {
				return true;
			}
			return false;
		}
    	
    	
    	
    	
    	
    	
    	PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfWriter writer = stamper.getWriter();
        Set<String> FieldNames = new HashSet<String>();
        
        PdfFormField personal = PdfFormField.createEmpty(writer);
        personal.setFieldName("personal");
        
        TextField name = new TextField(writer, new Rectangle(xll1,yll1,xur1,yur1), "name");
        FieldNames.add(name.getFieldName());
        PdfFormField personal_name = name.getTextField();
        personal.addKid(personal_name);
        
        TextField password = new TextField(writer, new Rectangle(xll2,yll2,xur2,yur2), "password");
        FieldNames.add(password.getFieldName());
        PdfFormField personal_password = password.getTextField();
        personal.addKid(personal_password);
        
        for (String key : FieldNames) {
    		
    				System.out.println(key); 
    			}
         
       
        
        //Set<String> keys = new HashSet<String>(name.getFieldName().keySet());
//        AcroFields acroFields = stamper.getAcroFields(); 
//        Set<String> keys = new HashSet<String>(acroFields.getFields().keySet()); 
//        
//        
//        for (String key : keys) {
//		
//				System.out.println(key); 
//			}

        stamper.addAnnotation(personal, 1);
        stamper.close();
        reader.close();
    }
}
    

