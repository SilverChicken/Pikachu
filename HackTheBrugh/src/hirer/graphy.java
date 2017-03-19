package hiring;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.List;
 
public class graphy extends Application {
 /*   final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA"; */
    private static HashMap<String,Double> results = new HashMap<String,Double>();
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Perfomance evaluation");
        xAxis.setLabel("Id");       
        yAxis.setLabel("Rating");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Perfomance Evaluation");  
        for(String s:results.keySet())
        {
            series1.getData().add(new XYChart.Data(s,results.get(s)));
        }
      /*  series1.getData().add(new XYChart.Data(brazil, 2));
        series1.getData().add(new XYChart.Data(france, 3));
        series1.getData().add(new XYChart.Data(italy, 4));
        series1.getData().add(new XYChart.Data(usa, 5));     */ 
        
     /*   XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));  
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));  */
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
    public void graphy(HashMap results)
    {
        this.results = new HashMap(results);
        this.results.keySet().removeAll(results.keySet());
        results.putAll(this.results);
    }
 
  public static void main(String[] args) {
        launch(args);
   }
}