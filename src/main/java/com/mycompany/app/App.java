package com.mycompany.app;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * 
 

 */ public final class App 
{
    private App()
    {

    }

    public static void main( String[] args ) throws IOException
    {
        try (PDDocument document = new PDDocument())
        {
            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPage page = new PDPage();
            document.addPage(page);        
            PDPageContentStream cs = new PDPageContentStream(document, page);

            final float k = 0.552284749831f;
            
            int center_x = 100;
            int center_y = 100;
            int radius = 50;

            cs.setNonStrokingColor(Color.black);
            cs.moveTo(center_x - radius, center_y);
            cs.curveTo(center_x - radius, center_y + k * radius, center_x - k * radius, center_y + radius, center_x, center_y + radius);
            cs.curveTo(center_x + k * radius, center_y + radius, center_x + radius, center_y + k * radius, center_x + radius, center_y);
            cs.curveTo(center_x + radius, center_y - k * radius, center_x + k * radius, center_y - radius, center_x, center_y - radius);
            cs.curveTo(center_x - k * radius, center_y - radius, center_x - radius, center_y - k * radius, center_x - radius, center_y);
            cs.stroke();

            cs.beginText();
            cs.setFont(font, 120);
            cs.newLineAtOffset(center_x, center_y);
            cs.showText("7");
            cs.endText();
            
            cs.close();

            document.save("output.pdf");
            document.close();
        }
    }
}
