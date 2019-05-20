import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * The use of Unit = is similar to void in C++ and Java
  * It will give no return (in other words, if knn is called
  * with Unit = then it will do everything in the def but give no return
  */

class MLModels {
  // Create Spark context
  val sc = new SparkContext(new SparkConf().setAppName("Read file").setMaster("local[*]").set("spark.executor.memory", "1g"))
  val sqlContext: SparkSession = SparkSession.builder.config(sc.getConf).getOrCreate()

  // They can be defined as an object for ease of access by other classes / objects.
  // Or use the packaged modules available from scala 2.8 versions
  /**
    * KNN clustering - can change distance measures.
    * PCA or any other dimension reduction to get the clustering
    * Verify using pid if the same click corresponds to same cluster
    */
  def knn(number: Int, args: Array[String]): Unit = {
    // Trains a k-means model.
//    val kmeans = new KMeans().setK(2)
//    val model = kmeans.fit(data)
//    // Make predictions
//    val predictions = model.transform(data)
//    // Shows the result.
//    println("Cluster Centers: ")
//    model.clusterCenters.foreach(println)

    println(args(number))
    // Read data
    val dataObject = new Data()
    val user_profiles = dataObject.readCSVFile(args(number), sqlContext)
    println(user_profiles)
    // Pick up column names from the dataframe
    var feature_names = user_profiles.columns
    // Features are not based on pid. Remove only pid from the feature names

    feature_names = feature_names.drop(0)

//    if (number == 0) {
//      feature_names = feature_names.patch(1, Nil, 1) // Removes 1 element from index 1 and patches it up with Nil element
//    }
//    feature_names = feature_names.patch(0, Nil, 1) // Removes 1 element from index 0 and patches it up with Nil element
    println(s"these are the feature names $feature_names")
    // Put all columns in a single feature using Vector Assembler
    val assembler = new VectorAssembler().setInputCols(feature_names).setOutputCol("features")
    val user_profile_with_features_col = assembler.transform(user_profiles)
    // train k means model
    val kmeans = new KMeans().setK(10)
    val model = kmeans.fit(user_profile_with_features_col)
    // Make predictions
    val predictions = model.transform(user_profile_with_features_col)
    println(predictions)
    // Shows the result.
    println("Cluster Centers: ")
    model.clusterCenters.foreach(println)

  }
//  // Practice code for functions that take in parameters
//  def calculateDonutCost(donutName: String, quantity: Int): Unit = {
//    println(s"Calculating cost for $donutName, quantity = $quantity")
//
//    // make some calculations ...
//    val cost = {
//      2.50 * quantity
//    }
//    println(s"Total cost for $quantity $donutName is $cost")
//  }

  /**
    * Decision Tree clustering - .
    * Determine method of splitting
    * Verify using pid if the same click corresponds to same cluster
    */

//  def decisionTrees(): Unit = {
//
//  }
//
//  def hierarchicalClustering(): Unit = {
//
//  }
//
//  def multiClassLogisticRegression(): Unit = {
//
//
//
//  }
//
//  def neuralNetworks(train_data: DataFrame, test_data: DataFrame): Unit = {
//
//    val layers = Array[Int](4, 5, 4, 11)
//
//    val trainer = new MultilayerPerceptronClassifier()
//      .setLayers(layers)
//      .setBlockSize(128)
//      .setSeed(1234L)
//      .setMaxIter(3)
//
//    // drop columns that will not be features
//    var new_train_data = train_data.drop("req_time", "o", "d", "plan_time", "sessionID", "click_time", "price_3", "price_5", "price_6")
//    var new_test_data = test_data.drop("req_time", "o", "d", "plan_time", "sessionID", "click_time", "price_3", "price_5", "price_6")
//
//    val assembler = new VectorAssembler()
//    assembler.setInputCols(new_train_data.columns)
//    assembler.setOutputCol("features")
//
//    new_train_data = assembler.transform(new_train_data)
//    new_test_data = assembler.transform(new_test_data)
//
//    new_train_data = new_train_data.withColumnRenamed("click_mode", "label")
//    new_test_data = new_test_data.withColumnRenamed("click_mode", "label")
//
//    new_train_data.show(5)
//
//    // train the model
//    //val features = train_data.columns
//    val model = trainer.fit(new_train_data)
//
//    // compute accuracy on the test set
//    val result = model.transform(new_test_data)
//    val predictionAndLabels = result.select("prediction", "label")
//    val evaluator = new MulticlassClassificationEvaluator()
//      .setMetricName("accuracy")
//
//    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
//  }
//
//
//  def svm(): Unit ={
//
//  }
//
//  def trainTestSplit(): Unit = {
//
//  }
//
//  def oneVsAllValidation(): Unit = {
//
//  }
//
//  def crossValidation(): Unit = {
//
//  }
//
//  def findF1Score(): Unit = {
//
//  }
//
//  def findF1WeightedScore(): Unit ={
//
//  }


}
