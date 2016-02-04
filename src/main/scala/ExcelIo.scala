import java.io.{FileOutputStream, FileInputStream, File}
import java.util.Calendar
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel._
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import scalax.file.Path

object ExcelIo {
  val dataDirPath = Path().toAbsolute / "data" / "excel"

  def main (args: Array[String]) {
    println("ExcelIo START")

    //this.newFileOperation()
    this.existingFileOperation()

    println("ExcelIo END")
  }

  def newFileOperation(): Unit = {
    val filePath = dataDirPath / "test.xlsx"

    //excelファイル作成
    val newWorkbook: Workbook = new XSSFWorkbook() //xlsx
    //val newWorkbook: Workbook = new HSSFWorkbook() //xls

    //sheet作成
    val sheet1: Sheet  = newWorkbook.createSheet("new sheet")

    //セル指定
    val row1: Row = sheet1.createRow(0)
    val cell1: Cell = row1.createCell(0)
    cell1.setCellValue("TEST")

    //セル書式設定
    val createHelper: CreationHelper = newWorkbook.getCreationHelper
    val cellStyle1: CellStyle  = newWorkbook.createCellStyle
    cellStyle1.setDataFormat(
      createHelper.createDataFormat().getFormat("m/d/yy h:mm"))
    val cell2: Cell = row1.createCell(1)
    cell2.setCellValue(Calendar.getInstance())
    cell2.setCellStyle(cellStyle1)

    //中央寄せ
    val cellStyle2: CellStyle  = newWorkbook.createCellStyle
    cellStyle2.setAlignment(CellStyle.ALIGN_CENTER)
    cellStyle2.setVerticalAlignment(CellStyle.VERTICAL_CENTER)
    val row2: Row = sheet1.createRow(1)
    val cell3: Cell = row2.createCell(2)
    cell3.setCellValue("TEST2")
    cell3.setCellStyle(cellStyle2)

    //書き込み
    val fileOut: FileOutputStream  = new FileOutputStream(filePath.jfile)
    newWorkbook.write(fileOut)
    fileOut.close()
  }

  def existingFileOperation(): Unit = {
    //excelオブジェクト取得
    val filePath = dataDirPath / "test.xlsx"
    val workbook: Workbook = WorkbookFactory.create(filePath.jfile)
    //ファイル全体バッファ格納（メモリ使用量増）
    //val workbook: Workbook = WorkbookFactory.create(new FileInputStream("/path/to/excel/file"))

//    import scala.collection.JavaConverters._ //java <=> scalaのコレクション明示変換
//    val sheet: Sheet = workbook.getSheetAt(0)
//    for (row <- sheet.asScala) {
//      for (cell <- row.asScala) {
//        cell.getCellType match {
//          case Cell.CELL_TYPE_STRING => println(cell.getStringCellValue)
//          case _ => println("データ型不明")
//        }
//      }
//    }

    import scala.collection.JavaConversions._ //java <=> scalaのコレクション暗黙変換
    val sheet2 = workbook.getSheetAt(0)
    sheet2.foreach { row =>
      row.foreach { cell =>
        cell.getCellType match {
          case Cell.CELL_TYPE_STRING => println(cell.getStringCellValue)
          case _ =>
        }
      }
    }
  }
}
