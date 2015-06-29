package com.xinov.academix.web.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
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
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
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

		Map<String, Integer> rollNumberPresentMap = new HashMap<String, Integer>();
		Map<String, Integer> rollNumberAbsentMap = new HashMap<String, Integer>();
		Map<Date, Integer> datePresentMap = new HashMap<Date, Integer>();
		Map<Date, Integer> dateAbsentMap = new HashMap<Date, Integer>();
		
		writer.setPageEvent(new Watermark());
		
		Date firstDate = attendances.get(0).getDate();
		Date lastDate = attendances.get(attendances.size()-1).getDate();
		
		doc.addHeader("ABC School", "Class 3C");
		
		long diffInMillies = lastDate.getTime() - firstDate.getTime();
		int numberOfDays = (int)TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
		
		PdfPTable headerTable = createHeaderTable(attendances);
		doc.add(headerTable);
		
		PdfPTable table = new PdfPTable(numberOfDays + 6);
		table.setWidthPercentage(100.0f);
		float [] widths = new float[numberOfDays + 6];
		
		widths[0] = 0.2f;
		widths[1] = 1f;
		for(int i = 0; i < numberOfDays + 3 ; i++){
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
		for(int i = 0; i < numberOfDays ; i++){
			String day = new SimpleDateFormat("EEE").format(DateUtils.addDays(firstDate, i));
			if(day.equalsIgnoreCase("Sun")){
				cell.setBackgroundColor(new BaseColor(249, 189, 153));
			} else {
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			}
			cell.setPhrase(new Phrase(dateFormat.format(DateUtils.addDays(firstDate, i)), font));
			table.addCell(cell);
		}
		
		cell.setBackgroundColor(new BaseColor(232, 239, 247));
		
		cell.setPhrase(new Phrase("P.", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("A.", font));
		table.addCell(cell);
		
		cell.setBackgroundColor(new BaseColor(162, 190, 219));
		cell.setPhrase(new Phrase("T.", font));
		table.addCell(cell);
		
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
				String day = new SimpleDateFormat("EEE").format(attendance.getDate());
				if(day.equalsIgnoreCase("Sun")){
					dataCell.setBackgroundColor(new BaseColor(253, 235, 223));
				}else {
					dataCell.setBackgroundColor(BaseColor.WHITE);
				}
				if(attendance.getStudent().equals(student)){
					dataCell.setPhrase(new Phrase(day.equalsIgnoreCase("Sun") ? "" : attendance.isPresent() ? "P" : "A", new Font(FontFamily.HELVETICA, 11)));
					table.addCell(dataCell);
					
					if(!day.equalsIgnoreCase("Sun") && attendance.isPresent()) {
						addAttendanceToRollNoMap(rollNumberPresentMap, attendance);
						addAttendanceToDateMap(datePresentMap, attendance);
					} else if(!day.equalsIgnoreCase("Sun") && !attendance.isPresent()){
						addAttendanceToRollNoMap(rollNumberAbsentMap, attendance);
						addAttendanceToDateMap(dateAbsentMap, attendance);
					}
				}
				
				if (rollNumberPresentMap.get(attendance.getStudent()
						.getStudentInfo().getRollNumber()) != null && rollNumberAbsentMap.get(attendance.getStudent()
								.getStudentInfo().getRollNumber()) != null
						&& rollNumberPresentMap.get(attendance.getStudent()
								.getStudentInfo().getRollNumber()) + rollNumberAbsentMap.get(attendance.getStudent()
										.getStudentInfo().getRollNumber()) == numberOfDays - 3) {
					dataCell.setPhrase(new Phrase(rollNumberPresentMap
							.get(attendance.getStudent().getStudentInfo()
									.getRollNumber())));
					table.addCell(dataCell);

					dataCell.setPhrase(new Phrase(rollNumberAbsentMap
							.get(attendance.getStudent().getStudentInfo()
									.getRollNumber())));
					table.addCell(dataCell);
				}
			}
			count++;
		}
		doc.add(table);
	}

	private void addAttendanceToRollNoMap(Map<String, Integer> attendanceMap,
			Attendance attendance) {
		attendanceMap.put(attendance.getStudent().getStudentInfo().getRollNumber(), attendanceMap.get(attendance.getStudent().getStudentInfo().getRollNumber()) == null ? 1 : attendanceMap.get(attendance.getStudent().getStudentInfo().getRollNumber()) + 1);
	}
	
	private void addAttendanceToDateMap(Map<Date, Integer> attendanceMap,
			Attendance attendance) {
		attendanceMap.put(attendance.getDate(), attendanceMap.get(attendance.getStudent().getStudentInfo().getRollNumber()) == null ? 1 : attendanceMap.get(attendance.getStudent().getStudentInfo().getRollNumber()) + 1);
	}
	
	private PdfPTable createHeaderTable(List<Attendance> attendances) throws DocumentException, MalformedURLException, IOException {
		PdfPTable headerTable = new PdfPTable(2);
		headerTable.setWidthPercentage(100.0f);
		headerTable.setWidths(new float[]{0.5f, 0.5f});
		
		Font headerFont = FontFactory.getFont(FontFactory.HELVETICA);
		headerFont.setColor(BaseColor.BLACK);
		headerFont.setSize(14);
		headerFont.setStyle(FontStyle.BOLD.getValue());
		
		String imgPath = "/resources/images/school_logo.png";
	    String absoluteImgPath = getServletContext().getRealPath(imgPath);
		
	    Image image = Image.getInstance(absoluteImgPath);
	    image.setAlignment(Element.ALIGN_RIGHT);
	    image.scalePercent(50);
	    
	    
	    PdfPCell imageCell = new PdfPCell();
	    imageCell.setFixedHeight(50);
	    imageCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	    imageCell.addElement(image);
	    imageCell.setPaddingRight(-30f);
	    imageCell.setBorder(Rectangle.NO_BORDER);
		headerTable.addCell(imageCell);
		
		PdfPCell cell = new PdfPCell();
		cell.setFixedHeight(50);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_BASELINE);
		cell.setPaddingLeft(0f);
		cell.setPaddingTop(15);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.addElement(new Phrase("SIES School, Nerul", headerFont));
		headerTable.addCell(cell);
		
		Font defaultFont = new Font(FontFamily.HELVETICA, 13);

		headerTable.addCell(createAlignedCell("Class : " + attendances.get(0).getClassMaster().getTitle(), defaultFont, Element.ALIGN_LEFT));
		headerTable.addCell(createAlignedCell("Class Teacher: " + attendances.get(0).getTeacher().getName(), defaultFont, Element.ALIGN_RIGHT));
		headerTable.addCell(createAlignedCell("Month: " + new SimpleDateFormat("MMMM").format(attendances.get(0).getDate()), defaultFont, Element.ALIGN_LEFT));
		headerTable.addCell(createAlignedCell("Signature: _________________", defaultFont, Element.ALIGN_RIGHT));
		headerTable.addCell(createAlignedCell("Year  : " + new SimpleDateFormat("yyyy").format(attendances.get(0).getDate()), defaultFont, Element.ALIGN_LEFT));
		headerTable.addCell(createAlignedCell("Date: _____________________", defaultFont, Element.ALIGN_RIGHT));
		
		return headerTable;
	}

	private PdfPCell createAlignedCell(String cellText,
			Font defaultFont, int alignment) {
		PdfPCell cell = new PdfPCell();
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(Rectangle.NO_BORDER);
		Paragraph paragraph = new Paragraph(cellText, defaultFont);
		paragraph.setAlignment(alignment);
		cell.addElement(paragraph);
		
		return cell;
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
