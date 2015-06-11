package com.xinov.academix.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.xinov.academix.attendance.api.domain.Attendance;

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

		
		
		Date firstDate = attendances.get(0).getDate();
		Date lastDate = attendances.get(attendances.size()-1).getDate();
		
		Collections.sort(attendances, new Comparator<Attendance>() {

			@Override
			public int compare(Attendance attendance1, Attendance attendance2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(
						attendance1.getStudent().getStudentInfo()
								.getRollNumber()).compareTo(
						Integer.valueOf(attendance2.getStudent()
								.getStudentInfo().getRollNumber()));
				
			}
		});

		doc.add(new Paragraph("Specimen attendance data"));
		
		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 1.5f, 5.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f});
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Roll No.", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);

		// write table row data
		for (Attendance attendance : attendances) {
			table.addCell(attendance.getStudent().getStudentInfo().getRollNumber());
			table.addCell(attendance.getStudent().getName());
			table.addCell(new SimpleDateFormat("dd MMM yyyy").format(attendance.getDate()));
			table.addCell(attendance.isPresent() ? "P" : "N");
		}

		doc.add(table);

	}

}