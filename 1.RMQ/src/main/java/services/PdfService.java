package services;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import models.Type;
import models.User;

import java.io.FileNotFoundException;

public class PdfService {

    private final static String DEST = "H:\\temp\\";

    public void createPdf(User user, Type type) {
        try {

            PdfDocument pdf = new PdfDocument(new PdfWriter(DEST + type.toString() + user.hashCode() + ".pdf"));

            Document document = new Document(pdf);
            String line = null;
            switch (type) {
                case EXPULSION: {
                    line = "expulsion application";
                }
                case RESIGNATION: {
                    line = "resignation application";
                }
            }

            document.add(new Paragraph(line));
            String name = "Name: " + user.getName();
            String surname = "Surname: " + user.getSurname();
            String age = "Age: " + user.getAge();
            String passport = "Passport: " + user.getPassport();
            String date = "Date of passport: " + user.getDate();
            document.add(new Paragraph(name));
            document.add(new Paragraph(surname));
            document.add(new Paragraph(age));
            document.add(new Paragraph(passport));
            document.add(new Paragraph(date));
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
