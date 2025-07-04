import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Table {
    public String dbPath ;
    public String tableName ;
    private boolean columnsDefined =false;
    Table(String tableName , String dbPath){
        this.tableName = tableName ;
        this.dbPath = dbPath ;
        createTable();
    }
    public String getPath(){
        return dbPath + "/" + tableName ;
    }
    public void createTable(){
        File file = new File(dbPath + "/" + tableName + ".csv");
        if (file.exists()){
            System.out.println("the table " +tableName + "already exits");
        }else {
            try {
                file.createNewFile();

            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void deletTable(){
        File file = new File(dbPath + "/" + tableName + ".csv");
        if (!file.exists()){
            System.out.println("the table " +tableName + " does not exist");
        }else if(file.delete()){
            System.out.println("the table " + tableName + " is deleted successfully");
        }
    }

    public void defineColumns(String[] columns){
        if (!this.columnsDefined){

        try (FileWriter file = new FileWriter(dbPath + "/" + tableName + ".csv" ) ;){
            for (int i = 0 ; i < columns.length ; i++){
                file.append(columns[i])
                        .append(i < columns.length - 1 ? "," : "\n");            }
            this.columnsDefined = true ;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }
    }
    public void insertOne(String[] values){
        if (!this.columnsDefined){
            System.out.println("you must define the columns first") ;
        }else {
            try(FileWriter file = new FileWriter(dbPath+"/"+tableName+".csv" , true);){
            for (int i=0 ; i < values.length ; i++ ){
                file.append(values[i])
                        .append(i < values.length - 1 ? "," : "\n");             }
            System.out.println("the values are inserted");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
    public void insertMany(String[][] values){
        if (!this.columnsDefined){
            System.out.println("you must define the columns first") ;
        }else {
            try(FileWriter file = new FileWriter(dbPath+"/"+tableName+".csv" , true);){
                for (String[] line : values){
                    for (int j=0 ; j < line.length ; j++){
                        file.append(line[j])
                                .append(j < values.length - 1 ? "," : "\n");
                    }
                }
                System.out.println("the values are inserted");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
