import java.io.{FileOutputStream, FileInputStream, File}
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel._
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import scalax.file.Path

object ExcelIo {
  val dataDirPath = Path().toAbsolute / "data" / "excel"

  def main (args: Array[String]) {


  }

  def newFileOperation(): Unit = {
    val filePath = dataDirPath / "test.xlsx"

    //excelファイル作成
    val newWorkbook: Workbook = new XSSFWorkbook() //xlsx
    //val newWorkbook: Workbook = new HSSFWorkbook() //xls

    //sheet作成
    val sheet1: Sheet  = newWorkbook.createSheet("new sheet")

    //書き込み
    val fileOut: FileOutputStream  = new FileOutputStream(filePath.toString())
    newWorkbook.write(fileOut)
    fileOut.close()
  }

  def existingFileOperation(): Unit = {
    //excelオブジェクト取得
    val filePath = dataDirPath / "test.xlsx"
    val workbook: Workbook = WorkbookFactory.create(new File(filePath.toString()))
    //ファイル全体バッファ格納（メモリ使用量増）
    //val workbook: Workbook = WorkbookFactory.create(new FileInputStream("/path/to/excel/file"))
  }
}
