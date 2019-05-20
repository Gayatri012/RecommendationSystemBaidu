

object Main {

  // test main
  def main(args: Array[String]): Unit = {
//    val user_profile = args(0)
    val logObject = new Logging()
    logObject.log()
    val MLModelsObject = new MLModels()
//    MLModelsObject.knn(args: Array[String])
    MLModelsObject.knn(1, args: Array[String])
  }


    // Fit an unsupervised clustering model to user_profiles data



    // Pre process data - create an object of class Data

    // Merge files based on session id
//    var full_data = dataObject.joinAllData(user_request, available_modes, clicked_mode)

    // Drop randomly generated columns
//    full_data = full_data.drop("_c4")
//    full_data = full_data.drop("_c5")

//    full_data.printSchema()

    // Check if there are null values
    //full_data.select(full_data.columns.map(c => sum(col(c).isNull.cast("int")).alias(c)): _*).show()

    // Convert null values to 0
//    full_data = dataObject.convertNull(full_data)

    // Check if there are null values
    //println("-----------------------After null to 0 conversion ----------------------------------")
    //full_data.select(full_data.columns.map(c => sum(col(c).isNull.cast("int")).alias(c)): _*).show()

    // Write the full_data to a csv file
    //dataObject.writeToCSV("C:\\Data\\Gayatri\\US\\UTD\\Spring 2019\\CS6307 Big Data\\Projects\\Final project\\Baidu\\data_set_phase1\\output", full_data)

    // Consider only some columns to work with for sample data


    // Train-test split
//    val (train, test) = dataObject.trainTestSplit(full_data, 0.7, 0.3)
    //train.show(5)
    //test.show(5)


    // pre-processing - Convert timestamps to indicate season, day of week (weekend or weekday), time of day (peak hours or not)

    // Should we not consider distance, eta and price of each transport mode as a single unit

    // Fit ml models - use object of class MachineLearningModels
    // Fit sample data first and then fit preprocessed data. Load the data stored in LIBSVM format as a DataFrame.
/*
    val sample_data = sqlContext.read.format("libsvm")
      .load("data/mllib/sample_multiclass_classification_data.txt")
    sample_data.show(5)
*/

    // Find which of the ml model works best
//    val mlModels = new MachineLearningModels()
//    mlModels.neuralNetworks(train, test)


    // Fit all data using the best model may be

    // From the data, can we know the best possible route in general (without context?). If yes, then that will be the default recommendation to users about whom we dont know anything


    // Find F1 metric

    // Save output indicating the classified response (would be good to include F1-score and F1 weighted score, but how?)

  }