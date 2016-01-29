import org.apache.poi.ss.usermodel._

object ExcelIo {
  def main (args: Array[String]) {
    val workbook = WorkbookFactory.create(new File("/path/to/excel/file"))
  }
}
