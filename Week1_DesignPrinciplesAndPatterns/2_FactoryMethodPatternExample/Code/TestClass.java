public class TestClass {

    public static void main(String[] args) {
      DocumentFactory  wordFactory = new WordFactory();
      ConcreteClass word =  wordFactory.createDocument();
      word.check();

        DocumentFactory pdfFactory = new PdfFactory();
        ConcreteClass pdf = pdfFactory.createDocument();
        pdf.check();

        DocumentFactory excelFactory = new ExcelFactory();
        ConcreteClass excel = excelFactory.createDocument();
        excel.check();
    }
    
}
