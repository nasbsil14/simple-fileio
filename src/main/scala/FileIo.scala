import scalax.io._
import scalax.file.Path

object FileIo {
  val dataDirPath = Path().toAbsolute / "data"

  def main(args: Array[String]): Unit = {
    println("SimpleFileIo START")
    println(dataDirPath)

//    this.createFile
//    this.fileList
//    this.writeText
    this.readText

    println("SimpleFileIo END")
  }

  //ファイル作成
  def createFile(): Unit = {
    val createPath: Path = dataDirPath / "import" / "new_file.txt"
    createPath.createFile()
  }

  //ファイル一覧取得
  def fileList(): Unit = {
    import scalax.file.PathSet
    val targetDirPath: Path = dataDirPath / "import"
    val children: PathSet[Path] = targetDirPath.children()
    children.foreach(child => println(child.path))
  }

  //ファイル削除
  def deleteFile(): Unit = {
    val targetPath: Path = dataDirPath / "import" / "imp_test.txt"
    targetPath.deleteIfExists()
  }

  //ファイルリネーム
  def renameFile(): Unit = {
    val beforPath: Path = dataDirPath / "import" / "imp_test.txt"
    val afterPath: Path = dataDirPath / "import" / "imp_test_rename.txt"
    beforPath.moveTo(afterPath)
  }

  //ファイルコピー
  def copyFile(): Unit = {
    val targetPath: Path = dataDirPath / "import" / "imp_test.txt"
    val copyPath: Path = dataDirPath / "import" / "imp_test_copy.txt"
    targetPath.copyTo(copyPath)
  }

  //ファイル移動
  def moveFile(): Unit = {
    val beforPath: Path = dataDirPath / "import" / "imp_test.txt"
    val afterPath: Path = dataDirPath / "import" / "import2" / "imp_test.txt"
    beforPath.moveTo(afterPath)
  }

  //ファイル読み込み（テキスト）
  def readText(): Unit = {
    val impFile = dataDirPath / "import" / "imp_test.txt"
    println(impFile.string(Codec.UTF8))
  }

  //ファイル読み込み（xml）
  //ファイル読み込み（csv）
  //ファイル書き出し（テキスト）
  def writeText(): Unit = {
    val expFile: Output = dataDirPath / "import" / "imp_test.txt"
    expFile.writeStrings(List("hello", "world"), " ")(Codec.UTF8)
  }

  //ファイル書き出し（xml）
  //ファイル書き出し（csv）
}