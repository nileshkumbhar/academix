package com.xinov.academix.web.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.xinov.academix.attendance.api.domain.Attendance;
import com.xinov.academix.core.api.domain.User;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 * 
 */
public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<Attendance> attendances = new ArrayList<Attendance>((Set<Attendance>) model.get("attendanceList"));
		
		Collections.sort(attendances, new Comparator<Attendance>() {

			@Override
			public int compare(Attendance attendance1, Attendance attendance2) {
				// TODO Auto-generated method stub
				return attendance1.getDate().compareTo(attendance2.getDate());
			}
		});

		writer.setPageEvent(new Watermark());
		
		Date firstDate = attendances.get(0).getDate();
		Date lastDate = attendances.get(attendances.size()-1).getDate();
		
		/*Collections.sort(attendances, new Comparator<Attendance>() {

			@Override
			public int compare(Attendance attendance1, Attendance attendance2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(
						attendance1.getStudent().getStudentInfo()
								.getRollNumber()).compareTo(
						Integer.valueOf(attendance2.getStudent()
								.getStudentInfo().getRollNumber()));
				
			}
		});*/

		doc.addHeader("ABC School", "Class 3C");
		
		long diffInMillies = lastDate.getTime() - firstDate.getTime();
		int numberOfDays = (int)TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA);
		headerFont.setColor(BaseColor.BLACK);
		headerFont.setSize(14);
		headerFont.setStyle(FontStyle.BOLD.getValue());
		
		
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_CENTER);
		paragraph.setSpacingAfter(50);
		
		paragraph.add(Image.getInstance(ClassLoader.getSystemResource("school_logo.png")));
		paragraph.add(new Phrase("SIES School, Nerul", headerFont));
		
		
		doc.add(paragraph);
		
		PdfPTable table = new PdfPTable(numberOfDays + 3);
		table.setWidthPercentage(100.0f);
		float [] widths = new float[numberOfDays + 3];
		
		widths[0] = 0.2f;
		widths[1] = 1f;
		for(int i = 0; i < numberOfDays ; i++){
			widths[i+2] = 0.1f;
		}
		
		table.setWidths(widths);
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setPaddingBottom(10);
		cell.setPaddingTop(10);

		// write table header
		cell.setPhrase(new Phrase("Roll No.", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		DateFormat dateFormat = new SimpleDateFormat("dd");
		for(int i = 0; i <= numberOfDays ; i++){
			cell.setPhrase(new Phrase(dateFormat.format(DateUtils.addDays(firstDate, i)), font));
			table.addCell(cell);
		}
		
		int count = 1;
		// write table row data
		PdfPCell dataCell = new PdfPCell();
		for(User student : getStudents(attendances)){
			if(count % 2 == 0){
				dataCell.setBackgroundColor(new BaseColor(245, 245, 245));
			} else {
				dataCell.setBackgroundColor(BaseColor.WHITE);
			}
			
			dataCell.setPhrase(new Phrase(student.getStudentInfo().getRollNumber(), new Font(FontFamily.HELVETICA, 11)));
			table.addCell(dataCell);
			
			dataCell.setPhrase(new Phrase(student.getName(), new Font(FontFamily.HELVETICA, 11)));
			table.addCell(dataCell);
			
			for (Attendance attendance : attendances) {
				if(attendance.getStudent().equals(student)){
					dataCell.setPhrase(new Phrase(attendance.isPresent() ? "P" : "A", new Font(FontFamily.HELVETICA, 11)));
					table.addCell(dataCell);
				}
			}
			count++;
		}
		doc.add(table);
	}
	
	private Set<User> getStudents(List<Attendance> attendances){
		Set<User> students = new TreeSet<User>(new Comparator<User>() {

			@Override
			public int compare(User student1, User student2) {
				return Integer.parseInt(student1.getStudentInfo().getRollNumber()) - Integer.parseInt(student2.getStudentInfo().getRollNumber());
			}
		});
		
		for(Attendance attendance : attendances){
			students.add(attendance.getStudent());
		}
		return students;
	}
	
	public class Watermark extends PdfPageEventHelper {
		 
        protected Phrase watermark = new Phrase("SPECIMEN", new Font(FontFamily.HELVETICA, 70, Font.NORMAL, BaseColor.DARK_GRAY));
 
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte canvas = writer.getDirectContent();
            PdfGState state = new PdfGState();
            state.setFillOpacity(0.3f);
            canvas.setGState(state);
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 625, 425, 40);
        }
    }

}
