import scalax.io._
import scalax.file.Path
object main {
    def main(args:Array[String]):Unit = {
        println("SimpleFileIo START")

        //this.createFile
        //this.getFileList
        this.writeText
        this.readText

        println("SimpleFileIo END")
    }

    //ファイル作成
    def createFile():Unit = {
        val dirPath:Path = Path("""D:/workspace/SimpleFileIO/data/import""",'/')
        val filePath:Path = Path("imp_test.txt")
        val createPath:Path = dirPath / filePath
        createPath.createFile()
    }

    //ファイル一覧取得
    def getFileList():Unit = {
        import scalax.file.PathSet
        val targetDirPath:Path = Path("""D:/workspace/SimpleFileIO/data/import""",'/')
        val children:PathSet[Path] = targetDirPath.children()
        children.foreach (child => println(child.path))
    }

    //ファイル削除
    //ファイルリネーム
    //ファイルコピー
    //ファイル移動
    //ファイル読み込み（テキスト）
    def readText():Unit = {
        val impFile:Input = Resource.fromFile("""D:/workspace/SimpleFileIO/data/import/imp_test.txt""")
        println(impFile.string(Codec.UTF8))
    }
    //ファイル読み込み（xml）
    //ファイル読み込み（csv）
    //ファイル書き出し（テキスト）
    def writeText():Unit = {
        val expFile:Output = Resource.fromFile("""D:/workspace/SimpleFileIO/data/import/imp_test.txt""")
        expFile.writeStrings(List("hello","world")," ")(Codec.UTF8)
    }
    //ファイル書き出し（xml）
    //ファイル書き出し（csv）
}