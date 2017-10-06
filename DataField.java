package pdf2image;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DataField {
	


	////
	public void OpenPdf() throws IOException{	
		
		Desktop desktop = Desktop.getDesktop();
		File file = new File("/home/developer/Downloads/resume2016.pdf");
		desktop.open(file);
		
}
	
	public void addRect(int x0,int y0,int width,int height) throws IOException {
		
		File file = new File("/home/developer/Downloads/resume2016.pdf");
		//OpenPdf();
		PDDocument document = PDDocument.load(file);
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page,PDPageContentStream.AppendMode.APPEND,true);
		

		
		
		
		Color boxStrokingColor =  Color.YELLOW;
		float opacity = 0.4f ; 
		PDExtendedGraphicsState extendedGraphicsState =  new PDExtendedGraphicsState ( ) ; 
		extendedGraphicsState. setNonStrokingAlphaConstant ( opacity ) ;
	 
		contentStream. setGraphicsStateParameters ( extendedGraphicsState ) ; 
		contentStream. setNonStrokingColor ( boxStrokingColor ) ;
		//PDRectangle rect = new PDRectangle(x0,y0,width,height);
		
		contentStream. addRect (x0,y0,width,height) ; 
		contentStream. fill ( ) ;
	
		contentStream.close(); 
		File file1 = new File("/home/developer/Downloads/pdfExample.pdf");
		document.save(file1);
		document.close();
	}
	

	
	public static void main(String args[]) throws IOException{							
		DataField newPdf = new DataField();
		//newPdf.OpenPdf();
		newPdf.addRect(80,80,200,50);
		
	}
}