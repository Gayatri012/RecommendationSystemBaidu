import org.apache.spark.sql.{DataFrame, SparkSession}

class Data {
  /**
    *
    * @param fileName : Complete path of file that needs to be read
    */
  def readCSVFile(fileName: String, sqlContext: SparkSession): DataFrame = {
    val data =  sqlContext.read.option("header", "true").option("inferSchema", "true").csv(fileName)
    data
  }

  def writeToCSV(filePath: String, full_data: DataFrame): Unit = {
    full_data.coalesce(1).write.format("csv").option("header", "true").save(filePath)
  }

  def joinAllData(user_request: DataFrame, available_modes: DataFrame, clicked_mode: DataFrame): DataFrame = {
    // Join all the dataset based on session id
    // train_queries is the left most table - do an (or a left outer join) inner join of train_queries with train_plans data based on sid
    // Do a left outer join with the train_clicks file

    var full_data = user_request.join(available_modes, user_request("sid") === available_modes("sessionID"),
      "left_outer").join(clicked_mode, Seq("sid", "sid"), "left_outer")
    full_data = full_data.drop("sid")
    full_data
  }


  /**
    * A single call to this function should clean, merge data and perform all needed pre-processing
    */
  def preprocessData(): Unit = {

  }

  def saveOutputFile(): Unit ={

  }

  /**
    * Can this be done?
    */
  def saveDataToAWS(): Unit ={

  }

  def trainTestSplit(data: DataFrame, trainRatio: Double, testRatio: Double) = {
    // Split the data into train and test
    val splits = data.randomSplit(Array(trainRatio, testRatio), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
    (train, test)
  }


  def convertNull(data: DataFrame): DataFrame = {
    val noNullData: DataFrame = data.na.fill(0)
    //data.na.fill(0)
    //println("Inside convertNull()")
    //data.na.fill(0).select(data.na.fill(0).columns.map(c => sum(col(c).isNull.cast("int")).alias(c)): _*).show()
    noNullData
  }
}
