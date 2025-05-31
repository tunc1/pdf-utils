package app;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class PDFUtil
{
	public void merge(String destinationFile,List<File> files) throws IOException
	{
		PDFMergerUtility pdfMergerUtility=new PDFMergerUtility();
		for(File file:files)
			pdfMergerUtility.addSource(file);
		pdfMergerUtility.setDestinationFileName(destinationFile);
		pdfMergerUtility.mergeDocuments(null);
	}
	public void merge(List<String> files,String destinationFile) throws IOException
	{
		merge(destinationFile,files.stream().map(filePath->new File(filePath)).toList());
	}
}